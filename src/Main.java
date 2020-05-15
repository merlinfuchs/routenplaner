import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        XMLReader xmlReader = new XMLReader("assets/data.xml");

        long startTime = System.nanoTime();
        xmlReader.parseFile();
        System.out.println((System.nanoTime() - startTime) / 1000000);
    }
}
