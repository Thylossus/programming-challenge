package de.exxcellent.challenge;

import de.exxcellent.challenge.table.Row;
import de.exxcellent.challenge.table.RowReducer;
import de.exxcellent.challenge.table.Table;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        CsvFile weatherFile = new CsvFile(Paths.get("src/main/resources/weather.csv"), ",");
        try {
            Table weatherTable = weatherFile.load();
            int dayColumn = weatherTable.getHeaders().get("Day");
            int maxColumn = weatherTable.getHeaders().get("MxT");
            int minColumn = weatherTable.getHeaders().get("MnT");
            RowReducer reducer = new RowReducer(RowReducer.SUBTRACT, new int[]{maxColumn, minColumn});
            weatherTable.sort(reducer);
            Row smallestRow = weatherTable.getRow(0);
            dayWithSmallestTempSpread = smallestRow.getCells()[dayColumn].getValue();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the weather table.");
        }

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
