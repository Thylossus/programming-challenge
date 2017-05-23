package de.exxcellent.challenge.table;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for Row class
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class RowTest {

    @Test
    public void shouldContainAllCells() {
        String[] cells = {"A", "B", "C", "1", "1.0"};
        Row row = new Row(cells);

        Assert.assertEquals(
                "Should have all cells that have been provided in the constructor.",
                cells.length,
                row.getCells().length
        );
    }
}
