package com.easyJson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EasyJsonParser {
	/**
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static EasyJson parse(String jsonStr) {
		JsonElement jsonElt = new JsonParser().parse(jsonStr);		
		return new EasyJson(jsonElt);
	}
	
	/**
	 * 
	 * @param jsonFile
	 * @return
	 * @throws IOException
	 */
	public static EasyJson parse(File jsonFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
		
		try {
			JsonElement jsonElt = new JsonParser().parse(reader);
			return new EasyJson(jsonElt);
		} finally {
			reader.close();
		}
	} 
	
	/**
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static EasyJson parse(Reader reader) throws IOException {
		JsonElement jsonElt = new JsonParser().parse(reader);
		return new EasyJson(jsonElt);
	} 

}
