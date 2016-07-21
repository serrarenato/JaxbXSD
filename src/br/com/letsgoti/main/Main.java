package br.com.letsgoti.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import br.com.letsgoti.model.Customer;
import br.com.letsgoti.model.Phone;

public class Main {

	public static void main(String[] args) throws SAXException {
		
		List<Phone> listPhones = new ArrayList<Phone>();
		
		listPhones.add(new Phone("celular","99991111"));
		listPhones.add(new Phone("fixo","33331111"));
		listPhones.add(new Phone("recado","33332222"));
		
		Customer costumer = new Customer();
		costumer.setDateBorn(new Date("09/05/2015"));
		costumer.setEmail("joao@gmail.com");
		costumer.setFirstName("Joao");
		costumer.setLastName("Silva");
		costumer.setSex("M2");
		costumer.setId(1);
		costumer.setPhones(listPhones);
		
		try {
			Main schemaValidation = new Main();
			SchemaFactory sf = SchemaFactory
		                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		    Schema schema = sf.newSchema(schemaValidation.getSchemaFile());
			JAXBContext context = JAXBContext.newInstance(Customer.class);
			Marshaller m = context.createMarshaller();
			m.setSchema(schema);
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			m.marshal(costumer, System.out);
		} catch (JAXBException e) {			
			e.printStackTrace();
		}

	}

    private File getSchemaFile() {
        // Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File schemaFile = new File(classLoader.getResource("customer.xsd").getFile());
        return schemaFile;
    }

}
