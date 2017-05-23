package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * Test for Weather Analyzer class
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class AnalyzerTest {

    @Test
    public void shouldReturnDayWithSmallestTemperatureSpread() {
        Analyzer analyzer = new Analyzer(
                Paths.get("src/test/resources/weather.csv"),
                "Day",
                new String[]{"MxT", "MnT"}
        );

        // In the reduced weather.csv at src/resources, the second day has the smallest temperature spread (16)
        Assert.assertEquals(
                "Should output the day with the smallest temperature spread.",
                "2",
                analyzer.getSmallestDifferenceOutputCellValue()
        );
    }

    @Test
    public void shouldReturnTeamWithSmallestDifferencesInGoals() {
        Analyzer analyzer = new Analyzer(
                Paths.get("src/test/resources/football.csv"),
                "Team",
                new String[]{"Goals", "Goals Allowed"}
        );

        // In the reduced football.csv at src/resources, Liverpool has the smallest difference between goals
        // and goals allowed (37)
        Assert.assertEquals(
                "Should output the day with the smallest temperature spread.",
                "Liverpool",
                analyzer.getSmallestDifferenceOutputCellValue()
        );
    }

}
