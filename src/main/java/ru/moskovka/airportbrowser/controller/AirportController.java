package ru.moskovka.airportbrowser.controller;

import ru.moskovka.airportbrowser.model.Model;

import java.io.IOException;
import java.util.List;

public class AirportController implements Controller {
    private final Model model;

    public AirportController(final Model model){
        this.model = model;
    }

    /**
     * The method to return user's search result.
     *
     * @param colIndex the index of column where to search.
     * @param line      the substring to be matched
     * @return lines which contain line
     */
    @Override
    public List<List<String>> processQuery(final int colIndex, final String line) throws IOException {
        return model.getFiltered(colIndex, line);
    }
}
