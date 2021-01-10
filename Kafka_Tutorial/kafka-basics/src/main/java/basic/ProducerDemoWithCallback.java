package basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@Slf4j
public class ProducerDemoWithCallback {
    public static void main(String[] args) {
        // config
        String bootstrapServer = "127.0.0.1:9092";

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 50; i++) {


            //create producer record
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("second_topic", "hello world test With Callback -"+i);

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
            });
        }

        producer.flush();
        producer.close();
    }
}
