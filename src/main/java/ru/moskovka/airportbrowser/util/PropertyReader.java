package ru.moskovka.airportbrowser.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PropertyReader {

    private static Map<String, String> fileContent;

    public static int readInt(String filename, String propertyName) throws NumberFormatException, IOException {
        if (fileContent == null)
            fileContent = readMapFromYaml(filename);
        return Integer.parseInt(fileContent.get(propertyName));
    }

    private static Map<String, String> readMapFromYaml(String filename) throws IOException, NullPointerException {
        InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(filename);
        Map<String, String> content = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))){
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.contains(":")){
                    String[] splitted = line.split(":");
                    content.put(splitted[0].trim(), splitted[1].trim());
                }
            }
        }
        return content;
    }
}
