package de.exxcellent.challenge;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Test for the CSV File class.
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class CsvFileTest {

    private Path testFilePath;

    /**
     * Finds the path to the test file.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.testFilePath = Paths.get("src/test/resources/test.csv");
    }

    @Test(expected = FileNotFoundException.class)
    public void loadShouldFailIfFileNotExistent() throws FileNotFoundException {
        CsvFile file = new CsvFile(Paths.get("src/test/resources/notexistent.csv"), ",");
        file.load();
    }
}