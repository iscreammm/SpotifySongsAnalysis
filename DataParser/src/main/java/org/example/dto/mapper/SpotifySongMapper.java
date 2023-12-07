package org.example.dto.mapper;

import org.example.dto.SpotifySong;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SpotifySongMapper {
    public SpotifySong map(String data) throws ParseException {
        String[] parameters = getParams(data);

        SimpleDateFormat dateFormat;
        if (parameters[6].length() == 4) {
            dateFormat = new SimpleDateFormat("yyyy");
        } else if (parameters[6].length() == 7) {
            dateFormat = new SimpleDateFormat("yyyy-MM");
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }

        for (String param : parameters) {
            System.out.println(param);
        }

        return new SpotifySong(parameters[0], parameters[1], parameters[2], Double.parseDouble(parameters[3]),
                parameters[4], parameters[5], new Timestamp(dateFormat.parse(parameters[6]).getTime()), parameters[7],
                parameters[8], parameters[9], parameters[10], Double.parseDouble(parameters[11]),
                Double.parseDouble(parameters[12]), Double.parseDouble(parameters[13]),
                Double.parseDouble(parameters[14]), Double.parseDouble(parameters[15]),
                Double.parseDouble(parameters[16]), Double.parseDouble(parameters[17]),
                Double.parseDouble(parameters[18]), Double.parseDouble(parameters[19]),
                Double.parseDouble(parameters[20]), Double.parseDouble(parameters[21]),
                Double.parseDouble(parameters[22]));
    }

    private String[] getParams(String data) {
        String[] params = data.split(",");

        if (params.length > 23) {
            String[] tmp = new String[23];
            int size = 0;

            boolean isInner = false;

            int start = 0;
            int end = -1;

            for (int i = 0; i < params.length; i++) {
                if (!params[i].contains("\"") && !isInner) {
                    tmp[size++] = params[i];
                    continue;
                }
                if (params[i].charAt(0) == '\"') {
                    start = i;
                    isInner = true;
                }
                if (params[i].charAt(params[i].length() - 1) == '\"') {
                    end = i;
                }
                if (start <= end) {
                    StringBuilder builder = new StringBuilder();

                    for (;start <= end; start++) {
                        builder.append(params[start]);

                        if (start != end) {
                            builder.append(',');
                        }
                    }

                    tmp[size++] = builder.toString();
                    isInner = false;
                }
            }

            params = tmp;
        }

        return params;
    }
}
