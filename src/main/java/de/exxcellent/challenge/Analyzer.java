package de.exxcellent.challenge;

import de.exxcellent.challenge.table.Row;
import de.exxcellent.challenge.table.RowReducer;
import de.exxcellent.challenge.table.Table;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Analyzer class
 *
 * Analyzes a CSV file, finds the row with the smallest difference between the values of two columns,
 * and returns the value of this row in the output column.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class Analyzer {

    private CsvFile csvFile;
    private String outputColumn;
    private String[] differenceColumns;

    public Analyzer(Path pathToCsv, String outputColumn, String[] differenceColumns) {
        this.csvFile = new CsvFile(pathToCsv, ",");
        this.outputColumn = outputColumn;
        this.differenceColumns = differenceColumns;
    }

    public String getSmallestDifferenceOutputCellValue() {
        try {
            Table table = csvFile.load();
            Map<String, Integer> headers = table.getHeaders();
            int outputColumnIndex = headers.get(this.outputColumn);
            int[] differenceColumnIndices = new int[this.differenceColumns.length];

            for (int i = 0; i < this.differenceColumns.length; i++) {
                differenceColumnIndices[i] = headers.get(this.differenceColumns[i]);
            }

            RowReducer reducer = new RowReducer(RowReducer.SUBTRACT, differenceColumnIndices);
            table.sort(reducer);
            Row smallestRow = table.getRow(0);
            return smallestRow.getCells()[outputColumnIndex].getValue();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the CSV file.");
            return "";
        }
    }

}
