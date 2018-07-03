package hk.blogspot.javatoybox.ValidateXml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class PraseXml {
	public PraseXml(String xsd, String xml) throws ParserConfigurationException, SAXException, IOException {
		
		// create a new DocumentBuilderFactory and set Namespace Aware
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		
		// parse an XML document into a DOM tree
		DocumentBuilder parser = dbf.newDocumentBuilder();
		Document document = parser.parse(new File(xml));

		// create a SchemaFactory capable of understanding WXS schemas
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		// load a WXS schema, represented by a Schema instance
		Source schemaFile = new StreamSource(new File(xsd));
		Schema schema = factory.newSchema(schemaFile);

		// create a Validator instance, which can be used to validate an instance
		// document
		Validator validator = schema.newValidator();

		// validate the DOM tree
		validator.validate(new DOMSource(document));
	}
}
