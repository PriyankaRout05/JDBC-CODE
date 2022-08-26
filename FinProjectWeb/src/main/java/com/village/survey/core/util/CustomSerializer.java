package com.village.survey.core.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomSerializer extends StdSerializer<String> {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4127323360661673232L;

	public CustomSerializer() {
		this(null);
	}

	public CustomSerializer(Class<String> t) {
		super(t);
	}

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeObject(new ObjectMapper().readTree(value));
	}

}
