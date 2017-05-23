package de.exxcellent.challenge.table;

import org.junit.Test;
import org.junit.Assert;

/**
 * Test for the Table class.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class TableTest {
    @Test
    public void shouldCreateHeaderMapWithColumnIndices() {
        String[] headers = {
                "Hello",
                "World"
        };
        String[][] rows = {
                { "John", "Doe" },
                { "Jane", "Doe" }
        };
        Table table = new Table(headers, rows);

        Assert.assertEquals(
                "Index of column 'Hello' should be 0.",
                0,
                table.getHeaders().get("Hello").intValue()
        );
        Assert.assertEquals(
                "Index of column 'World' should be 1.",
                1,
                table.getHeaders().get("World").intValue()
        );
    }

    @Test
    public void shouldContainAllRows() {
        String[] headers = {
                "Header A",
                "Header B",
                "Header C"
        };
        String[][] rows = {
                { "John Doe", "1", "1.0" },
                { "Jane Doe", "2", "2.0" }
        };
        Table table = new Table(headers, rows);

        Assert.assertEquals(
                "Number of rows should equal the number of rows provided in the constructor.",
                2,
                table.getRows().length
        );

        Assert.assertEquals(
                "The table's cells should contain the correct data.",
                "Jane Doe",
                table.getRows()[1].getCells()[0].getValue()
        );
    }
}
