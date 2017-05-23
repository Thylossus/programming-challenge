package de.exxcellent.challenge;

import de.exxcellent.challenge.table.Table;
import org.junit.Assert;
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

    @Test
    public void loadShouldPopulateATableWithCorrectValues() throws FileNotFoundException {
        CsvFile file = new CsvFile(this.testFilePath, ",");
        Table table = file.load();

        // NOTE: the following assumptions refer to the content of test.csv
        // test.csv has three columns and two rows (+ 1 header row)
        Assert.assertEquals(
                "The table should have three headers",
                3,
                table.getHeaders().size()
        );

        Assert.assertEquals(
                "The table should have two rows",
                2,
                table.getRows().length
        );

        Assert.assertEquals(
                "The second header should be 'Header B'",
                "Header B",
                table.getHeaders().values().toArray()[1]
        );

        Assert.assertEquals(
                "The third cell in the second row has the value '4.0'",
                "4.0",
                table.getRows()[1].getCells()[2].getValue()
        );
    }
}