package ru.moskovka.airportbrowser.controller;

import ru.moskovka.airportbrowser.model.AirportModel;
import ru.moskovka.airportbrowser.model.Model;

import java.util.List;
import java.util.stream.Collectors;

public class AirportController implements Controller {
    private Model model;

    public AirportController(Model model){
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
    public List<List<String>> processQuery(int colIndex, String line) {
        List<List<String>> table = ((AirportModel)model).getTable();
        return table.stream()
                .filter((row) -> row.get(colIndex).contains(line)).collect(Collectors.toList());
    }
}
