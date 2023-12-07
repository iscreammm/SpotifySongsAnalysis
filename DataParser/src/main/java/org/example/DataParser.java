package org.example;

import org.example.dto.SpotifySong;
import org.example.dto.mapper.SpotifySongMapper;
import org.example.service.SpotifySongService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

public class DataParser
{
    private static final SpotifySongMapper mapper = new SpotifySongMapper();
    private static final SpotifySongService service = new SpotifySongService();

    public static void main( String[] args ) {
        try (InputStream input = DataParser.class.getResourceAsStream("/spotify_songs.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String data;

            while ((data = reader.readLine()) != null) {
                SpotifySong song = mapper.map(data);
                service.sendToKafka(song);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
