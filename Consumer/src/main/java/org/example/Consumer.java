package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.dto.SpotifySong;
import org.example.service.ConsumerRecordService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Consumer {
    private final static ConsumerRecordService service = new ConsumerRecordService();

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        try (InputStream input = Consumer.class.getResourceAsStream("/kafka.properties");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumer-app");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1000");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(List.of("songs"));

        while (true) {
            ConsumerRecords<String, String> songRecords = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, String> songRecord : songRecords) {
                ObjectMapper objectMapper = new ObjectMapper();
                SpotifySong song = objectMapper.readValue(songRecord.value(), SpotifySong.class);

                service.store(song);
            }
        }
    }
}
