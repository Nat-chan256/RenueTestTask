package ru.moskovka.airportbrowser.controller;

import java.util.List;

/**
 * The interlayer between View and Model.
 */
public interface Controller {

    /**
     * The method to return user's search result.
     * @param colIndex the index of column where to search.
     * @param line the substring to be matched
     * @return lines which contain line
     */
    List<List<String>> processQuery(int colIndex, String line);
}
