import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TrainglTest {
    Traingl t = new Traingl();
    private final String PATH = "C:\\Users\\Janek\\IdeaProjects\\triangleTest\\data.xml";
    private final String NEGATIVE = "negative";
    private final String POSITIVE = "positive";
    private final String EXPECTED = "expected";
    private final String sideA = "side-a";
    private final String sideB = "side-b";
    private final String sideC = "side-c";
    Document document;

    @BeforeTest
    public Document setUp() throws IOException, SAXException, ParserConfigurationException {
        File dataFile = new File(PATH);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        document = docBuilder.parse(dataFile);
        return document;
    }

    @DataProvider(name = "negatives")
    public Object[][] negativ() throws Exception {
        NodeList nodes = document.getElementsByTagName(NEGATIVE);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attr = nodes.item(i).getAttributes();
            result[i] = new Object[]{
                    new BigDecimal(attr.getNamedItem(sideA).getNodeValue()),
                    new BigDecimal(attr.getNamedItem(sideB).getNodeValue()),
                    new BigDecimal(attr.getNamedItem(sideC).getNodeValue()),
            };
        }
        return result;
    }

    @DataProvider(name = "positiv")
    public Object[][] posit() throws Exception {
        NodeList nodes = document.getElementsByTagName(POSITIVE);
        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            result[i] = new Object[]{
                    new String(attrs.getNamedItem(EXPECTED).getNodeValue()),
                    new BigDecimal(attrs.getNamedItem(sideA).getNodeValue()),
                    new BigDecimal(attrs.getNamedItem(sideB).getNodeValue()),
                    new BigDecimal(attrs.getNamedItem(sideC).getNodeValue()),
            };
        }
        return result;
    }

    @Test(dataProvider = "negatives")
    public void NegativeTest(BigDecimal a, BigDecimal b, BigDecimal c) throws InputExec {
        String me = t.tri(a, b, c);
        assertEquals(me, "This task does not have roots");
    }

    @Test(dataProvider = "positiv")
    public void positiveTest(String expected, BigDecimal a, BigDecimal b, BigDecimal c) throws InputExec {
        String res = t.tri(a, b, c);
        assertTrue(res.equals(expected));
    }
}