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

    @Test
    public void shouldReturnARowByIndex() {
        String[] headers = {"A"};
        String[][] rows = {{"1"}};

        Table table = new Table(headers, rows);

        Assert.assertEquals(
                "Should return the correct row",
                "1",
                table.getRow(0).getCells()[0].getValue()
        );
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBounds() throws IndexOutOfBoundsException {
        String[] headers = {"A"};
        String[][] rows = {{"1"}};

        Table table = new Table(headers, rows);
        table.getRow(1);
    }

    @Test
    public void shouldSortRowsWithGivenReducer() {
        String[] headers = {"A", "B", "C", "D", "E"};
        String[][] rows = {
                {"4", "4", "4", "4", "4"},
                {"3", "3", "3", "3", "3"},
                {"2", "2", "2", "2", "2"},
                {"1", "1", "1", "1", "1"}
        };

        Table table = new Table(headers, rows);
        RowReducer reducer = new RowReducer(RowReducer.ADD, new int[]{0, 1, 2, 3, 4});

        table.sort(reducer);

        Assert.assertEquals(
                "Last row should be the first row now",
                "1",
                table.getRow(0).getCells()[0].getValue()
        );
    }
}
