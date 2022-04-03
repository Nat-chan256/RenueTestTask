package ru.moskovka.airportbrowser.util;

import java.util.Comparator;
import java.util.List;

/**
 * Class that performs sort.
 */
public class Sorter {
    public static void sortByColumn(List<List<String>> table, int columnIndex){
        table.sort(Comparator.comparing(row -> row.get(columnIndex)));
    }
}
