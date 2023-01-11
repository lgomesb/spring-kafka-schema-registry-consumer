package pt.com.poc.schemaregistry.kafkaconsumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication implements CommandLineRunner {
	
	private static final String TOPIC = "taxpayer-avro-topic";

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Properties props = new Properties();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-test-registry");


		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", "http://localhost:8081");

		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
				
		final Consumer<String, GenericRecord> consumer = new KafkaConsumer<String, GenericRecord>(props);
		consumer.subscribe(Arrays.asList(TOPIC));

		try {
			while (true) {
				ConsumerRecords<String, GenericRecord> records = consumer.poll(100);
				for (ConsumerRecord<String, GenericRecord> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), record.value());
				}
			}
		} finally {
			consumer.close();
		}
	}

}
