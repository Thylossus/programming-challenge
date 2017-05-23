package de.exxcellent.challenge.table;

import java.util.HashMap;
import java.util.Map;

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


    public Map<String, Integer> getHeaders() {
        return headers;
    }

    public Row[] getRows() {
        return rows;
    }
}
