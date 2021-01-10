package basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ConsumerDemoWithThread {
    private ConsumerDemoWithThread() {

    }

    public static void main(String[] args) {
        new ConsumerDemoWithThread().run();
    }

    private void run() {
        String bootstrapServer = "127.0.0.1:9092";
        String groupId = "group";
        String topic = "second_topic";

        // Latch for dealing with multiple threads
        CountDownLatch latch = new CountDownLatch(1);

        // Creates consumer runnable
        log.info("Creating the consumer");
        Runnable myConsumerThread = new ConsumerThread(latch, bootstrapServer, groupId, topic);

        // Starting thread
        Thread thread = new Thread(myConsumerThread);
        thread.start();

        // Shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Caught shutdown hook");
            ((ConsumerThread) myConsumerThread).shutDown();
        }));

        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Application interrupted - Error : ", e);
        } finally {
            log.info("Application is closing");
        }
    }

    public class ConsumerThread implements Runnable {
        KafkaConsumer<String, String> consumer;
        private CountDownLatch latch;

        public ConsumerThread(CountDownLatch latch, String bootstrapServer, String groupId, String topic) {
            this.latch = latch;
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
            consumer = new KafkaConsumer<>(properties);
            consumer.subscribe(Arrays.asList(topic));
        }

        @Override
        public void run() {
            // poll for new data
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                    for (ConsumerRecord<String, String> record : records) {
                        log.info("Key : " + record.key() + " value : " + record.value());
                        log.info("Partition : " + record.partition() + " offset : " + record.offset());
                    }
                }
            } catch (WakeupException e) {
                log.info("E : ", e);
            } finally {
                consumer.close();
                latch.countDown();
            }
        }

        public void shutDown() {
            //wakeup is special method to interrupt consumer.poll()
            //it will throw WakeupException
            consumer.wakeup();
        }
    }

}
