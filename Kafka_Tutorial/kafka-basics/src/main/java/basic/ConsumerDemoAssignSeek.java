package basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Slf4j
public class ConsumerDemoAssignSeek {
    public static void main(String[] args) {
        //create properties
        String bootstrapServer = "127.0.0.1:9092";
        String topic = "second_topic";

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId); - no need
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        //assign
        TopicPartition topicPartition = new TopicPartition(topic,0);
        long offsetToReadFrom = 15L;
        consumer.assign(Arrays.asList(topicPartition));

        //seek
        consumer.seek(topicPartition,offsetToReadFrom);

        int numberOfMessageToRead = 5;
        boolean keepOnReading = true;
        int numberOfMessageReadSoFar = 0;

        // poll the new data

        while (keepOnReading) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String,String> record :records) {
                numberOfMessageReadSoFar +=1;
                log.info("Key : "+record.key()+" value : "+record.value());
                log.info("Partition : "+record.partition()+" offset : "+record.offset());
                if (numberOfMessageReadSoFar >= numberOfMessageToRead){
                    keepOnReading = false;
                    break;
                }
            }
        }
        log.info("Exiting reading");

    }
}
