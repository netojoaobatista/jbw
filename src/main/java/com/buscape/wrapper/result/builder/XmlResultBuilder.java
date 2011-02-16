package com.buscape.wrapper.result.builder;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.buscape.wrapper.result.type.Result;

public class XmlResultBuilder extends AbstractResultBuilder {
	
	private final String data;

	public XmlResultBuilder(String rawdata) {
		this.data = rawdata;
	}
	
	@Override
	public Result getResult() {

		try {
			JAXBContext jc = JAXBContext.newInstance("com.buscape.wrapper.result.type");
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			Result result = (Result) unmarshaller.unmarshal(new ByteArrayInputStream(this.data.getBytes()));

			return result;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

}
