package ru.moskovka.airportbrowser.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The model that stores the file with the airports info.
 */
public class AirportModel implements Model{

    private String filename;
    private InputStream inputStream;
    private List<List<String>> table;

    public AirportModel(InputStream inputStream){
        this.inputStream = inputStream;
        try {
            readTableFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public AirportModel(String filename){
        this.filename = filename;
        try {
            readTableFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> getTable() {
        return new ArrayList<>(table);
    }

    /**
     * Accesses the column with colNumber index.
     *
     * @param colIndex the column to return.
     * @return column with colNumber index.
     */
    @Override
    public String[] getColumn(int colIndex) {
        String[] column = new String[table.size()];
        for (int i = 0; i < table.size(); ++i)
            column[i] = table.get(i).get(colIndex);
        return column;
    }

    private void readTableFromFile() throws FileNotFoundException {
        table = new ArrayList<>();
        if (filename != null)
            inputStream = new FileInputStream(new File(filename));
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))){
            String line;
            while ((line = reader.readLine()) != null){
                table.add(Arrays.asList(line.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
