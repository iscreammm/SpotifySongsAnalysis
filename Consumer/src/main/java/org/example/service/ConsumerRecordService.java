package org.example.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.example.Consumer;
import org.example.dto.SpotifySong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsumerRecordService {
    private static final String INDEX = "songs";
    private boolean exists = false;
    public void store(SpotifySong song) throws IOException {
        StringBuilder builder = new StringBuilder("http://");
        try (InputStream input = Consumer.class.getResourceAsStream("/elastic.properties");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            builder.append(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestClient restClient = RestClient
                .builder(HttpHost.create(builder.toString()))
                .build();
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        ElasticsearchClient client = new ElasticsearchClient(transport);

        if (!exists) {
            try {
                client.indices().create(c -> c.index(INDEX));
            } catch (ElasticsearchException e) {
                exists = true;
            }
        }

        client.index(i -> i
                .index(INDEX)
                .id(song.getTrackId())
                .document(song));
    }
}
