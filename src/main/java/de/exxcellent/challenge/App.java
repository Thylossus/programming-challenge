package de.exxcellent.challenge;

import java.nio.file.Paths;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        WeatherAnalyzer analyzer = new WeatherAnalyzer(Paths.get("src/main/resources/de/exxcellent/challenge/weather.csv"));

        String dayWithSmallestTempSpread = analyzer.getDayWithSmallestTemperatureSpread();
        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …



        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
