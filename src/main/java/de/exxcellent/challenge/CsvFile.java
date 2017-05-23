package de.exxcellent.challenge;

import de.exxcellent.challenge.table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

/**
 * CSV File class
 *
 * This class allows to read a CSV file and convert its contents into an in-memory table representation.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class CsvFile {

    private Path path;
    private String delimiter;
    private Table content;

    public CsvFile(Path path, String delimiter) {
        this.path = path;
        this.delimiter = delimiter;
    }

    public Table load() throws FileNotFoundException {
        File csvFile = this.path.toFile();

        if (!csvFile.exists()) {
            throw new FileNotFoundException("Could not find file at " + this.path.toString());
        }

        return new Table(null, null);
    }

}
