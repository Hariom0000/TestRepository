package com.hariom.JaxB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author hariom.singh 
 * @UnMarshallXML : This is a generic class use for
 *         unmarshalling purpose
 */
public class UnMarshallXML {
	@SuppressWarnings("unchecked")
	public static <T> T convertToObject(T t, File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(t.getClass());
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		return (T) unmarshaller.unmarshal(file);
	}
}
