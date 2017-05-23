package de.exxcellent.challenge.table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Row Reducer class
 *
 * This class allows to reduce a row to a single value by combining its
 * cells with a specific operation.
 *
 * NOTE: at the moment, only integer values are supported.
 *
 * @author Tobias Kahse
 */
public class RowReducer {
    public static final String ADD = "add";
    public static final String SUBTRACT = "sub";

    private String operation;
    private int[] cellIndices;

    public RowReducer(String operation, int[] cellIndices) {
        this.operation = operation;
        this.cellIndices = cellIndices;
    }

    /**
     * Execute the reduction operation on the row.
     * This is done by converting string values into integers and by applying a reduce operation.
     *
     * @param row The row on which the operation shall be performed.
     *
     * @return The result of the reduction.
     * @throws NumberFormatException If a cell value cannot be converted to an integer.
     * @throws UnsupportedOperationException If an unsupported operation is requested.
     */
    public int execute(Row row) throws NumberFormatException, UnsupportedOperationException {
        List<Integer> values = new ArrayList<>(this.cellIndices.length);
        Cell[] cells = row.getCells();

        for (int index : this.cellIndices) {
            int value = Integer.parseInt(cells[index].getValue());
            values.add(value);
        }

        Stream<Integer> valueStream = values.stream();

        switch (this.operation) {
            case ADD:
                return valueStream.reduce(0, Integer::sum);
            case SUBTRACT:
                // NOTE: 2 * values.get(0) is necessary as the start value because all numbers are subtracted from
                // this value, i.e. [5, 3, 4] results in 0 - 5 - 3 - 4.
                // The required semantics, however, are: 5 - 3 - 4. This can be achieved by the code below because
                // 5 * 2 - 5 - 3 - 4 = 5 - 3 - 4.
                return valueStream.reduce(2 * values.get(0), (a, b) -> (a - b));
            default:
                throw new UnsupportedOperationException("The operation " + this.operation + " is not supported.");
        }
    }
}
