import java.math.BigDecimal;
import java.util.*;
/**
 * Class of triangle.
 *
 * @author Siarhei Tuzhyk
 * @version 1.7
 * @since 04-11-2016
 */
public class Triangle {
    private final String MESSAGEABOUTEXIST = "exist";
    private final String EQUILATERAL = "equilateral";
    private final String ISOSCELES = "isosceles";
    private final String ORDINARY = "ordinary";

    private BigDecimal firstSide;
    private BigDecimal secondSide;
    private BigDecimal thirdSide;
    private String messageAboutExist;
    private String triangleType;

    /**
     * Constructor of "Triangle" class. Validates input variables and verifies the existence of a triangle.
     *
     * @param sides entered variables sides of triangle.
     * @throws Exception if such line segments or triangle doesn't exist.
     */
    public Triangle(ArrayList<BigDecimal> sides) throws Exception {
        isReallyLineSegments(sides);
        isItTriangle(sides);
        firstSide = sides.get(0);
        secondSide = sides.get(1);
        thirdSide = sides.get(2);
        messageAboutExist = MESSAGEABOUTEXIST;
        triangleType = "";
    }

    /**
     * @return type of triangle.
     */
    public String getTriangleType() {
        return triangleType;
    }

    /**
     * @return message about existing of triangle.
     */
    public String getMessage() {
        return messageAboutExist;
    }

    /**
     * @return first side of triangle.
     */
    public BigDecimal getFirstSide() {
        return firstSide;
    }

    /**
     * @return second side of triangle.
     */
    public BigDecimal getSecondSide() {
        return secondSide;
    }

    /**
     * @return third side of triangle.
     */
    public BigDecimal getThirdSide() {
        return thirdSide;
    }

    /**
     * Method for getting all sides of triangle.
     *
     * @return arraylist with all sides of triangle.
     */
    public ArrayList<BigDecimal> getSides() {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(this.getFirstSide());
        sides.add(this.getSecondSide());
        sides.add(this.getThirdSide());
        return sides;
    }

    /**
     * Method for validation the existence of line segment.
     *
     * @param sides input line segment.
     * @throws Exception when line segment doesn't exist or was transmitted null
     *                   Or
     */
    private static void isReallyLineSegments(ArrayList<BigDecimal> sides) throws Exception {
        for (BigDecimal x : sides) {
            if (x.compareTo(BigDecimal.ZERO) == 0 || x.compareTo(BigDecimal.ZERO) == -1) {    // (x<=0)
                throw new Exception("Triangle with such line segment doesn't exist!");
            }
            if (x == null) {
                throw new Exception("You input null!");
            }
        }
    }

    /**
     * Method for verifying the existence of a triangle. If
     *
     * @param sides entered line segments.
     * @throws Exception when triangle doesn't exist.
     */
    private void isItTriangle(ArrayList<BigDecimal> sides) throws Exception {
        if (!((sides.get(0)).compareTo((sides.get(1)).add(sides.get(2))) == -1     // a < b + c
                && (sides.get(1)).compareTo((sides.get(0)).add(sides.get(2))) == -1     // b < a + c
                && (sides.get(2)).compareTo((sides.get(0)).add(sides.get(1))) == -1)) {     // c < a + b
            throw new Exception("Triangle with entered lines elements doesn't exist!");
        }
    }

    /**
     * Method determines type of triangle.
     *
     * @return type of triangle.
     */
    public String getTypeOfTriangle() {
        ArrayList<BigDecimal> sides = this.getSides();
        if ((sides.get(0)).compareTo(sides.get(1)) == 0    // (a = b)
                && (sides.get(1)).compareTo(sides.get(2)) == 0    // (b = c)
                && (sides.get(0)).compareTo(sides.get(2)) == 0) {    // (a == c)
            triangleType = EQUILATERAL;
        } else if (isItAIsoscelesTriangle(sides)) {
            triangleType = ISOSCELES;
        } else {
            triangleType = ORDINARY;
        }
        return triangleType;
    }

    /**
     * Method checking on is isosceles type of triangle.
     *
     * @param sides line segments of the triangle.
     * @return {@code true} if triangle is isosceles.
     * {@code false} otherwise.
     */
    private boolean isItAIsoscelesTriangle(ArrayList<BigDecimal> sides) {
        return (((sides.get(0)).compareTo(sides.get(1)) == 0 && (sides.get(1)).compareTo(sides.get(2)) != 0)    // (a = b & a != c)
                || ((sides.get(1)).compareTo(sides.get(2)) == 0 && (sides.get(0)).compareTo(sides.get(2)) != 0)    // (b = c & c != a)
                || ((sides.get(2)).compareTo(sides.get(0)) == 0 && (sides.get(0)).compareTo(sides.get(1)) != 0));    // (c = a & a != b)
    }
}
