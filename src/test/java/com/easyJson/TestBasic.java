package com.easyJson;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

import com.easyJson.EasyJson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TestBasic {

	@Test
	public void testSample1() {		
		EasyJson easyJson = this.getEasyJson("sample1.json");
		String res = easyJson.getString("menu.popup.level");
		
		assertEquals(res, "default");
		assertNull(easyJson.getString("menu.popup.nonExistingKey"));
	}

	@Test
	public void testIterate() {
		EasyJson easyJson = this.getEasyJson("sample1.json");
		
		easyJson.iterate("menu.popup.menuitem", ejson -> {
				String str = ejson.getString("value");
				assertNotNull(str);
		});
	}
	
	@Test
	public void testBooks() {
		EasyJson easyJson = this.getEasyJson("books.json");
		
		easyJson.iterate("books", bookEJson -> {
				
				if (bookEJson.getString("id").equals("978-0641723445")) {
					assertTrue(bookEJson.getInteger("sequence_i") == 1);
					assertTrue(bookEJson.getShort("sequence_i") == 1);
					assertTrue(bookEJson.getFloat("price") == 12.50);
					assertTrue(bookEJson.getDouble("price") == 12.50);
					assertTrue(bookEJson.getBoolean("inStock"));
				}
				
				bookEJson.iterateRaw("cat", catJsonElt -> {
					String cat = catJsonElt.getAsString();					
					assertTrue(cat.equals("book") || cat.equals("paperback") || cat.equals("hardcover"));
				});
		});
	}
	
	@Test
	public void testNames() {
		EasyJson easyJson = this.getEasyJson("names.json");
		
		easyJson.iterateRaw(jsonElt -> {
			String name = jsonElt.getAsString();
			assertTrue(name.equals("Jon") || name.equals("Ritchie") || name.equals("Ian"));
		});
	}
	
	/**
	 * Utility method
	 * 
	 * @param resourceName name of a file under src/test/resources
	 * @return
	 */
	private EasyJson getEasyJson(String resourceName) {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("./../../" + resourceName);		
		Reader reader = new InputStreamReader(resourceAsStream);		
		JsonElement jsonElt = (new JsonParser()).parse(reader);
		
		EasyJson easyGson = new EasyJson(jsonElt);
		
		return easyGson;
	}

}
