package xmlbuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.PrintStream;
import java.io.Writer;

public class XmlBuilder {

    public void buildXmlWithJaxb(Object dto, PrintStream printStream) {
        try {
            JAXBContext context = JAXBContext.newInstance(dto.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(dto, printStream);
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

//    public void buildXmlWithDom(List<Entity> entities) throws ParserConfigurationException, TransformerException {
//
//        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//
//        // root elements
//        Document doc = docBuilder.newDocument();
//        Element rootElement = doc.createElement(entities.get(0).getTable());
//        doc.appendChild(rootElement);
//
//        for (int i = 0; i < entities.size(); i++) {
//            // staff elements
//            Element staff = doc.createElement(entities.get(0).getTable());
//            rootElement.appendChild(staff);
//
//            for (int j = 0; j < entities.get(i).getColumns().length; j++) {
//                // columnNameElement elements
//                String columnName = entities.get(i).getColumns()[j];
//                Element columnNameElement = doc.createElement(columnName);
//                String columnValue = entities.get(i).getValues()[j].toString();
//                columnNameElement.appendChild(doc.createTextNode(columnValue));
//                staff.appendChild(columnNameElement);
//            }
//        }
//
//        // write the content into xml file
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        DOMSource source = new DOMSource(doc);
//        StreamResult result = new StreamResult(new File("parameterTypes.xml"));
//
//        transformer.transform(source, result);
//    }
}
