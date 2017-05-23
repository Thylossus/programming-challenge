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

        Analyzer weatherAnalyzer = new Analyzer(
                Paths.get("src/main/resources/de/exxcellent/challenge/weather.csv"),
                "Day",
                new String[]{"MxT", "MnT"}
        );
        Analyzer footballAnalyzer = new Analyzer(
                Paths.get("src/main/resources/de/exxcellent/challenge/football.csv"),
                "Team",
                new String[]{"Goals", "Goals Allowed"}
        );

        String dayWithSmallestTempSpread = weatherAnalyzer.getSmallestDifferenceOutputCellValue();
        String teamWithSmallestGoalSpread = footballAnalyzer.getSmallestDifferenceOutputCellValue();

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
