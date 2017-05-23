package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * Test for Weather Analyzer class
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class WeatherAnalyzerTest {

    @Test
    public void shouldReturnDayWithSmallestTemperatureSpread() {
        WeatherAnalyzer analyzer = new WeatherAnalyzer(Paths.get("src/test/resources/weather.csv"));

        // In the reduced weather.csv at src/resources, the second day has the smallest temperature spread (16)
        Assert.assertEquals(
                "Should output the day with the smallest temperature spread.",
                "2",
                analyzer.getDayWithSmallestTemperatureSpread()
        );
    }

}
