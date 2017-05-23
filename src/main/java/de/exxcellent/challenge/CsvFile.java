package de.exxcellent.challenge;

import de.exxcellent.challenge.table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

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
        this.content = null;
    }

    /**
     * Load the CSV file and write its contents into a table representation.
     * Once loaded, all further calls to `load` query the cached results in
     * `this.content`.
     *
     * If an IO error occurs, the table will be empty.
     *
     * @return A table representation of the CSV file's contents.
     * @throws FileNotFoundException
     */
    public Table load() throws FileNotFoundException {
        if (this.content != null) {
            return this.content;
        }

        File csvFile = this.path.toFile();

        if (!csvFile.exists()) {
            throw new FileNotFoundException("Could not find file at " + this.path.toString());
        }

        // Iterate of lines in the file
        try (Stream<String> lines = Files.lines(this.path, Charset.defaultCharset())) {
            boolean headersRead = false;
            String[] headers = null;
            List<String[]> rows = new LinkedList<>();

            for (String line: (Iterable<String>) lines::iterator) {
                //System.out.println(Arrays.toString(line.split(this.delimiter)));

                if (headersRead) {
                    rows.add(line.split(this.delimiter));
                } else {
                    headers = line.split(this.delimiter);
                    headersRead = true;
                }
            }

            return new Table(headers, rows.toArray(new String[rows.size()][]));
        } catch (IOException ex) {
            // TODO: logging
            return new Table(null, null);
        }
    }

}
