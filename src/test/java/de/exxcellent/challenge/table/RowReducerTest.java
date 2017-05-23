package de.exxcellent.challenge.table;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Row Reducer class
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class RowReducerTest {

    @Test
    public void shouldAddCellValues() {
        Row row = new Row(new String[]{"a", "1", "2"});
        RowReducer reducer = new RowReducer(RowReducer.ADD, row, new int[]{1, 2});
        int result = reducer.execute();

        Assert.assertEquals(
                "1 + 2 = 3",
                3,
                result
        );
    }

    @Test
    public void shouldSubtractCellValues() {
        Row row = new Row(new String[]{"a", "5", "3"});
        RowReducer reducer = new RowReducer(RowReducer.SUBTRACT, row, new int[]{1, 2});
        int result = reducer.execute();

        Assert.assertEquals(
                "5 - 3 = 2",
                2,
                result
        );
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowNumberFormatException() throws NumberFormatException {
        Row row = new Row(new String[]{"a", "1.0", "2"});
        RowReducer reducer = new RowReducer(RowReducer.ADD, row, new int[]{1, 2});
        reducer.execute();
    }

}
