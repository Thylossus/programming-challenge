package de.exxcellent.challenge.table;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for Row Comparator class
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class RowComparatorTest {
// a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
    private Row rowA;
    private Row rowB;
    private RowComparator comparator;

    @Before
    public void setUp() {
        this.rowA = new Row(new String[]{"1", "2", "3"});
        this.rowB = new Row(new String[]{"4", "5", "6"});
        RowReducer reducer = new RowReducer(RowReducer.ADD, new int[]{0, 1, 2});
        this.comparator = new RowComparator(reducer);
    }

    @Test
    public void shouldReturnANegativeIntegerIfTheFirstArgumentIsLessThanTheSecond() {
        int result = this.comparator.compare(this.rowA, this.rowB);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void shouldReturnAPositiveIntegerIfTheFirstArgumentIsGreaterThanTheSecond() {
        int result = this.comparator.compare(this.rowB, this.rowA);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void shouldReturnZeroIfBothRowsAreEqual() {
        int result = this.comparator.compare(this.rowA, this.rowA);
        Assert.assertTrue(result == 0);
    }

}
