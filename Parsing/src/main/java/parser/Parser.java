package parser;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class Parser {

    public void createPidisko() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // Коренвой элемент
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("Customers");
            document.appendChild(rootElement);

            // Child Корневого элемента
            Element customer = document.createElement("Customer");
            rootElement.appendChild(customer);

            // Установка атрибута  у Customer
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            customer.setAttributeNode(attr);

            //Элемент "FIRST_NAME"
            Element FIRST_NAME = document.createElement("FIRST_NAME");
            FIRST_NAME.appendChild(document.createTextNode("Max"));
            customer.appendChild(FIRST_NAME);

            //Элемент "LAST_NAME"
            Element LAST_NAME = document.createElement("LAST_NAME");
            LAST_NAME.appendChild(document.createTextNode("Pidisko"));
            customer.appendChild(LAST_NAME);

            //Элемент "EMAIL"
            Element EMAIL = document.createElement("EMAIL");
            EMAIL.appendChild(document.createTextNode("MaxPidisko@gmail.com"));
            customer.appendChild(EMAIL);

            //Элемент "PHONE"
            Element PHONE = document.createElement("PHONE");
            PHONE.appendChild(document.createTextNode("+380670000000"));
            customer.appendChild(PHONE);

            //Элемент "LOGIN"
            Element LOGIN = document.createElement("LOGIN");
            LOGIN.appendChild(document.createTextNode("LOGIN"));
            customer.appendChild(LOGIN);

            //Элемент "PASS"
            Element PASS = document.createElement("PASS");
            PASS.appendChild(document.createTextNode("PASS"));
            customer.appendChild(PASS);

            // Запись в XML файл
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("Customer_DATA.xml"));

            transformer.transform(domSource, streamResult);
            System.out.println("The file is saved...");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException bla) {
            bla.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void DomParser() {
        try {
            File xmlFile = new File("Customer_DATA.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            org.w3c.dom.Node node1 = document.getFirstChild();
            while(node1 != null){
                org.w3c.dom.Node firstChild = node1.getFirstChild();
                firstChild.getNodeType();

                node1 =   node1.getNextSibling();
            }






            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(0).getNodeName());
            System.out.println("===========================================");
            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Customers #" + i + ":");
                    // System.out.println("Customer " + element.getElementsByTagName("Customer").item(i).getChildNodes().item(i).getNodeValue());
                    System.out.println("FIRST_NAME: " + element.getElementsByTagName("FIRST_NAME").item(i).getChildNodes().item(0).getNodeValue());
                    System.out.println("LAST_NAME: " + element.getElementsByTagName("LAST_NAME").item(i).getChildNodes().item(0).getNodeValue());
                    System.out.println("EMAIL: " + element.getElementsByTagName("EMAIL").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("PHONE: " + element.getElementsByTagName("PHONE").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("LOGIN: " + element.getElementsByTagName("LOGIN").item(0).getChildNodes().item(0).getNodeValue());
                    System.out.println("PASS: " + element.getElementsByTagName("PASS").item(0).getChildNodes().item(0).getNodeValue());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

