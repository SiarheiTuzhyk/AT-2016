import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class for input sides of triangle.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 04-11-2016
 */
public class InputSides {
    /**
     * This method is intended to enter sides of triangle.
     *
     * @param scannerAdapter text scanner.
     * @param size           count of sides.
     * @return arraylist with input variables.
     */
    public ArrayList<BigDecimal> inputSides(ScannerAdapter scannerAdapter, int size) {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        try {
            System.out.println("Please, enter line segments of the triangle: ");
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + " line segment = ");
                sides.add(i, new BigDecimal(getSide(scannerAdapter)));
            }
        } catch (Exception e) {
            System.out.println("Read error: " + e.getMessage());
        }
        return sides;
    }

    /**
     * Method for getting input value.
     *
     * @param in text scanner.
     * @return entered string.
     */
    private String getSide(ScannerAdapter in) {
        return in.next();
    }
}
