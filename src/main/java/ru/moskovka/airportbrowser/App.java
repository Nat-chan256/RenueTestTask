package ru.moskovka.airportbrowser;

import ru.moskovka.airportbrowser.controller.AirportController;
import ru.moskovka.airportbrowser.model.AirportModel;
import ru.moskovka.airportbrowser.view.ConsoleMenu;

import java.io.InputStream;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream("airports.dat");
        ConsoleMenu menu = new ConsoleMenu(
                new AirportController(
                        new AirportModel(inputStream)
                )
        );
        menu.display(args);
    }
}
