import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * read the xml file
 */
public class XmlReader {
    private final String PATH = ".\\data.xml";

    /**
     * read the xml file and writes commands in document
     *
     * @return document with commands
     * @throws Exception - auto exception working with file
     */
    public Document setDocument() throws Exception {
        File file = new File(PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        return document;
    }

    /**
     * write commands from xml file in arrayList
     *
     * @param linne - ArrayList for writing commands
     * @return arrayList with commands from xml file
     * @throws Exception - auto exception working with files
     */
    public ArrayList<String> readCommand(ArrayList<String> linne) throws Exception {
        Document document = setDocument();
        NodeList nodeList = document.getElementsByTagName("command");
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap attrs = nodeList.item(i).getAttributes();
            String command = attrs.getNamedItem("name").getNodeValue();
            linne.add(command);
        }
        return linne;
    }
}
