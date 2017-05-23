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

    /**
     * Populate the row by setting the cells.
     *
     * @param cells A list of strings that represent cell values.
     */
    public Row(String[] cells) {
        if (cells == null) {
            cells = new String[]{};
        }

        this.cells = new Cell[cells.length];

        for (int i = 0; i < cells.length; i++) {
            this.cells[i] = new Cell(cells[i]);
        }
    }


    public Cell[] getCells() {
        return cells;
    }
}
