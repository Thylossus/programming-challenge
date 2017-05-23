package de.exxcellent.challenge.table;

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

    public Table(String[] headers, String[][] rows) {

    }


    public Map<String, Integer> getHeaders() {
        return headers;
    }

    public Row[] getRows() {
        return rows;
    }
}
