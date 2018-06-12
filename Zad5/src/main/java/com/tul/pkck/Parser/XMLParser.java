package com.tul.pkck.Parser;

import com.tul.pkck.Model.Salon;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;

public class XMLParser {

    private static final String XML_PATH = "resources/salon.xml";
    private Salon salon;

    public String loadXML(String path) throws JAXBException {
        String filePath = getPath(path);
        JAXBContext jc = JAXBContext.newInstance(Salon.class);
        StringWriter sw = new StringWriter();
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File(filePath);
        this.salon = (Salon) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "SummaryCart.xsd");
        marshaller.marshal(salon, sw);
        return sw.toString();
    }

    private String getPath(String path) {
        return path.isEmpty() ? XML_PATH : path;
    }

    public Salon getSalon() {
        return salon;
    }
}
