package com.company.spring.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class CommonUtil {

	
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

		public static String convertObjectToString(List receipeMoReturnList) throws Exception {
		final StringWriter stringWriter = new StringWriter();
		final ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(stringWriter, receipeMoReturnList);
		} catch (IOException e) {
			throw new Exception("Exception while conversion from object to string");
		}
		return stringWriter.toString();
	}
	
	
	public static HttpHeaders populateHeadersFieldWithJSONContentType() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return headers;
	}
	
	
	public static HttpHeaders populateHeadersFieldWithTextContentType() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain; charset=utf-8");
		return headers;
	}

}
