package com.hariom.JaxB;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * @author hariom.singh
 * MarshallXML : This is a generic class use for marshalling purpose 
 */
public class MarshallXML {
	public static <T> void convertToXML(T t) throws Exception {
		JAXBContext context = JAXBContext.newInstance(t.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(t, new FileOutputStream(t.getClass().toString()+".xml"));
	}
}

