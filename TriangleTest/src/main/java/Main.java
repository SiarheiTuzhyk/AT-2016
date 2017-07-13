import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Main class of program. Entrance point to the program.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 04-11-2016
 */
public class Main {
    // Sides of triangle.
    private static final int NUMBEROFSIDES = 3;

    /**
     * Entrance to solution.
     * This method required for the use methods to input sides and identify the type of the triangle.
     *
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        ArrayList<BigDecimal> sides = new ArrayList<BigDecimal>(NUMBEROFSIDES);
        try {
            ScannerAdapter scannerAdapter = new ScannerAdapter(new Scanner(System.in));
            InputSides inputSides = new InputSides();
            sides = inputSides.inputSides(scannerAdapter, NUMBEROFSIDES);
            Triangle triangle = new Triangle(sides);
            System.out.println("Triangle " + triangle.getMessage()
                    + ".\nType of triangle: " + triangle.getTypeOfTriangle() + ".");
        } catch (Exception e) {
            System.out.println("Program error: " + e.getMessage());
        }
    }
}
