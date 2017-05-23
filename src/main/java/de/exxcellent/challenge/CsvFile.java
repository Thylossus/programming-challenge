package de.exxcellent.challenge;

/**
 * CSV File class
 *
 * This class allows to read a CSV file and convert its contents into an in-memory table representation.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public class CsvFile {

    private String path;
    private String delimiter;
    private Table content;

    public CsvFile(String path, String delimiter) {
        this.path = path;
        this.delimiter = delimiter;
    }

    public Table load() {
        return new Table();
    }

}
