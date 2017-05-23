package de.exxcellent.challenge.util;

import java.io.PrintStream;

/**
 * Printable interface
 *
 * Interface that allows to print an object to the provided stream.
 *
 * @author Tobias Kahse <tobias.kahse@outlook.com>
 */
public interface Printable {
    /**
     * Print a string representation of the object to the provided stream.
     *
     * @param out Output stream
     */
    void print(PrintStream out);
}
