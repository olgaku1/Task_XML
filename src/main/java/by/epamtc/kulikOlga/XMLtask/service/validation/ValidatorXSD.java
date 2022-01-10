package by.epamtc.kulikOlga.XMLtask.service.validation;

import by.epamtc.kulikOlga.XMLtask.service.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXSD {
    public static void validateXSD(String xsdPath, String xmlPath) throws ServiceException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            throw new ServiceException("Error of validation xsd-schemе", e);
        }
    }
}
