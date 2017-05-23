package de.exxcellent.challenge.table;

import java.util.Comparator;

/**
 * Row Comparator class
 *
 * This class allows comparing rows with each other for a given row reducer.
 */
public class RowComparator implements Comparator<Row> {
    private RowReducer reducer;

    public RowComparator(RowReducer reducer) {
        this.reducer = reducer;
    }

    /**
     * Compare row a with row b based on the result of the reducer.
     * This comparator will result in an ascending sort order.
     *
     * @param a Row a
     * @param b Row b
     * @return The comparison result (a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second)
     */
    @Override
    public int compare(Row a, Row b) {
        return this.reducer.execute(a) - this.reducer.execute(b);
    }
}
