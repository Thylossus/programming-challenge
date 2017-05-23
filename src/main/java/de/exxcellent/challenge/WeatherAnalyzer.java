package de.exxcellent.challenge;

import de.exxcellent.challenge.table.Row;
import de.exxcellent.challenge.table.RowReducer;
import de.exxcellent.challenge.table.Table;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Weather Analyzer class
 *
 * Analyzes a CSV file with weather data and outputs the day with the smallest variance in temperature.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class WeatherAnalyzer {

    private CsvFile weatherFile;

    public WeatherAnalyzer(Path pathToCsv) {
        this.weatherFile = new CsvFile(pathToCsv, ",");
    }

    public String getDayWithSmallestTemperatureSpread() {
        try {
            Table weatherTable = weatherFile.load();
            int dayColumn = weatherTable.getHeaders().get("Day");
            int maxColumn = weatherTable.getHeaders().get("MxT");
            int minColumn = weatherTable.getHeaders().get("MnT");
            RowReducer reducer = new RowReducer(RowReducer.SUBTRACT, new int[]{maxColumn, minColumn});
            weatherTable.sort(reducer);
            Row smallestRow = weatherTable.getRow(0);
            return smallestRow.getCells()[dayColumn].getValue();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the weather table.");
            return "";
        }
    }

}
