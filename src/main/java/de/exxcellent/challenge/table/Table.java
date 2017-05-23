package de.exxcellent.challenge.table;

import java.util.*;

/**
 * Table class
 *
 * Objects of this class serve as an in-memory representation for the content of a CSV file.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class Table {

    private Map<String, Integer> headers;
    private Row[] rows;

    /**
     * Populate the table with the provided strings.
     * @param headers A list of headers.
     * @param rows A list of rows where each row, in turn, is a list of strings.
     */
    public Table(String[] headers, String[][] rows) {
        if (headers == null) {
            headers = new String[]{};
        }

        if (rows == null) {
            rows = new String[][]{{}};
        }

        this.headers = new HashMap<>();

        for (int i = 0; i < headers.length; i++) {
            this.headers.put(headers[i], i);
        }

        this.rows = new Row[rows.length];
        for (int j = 0; j < rows.length; j++) {
            this.rows[j] = new Row(rows[j]);
        }
    }

    /**
     * Get a row by its index.
     *
     * @param index The row's index.
     * @return The row at the index.
     * @throws IndexOutOfBoundsException Throws if the index exceeds the length of the row array.
     */
    public Row getRow(int index) throws IndexOutOfBoundsException {
        if (index >= this.rows.length || index < 0) {
            throw new IndexOutOfBoundsException("The index " + index + " is invalid. There are " + this.rows.length + " rows");
        }

        return this.rows[index];
    }

    /**
     * Sort the rows in the table with the given reducer.
     * The reducer is used to calculate a representation for each row.
     * This representation is then used by the row comparator.
     *
     * @param reducer Reducer object that allows to reduce a row to a single integer value.
     */
    public void sort(RowReducer reducer) {
        ArrayList<Row> rows = new ArrayList<>(Arrays.asList(this.rows));
        rows.sort(new RowComparator(reducer));
        this.rows = rows.toArray(new Row[rows.size()]);
    }

    public Map<String, Integer> getHeaders() {
        return headers;
    }

    public Row[] getRows() {
        return rows;
    }
}
