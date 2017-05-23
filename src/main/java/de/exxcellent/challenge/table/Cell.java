package de.exxcellent.challenge.table;

/**
 * Cell class
 *
 * Represents a cell in a CSV file.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class Cell {

    private String value;

    /**
     * Populate the cell with the provided value.
     * NOTE: the cell's value may be of any type, but since it is read from a file, all values are encoded
     * as strings at first. Parsing is necessary if other data types need to be inferred from the string value.
     *
     * @param value The cell's value as a string.
     */
    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
