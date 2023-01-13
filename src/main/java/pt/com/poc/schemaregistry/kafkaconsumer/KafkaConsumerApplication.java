package pt.com.poc.schemaregistry.kafkaconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

@SpringBootApplication
public class KafkaConsumerApplication implements CommandLineRunner {
	
	private static final String TOPIC = "taxpayer-avro-topic";

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Properties props = new Properties();

		// props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		// props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-test-registry");
		// props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		// props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
		// props.put("schema.registry.url", "http://localhost:8081");
		// props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		// try ( KafkaConsumer<String,GenericRecord> topicConsumer = new KafkaConsumer<>(props) ) {
		// 	topicConsumer.subscribe(Arrays.asList(TOPIC));		
		// 	while(true) {
		// 		ConsumerRecords<String, GenericRecord> records = topicConsumer.poll(Duration.ofSeconds(1));
		// 		for (ConsumerRecord<String, GenericRecord> record : records) {
		// 			System.out.println( "::::::::::::: KAFKA CONSUMER::::::::::::");
		// 			System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.topic(), record.value());
		// 		}				
		// 	}			
		// }

	}

}
