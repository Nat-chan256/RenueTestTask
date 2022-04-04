package ru.moskovka.airportbrowser.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Represents the data.
 */
public interface Model {

    /**
     * Reads file content to search required rows.
     * @param colIndex index of column to filter on
     * @param prefix substring that required rows must contain
     * @return list of rows where column with index colIndex starts with prefix
     * @throws IOException
     */
    List<List<String>> getFiltered(int colIndex, String prefix) throws IOException;
}
