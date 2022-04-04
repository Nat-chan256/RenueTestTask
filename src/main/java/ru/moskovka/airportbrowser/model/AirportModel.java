package ru.moskovka.airportbrowser.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The model that stores the file with the airports info.
 */
public class AirportModel implements Model{

    private final InputStream inputStream;

    public AirportModel(final InputStream inputStream){
        this.inputStream = inputStream;
    }


    @Override
    public List<List<String>> getFiltered(final int colIndex, final String prefix) throws IOException {
        final List<List<String>> filtered = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] splitted = line.split(",");
                if (splitted[colIndex].replace("\"", "").startsWith(prefix))
                    insert(filtered, Arrays.asList(splitted), colIndex);
            }
        }
        return filtered;
    }

    // Inserts element into list so that it keeps sorted
    private void insert(final List<List<String>> list, final List<String> elem, final int indexToSortBy){
        int index = 0;
        String elemColValue = elem.get(indexToSortBy);
        while (index < list.size() && list.get(index).get(indexToSortBy).compareTo(elemColValue) < 0)
            index++;
        list.add(index, elem);
    }
}
