package pt.com.poc.schemaregistry.kafkaconsumer.listeners;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerSchemaRegistryListener {
    
    @KafkaListener(topics = "${app.kafka.consumer.topic}")
    public void avroConsumer(ConsumerRecord<String, GenericRecord> record) {
			System.out.println( "::::::::::::: KAFKA CONSUMER::::::::::::");
 			System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.topic(), record.value());
		
    }

}
