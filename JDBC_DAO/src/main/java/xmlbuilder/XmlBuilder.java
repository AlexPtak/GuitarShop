package xmlbuilder;

import entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlBuilder {

    public void buildXmlWithJaxb(Entity entity) {
        try {
            JAXBContext context = JAXBContext.newInstance(entity.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(entity, new File("parameterTypes.xml"));
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void buildXmlWithDom(List<Entity> entities) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement(entities.get(0).getTable());
        doc.appendChild(rootElement);

        for (int i = 0; i < entities.size(); i++) {
            // staff elements
            Element staff = doc.createElement(entities.get(0).getTable());
            rootElement.appendChild(staff);

            for (int j = 0; j < entities.get(i).getCulums().length; j++) {
                // columnNameElement elements
                String columnName = entities.get(i).getCulums()[j];
                Element columnNameElement = doc.createElement(columnName);
                String columnValue = entities.get(i).getValues()[j].toString();
                columnNameElement.appendChild(doc.createTextNode(columnValue));
                staff.appendChild(columnNameElement);
            }
        }

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("parameterTypes.xml"));

        transformer.transform(source, result);
    }
}
