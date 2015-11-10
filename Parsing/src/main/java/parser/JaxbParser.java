package parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringWriter;

public class JaxbParser {

    public static String buildXmlWithJaxb(Object dto) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(dto.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter writer = new StringWriter();
        marshaller.marshal(dto, writer);
        System.out.println(writer.toString());
        return writer.toString();
    }

    public static Object buildObjectWithJaxb(Object object, InputStream xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        object = unmarshaller.unmarshal(xml);
        return object;
    }
}
