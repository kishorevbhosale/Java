package basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public class ProducerDemoKey {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //create properties
        String bootstrapServer = "127.0.0.1:9092";

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //create producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);


        //create producer record
        for (int i = 100; i < 110; i++) {
            String topic = "second_topic";
            String value = "hello world test -" + i;
            String key = "id_" + i;
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

            log.info("Key :" + key);
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        log.info("data :\n Topic: " + recordMetadata.topic() +
                                "\n Patition : " + recordMetadata.partition() +
                                "\n Offset : " + recordMetadata.offset() +
                                "\n TimeStamp : " + recordMetadata.timestamp());
                    } else {
                        log.error("Error : ", e);
                    }
                }
            }).get();
        }

        producer.flush();
        producer.close();

    }
}
