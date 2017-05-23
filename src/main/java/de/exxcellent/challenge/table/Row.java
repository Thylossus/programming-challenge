package de.exxcellent.challenge.table;

/**
 * Row class
 *
 * Represents a row in a CSV file.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class Row {

    private Cell[] cells;

    public Row(String[] cells) {

    }


    public Cell[] getCells() {
        return cells;
    }
}
