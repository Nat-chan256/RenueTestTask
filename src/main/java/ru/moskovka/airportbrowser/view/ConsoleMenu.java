package ru.moskovka.airportbrowser.view;

import ru.moskovka.airportbrowser.controller.Controller;
import ru.moskovka.airportbrowser.util.PropertyReader;
import ru.moskovka.airportbrowser.util.Sorter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu implements Menu{

    private final String PROPERTIES_FILE_NAME = "application.yml";
    private final String COLUMN_NUMBER = "columnNumber";

    private Controller controller;
    private Scanner scanner;
    private long t1, t2;

    public ConsoleMenu(Controller controller){
        scanner = new Scanner(System.in);
        this.controller = controller;
    }

    /**
     * The method to display all menu points.
     */
    @Override
    public void display(String[] args) {
        int columnNumber = 0;
        if (args.length > 0){
            try {
                columnNumber = Integer.parseInt(args[0]);
            } catch(NumberFormatException ex){
                System.out.println("Аргумент программы должен быть числом.");
                return;
            }
        }
        else{
            try {
                columnNumber = PropertyReader.readInt(PROPERTIES_FILE_NAME, COLUMN_NUMBER);
            } catch(NumberFormatException ex){
                System.out.println("Некорректно задан номер столбца в файле application.yml.\n" +
                        "Пожалуйста, введите номер столбца в качестве аргумента программы.");
                return;
            } catch(IOException | NullPointerException ex){
                System.out.println("Файл с параметрами программы не найден.\n" +
                        "Пожалуйста, введите номер столбца в качестве аргумента программы.");
                return;
            }
        }
        System.out.print("Введите строку: ");
        String userQuery = scanner.nextLine();
        t1  = System.currentTimeMillis();
        List<List<String>> result = controller.processQuery(columnNumber-1, userQuery);
        t2 = System.currentTimeMillis();
        Sorter.sortByColumn(result, columnNumber-1);
        outputRows(result);
        System.out.println("\nКоличество найденных строк: " + result.size());
        System.out.println("Время, затраченное на поиск: " + (t2 - t1) + " мс");
    }

    private void outputRows(List<List<String>> rows){
        for (List<String> row : rows){
            for (String item : row)
                System.out.print(item + "\t");
            System.out.println();
        }
    }
}
