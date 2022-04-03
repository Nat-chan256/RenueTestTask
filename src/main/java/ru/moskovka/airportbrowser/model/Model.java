package ru.moskovka.airportbrowser.model;

/**
 * Represents the data.
 */
public interface Model {

    /**
     * Accesses the column with colIndex index.
     * @param colIndex the column to return.
     * @return column with colIndex index.
     */
    String[] getColumn(int colIndex);
}
