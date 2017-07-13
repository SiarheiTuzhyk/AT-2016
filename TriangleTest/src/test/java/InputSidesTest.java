import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Test class "InputSides".
 */
public class InputSidesTest {

    ReadXML readXML;
    private final String DATAPATH = "src" + File.separator + "test" + File.separator + "java" + File.separator + "data_provider.xml";
    private final String POSITIVEINPUT = "positiveInput";
    private final String NEGATIVEINPUT = "negativeInput";
    ArrayList<BigDecimal> sides;
    ArrayList<BigDecimal> sidesExpected;

    @BeforeClass
    public void setUp() throws Exception {
        readXML = new ReadXML(DATAPATH);
    }

    @DataProvider(name = "positive inputSides")
    public Object[][] positiveInputSides() throws Exception {
        Object[][] result = readXML.getDataFromTag(POSITIVEINPUT);
        return result;
    }

    @DataProvider(name = "negative inputSides")
    public Object[][] negativeInputSides() throws Exception {
        Object[][] result = readXML.getDataFromTag(NEGATIVEINPUT);
        return result;
    }

    @Test(dataProvider = "positive inputSides")
    public void positiveTestInputSides(String a, String b, String c) {
        ArrayList<BigDecimal> sides = new ArrayList<>();
        sides.add(new BigDecimal(new ScannerMock(a).next()));
        sides.add(new BigDecimal(new ScannerMock(b).next()));
        sides.add(new BigDecimal(new ScannerMock(c).next()));
        ArrayList<BigDecimal> sidesExpected = new ArrayList<>();
        sidesExpected.add(new BigDecimal(a));
        sidesExpected.add(new BigDecimal(b));
        sidesExpected.add(new BigDecimal(c));
        assertEquals(sides, sidesExpected);
    }

    @Test(dataProvider = "negative inputSides", expectedExceptions = Exception.class)
    public void negativeTestInputSides(String a, String b, String c) throws Exception {
        sides = new ArrayList<>();
        sides.add(new BigDecimal(new ScannerMock(a).next()));
        sides.add(new BigDecimal(new ScannerMock(b).next()));
        sides.add(new BigDecimal(new ScannerMock(c).next()));
        sidesExpected = new ArrayList<>();
        sidesExpected.add(new BigDecimal(a));
        sidesExpected.add(new BigDecimal(b));
        sidesExpected.add(new BigDecimal(c));
    }
}