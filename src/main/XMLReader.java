package main;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReader {
    private File file;
    private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public XMLReader(String fileName) {
        this.file = new File(fileName);
    }

    public Router parseFile() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        Router router = new Router();

        // Load nodes
        NodeList nodes = doc.getElementsByTagName("node");
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node xmlNode = nodes.item(i);
            String name = xmlNode.getAttributes().getNamedItem("id").getTextContent();

            float lat = -1;
            float lon = -1;
            NodeList children = xmlNode.getChildNodes();
            for (int y = 0; y < children.getLength(); y++) {
                org.w3c.dom.Node child = children.item(y);
                String childKey = child.getAttributes().getNamedItem("key").getTextContent();
                switch (childKey) {
                    case "lat":
                        lat = Float.parseFloat(child.getTextContent());
                        break;
                    case "lon":
                        lon = Float.parseFloat(child.getTextContent());
                        break;
                }
            }

            Node node = new Node(name, lat, lon);
            router.getNodes().add(node);
        }

        // Load edges
        NodeList edges = doc.getElementsByTagName("edge");
        for (int i = 0; i < edges.getLength(); i++) {
            org.w3c.dom.Node xmlEdge = edges.item(i);
            String sourceName = xmlEdge.getAttributes().getNamedItem("source").getTextContent();
            String targetName = xmlEdge.getAttributes().getNamedItem("target").getTextContent();

            String name = "";
            float length = -1;
            NodeList children = xmlEdge.getChildNodes();
            for (int y = 0; y < children.getLength(); y++) {
                org.w3c.dom.Node child = children.item(y);
                String childKey = child.getAttributes().getNamedItem("key").getTextContent();
                switch (childKey) {
                    case "A":
                        name = child.getTextContent();
                        break;
                    case "gewicht":
                        length = Float.parseFloat(child.getTextContent());
                        break;
                }
            }

            Edge edge = new Edge(name, length);

            Node source = router.getNodeByName(sourceName);
            source.getEdges().add(edge);
            edge.setSource(source);

            Node target = router.getNodeByName(targetName);
            target.getEdges().add(edge);
            edge.setTarget(target);

            router.getEdges().add(edge);
        }

        return router;
    }
}
