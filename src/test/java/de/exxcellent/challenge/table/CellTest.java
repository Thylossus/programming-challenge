package de.exxcellent.challenge.table;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for Cell class
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class CellTest {

    @Test
    public void shouldContainValue() {
        Cell cell = new Cell("a");

        Assert.assertEquals(
                "Should contain the value that was provided in the constructor.",
                "a",
                cell.getValue()
        );
    }
}
