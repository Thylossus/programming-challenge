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

    @Override
    public int compare(Row a, Row b) {
        return 0;
    }
}
