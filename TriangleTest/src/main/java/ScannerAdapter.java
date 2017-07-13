import java.util.Scanner;

/**
 * Wrapper of Scanner.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 04.11.2016
 */
public class ScannerAdapter {
    Scanner in;

    /**
     * Constructor of class.
     *
     * @param in text scanner.
     */
    public ScannerAdapter(Scanner in) {
        this.in = in;
    }

    /**
     * Default constructor.
     */
    public ScannerAdapter() {}

    /**
     * @return entered string.
     */
    public String next() {
        return in.next();
    }
}
