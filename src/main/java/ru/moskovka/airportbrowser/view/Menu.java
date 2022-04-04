package ru.moskovka.airportbrowser.view;

import java.io.IOException;

/**
 * The interface that represents abstract menu.
 */
public interface Menu {

    /**
     * The method to display all menu points.
     */
    void display(String[] args) throws IOException;

}
