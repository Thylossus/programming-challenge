package de.exxcellent.challenge.table;

/**
 * Row Reducer class
 *
 * This class allows to reduce a row to a single value by combining its
 * cells with a specific operation.
 *
 * @author Tobias Kahse
 */
public class RowReducer<T extends Number> {
    public static final String ADD = "add";
    public static final String SUBTRACT = "sub";

    public RowReducer(String operation, Row row, int[] cellIndices) {

    }

    public T execute() throws NumberFormatException {
        return null;
    }
}
