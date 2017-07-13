import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Test class "Triangle."
 */
public class TriangleTest {

    ReadXML readXML;
    private final String DATAPATH = "src" + File.separator + "test" + File.separator + "java" + File.separator + "data_provider.xml";
    private final String CONSTRUCTORPOSITIVE = "constructorPositive";
    private final String CONSTRUCTORNEGATIVE = "constructorNegative";
    private final String TRIANGLETYPE = "triangleType";
    Triangle triangle;

    @BeforeClass
    public void setUp() throws Exception {
        readXML = new ReadXML(DATAPATH);
    }

    @DataProvider(name = "positive test constructor of class")
    public Object[][] positiveRightValuesConstructor() throws Exception {
        Object[][] result = readXML.getDataFromTag(CONSTRUCTORPOSITIVE);
        return result;
    }

    @DataProvider(name = "negative test checkTriangle with wrong values")
    public Object[][] negativeWrongValuesConstructor() throws Exception {
        Object[][] result = readXML.getDataFromTag(CONSTRUCTORNEGATIVE);
        return result;
    }

    @DataProvider(name = "positive test getTypeOfTriangle")
    public Object[][] positiveRightTypeOfTriangle() throws Exception {
        Object[][] result = readXML.getDataFromTag(TRIANGLETYPE);
        return result;
    }

    @Test(dataProvider = "positive test constructor of class")
    public void positiveTestRightValuesConstructor(String expected, BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        triangle = new Triangle(sides);
        assertTrue(triangle.getMessage().equals(expected));
    }

    @Test(dataProvider = "negative test checkTriangle with wrong values", expectedExceptions = Exception.class)
    public void negativeTestWrongValuesConstructor(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        triangle = new Triangle(sides);
    }

    @Test(dataProvider = "positive test getTypeOfTriangle")
    public void positiveTestRightValuesTypeOfTriangle(String expected, BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        triangle = new Triangle(sides);
        assertTrue(triangle.getTypeOfTriangle().equals(expected));
    }
}