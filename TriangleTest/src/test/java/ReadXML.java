import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;

/**
 * Class for read XML file with data for our tests.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 10.11.2016
 */
public class ReadXML {

    DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder documentBuilder;
    File testDataFile;
    Document document;
    /**
     * Tag constants.
     */
    private final String POSITIVEINPUT = "positiveInput";
    private final String NEGATIVEINPUT = "negativeInput";
    private final String CONSTRUCTORPOSITIVE = "constructorPositive";
    private final String CONSTRUCTORNEGATIVE = "constructorNegative";
    private final String TRIANGLETYPE = "triangleType";
    private final String EXPECTED = "expected";
    private final String FIRSTSIDE = "firstSide";
    private final String SECONDSIDE = "secondSide";
    private final String THIRDSIDE = "thirdSide";

    /**
     * Constructor of ReadXML, in which parse xml.
     *
     * @param dataPath path to xml file.
     * @throws Exception if have problems with creating objects.
     */
    public ReadXML(String dataPath) throws Exception {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        testDataFile = new File(dataPath);
        document = documentBuilder.parse(testDataFile);
    }

    /**
     * Method for getting data from xml depending on the tag.
     *
     * @param tag object of xml.
     * @return all data, which contain this tag.
     * @throws Exception if have problems with reader xml file.
     */
    public Object[][] getDataFromTag(String tag) throws Exception {
        NodeList nodes = document.getElementsByTagName(tag);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            if (tag.equals(POSITIVEINPUT) || tag.equals(NEGATIVEINPUT)) {
                result[i] = attributesForInputSide(attributes);
            } else if (tag.equals(CONSTRUCTORPOSITIVE)) {
                result[i] = attributesForPositiveTriangle(attributes);
            } else if (tag.equals(CONSTRUCTORNEGATIVE)) {
                result[i] = attributesForNegativeConstructor(attributes);
            } else if (tag.equals(TRIANGLETYPE)) {
                result[i] = attributesForPositiveTriangle(attributes);
            }
        }
        return result;
    }

    /**
     * Method for getting data in certain line of tag object.
     *
     * @param attributes NamedNodeMap object.
     * @return data from certain line.
     */
    private Object[] attributesForInputSide(NamedNodeMap attributes) {
        return new Object[]{
                attributes.getNamedItem(FIRSTSIDE).getNodeValue(),
                attributes.getNamedItem(SECONDSIDE).getNodeValue(),
                attributes.getNamedItem(THIRDSIDE).getNodeValue()
        };
    }

    /**
     * Method for getting data in certain line of tags "positiveConstructor" or "triangleType".
     *
     * @param attributes NamedNodeMap object.
     * @return data from certain line.
     */
    private Object[] attributesForPositiveTriangle(NamedNodeMap attributes) {
        return new Object[]{
                attributes.getNamedItem(EXPECTED).getNodeValue(),
                new BigDecimal(attributes.getNamedItem(FIRSTSIDE).getNodeValue()),
                new BigDecimal(attributes.getNamedItem(SECONDSIDE).getNodeValue()),
                new BigDecimal(attributes.getNamedItem(THIRDSIDE).getNodeValue())
        };
    }

    /**
     * Method for getting data in certain line of tag "negativeConstructor".
     *
     * @param attributes NamedNodeMap object.
     * @return data from certain line.
     */
    private Object[] attributesForNegativeConstructor(NamedNodeMap attributes) {
        return new BigDecimal[]{
                attributes.getNamedItem(FIRSTSIDE) == null ? null
                        : new BigDecimal(attributes.getNamedItem(FIRSTSIDE).getNodeValue()),
                attributes.getNamedItem(SECONDSIDE) == null ? null
                        : new BigDecimal(attributes.getNamedItem(SECONDSIDE).getNodeValue()),
                attributes.getNamedItem(THIRDSIDE) == null ? null
                        : new BigDecimal(attributes.getNamedItem(THIRDSIDE).getNodeValue())
        };
    }
}
