package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.dto.SpotifySong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SpotifySongService {
    public void sendToKafka(SpotifySong song) throws JsonProcessingException {
        Properties properties = new Properties();

        try (InputStream input = SpotifySongService.class.getResourceAsStream("/kafka.properties");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(song);

        System.out.println(json);

        ProducerRecord<String, String> songRecord = new ProducerRecord<>("songs", json);

        producer.send(songRecord);

        producer.flush();
        producer.close();
    }
}
