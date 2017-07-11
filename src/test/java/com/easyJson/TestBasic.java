package com.easyJson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

import com.google.gson.JsonArray;
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
	public void testOneBook() {
		EasyJson easyJson = this.getEasyJson("one-book.json");
		
		assertEquals(easyJson.getString("book.author.first_name"), "Rick");
		
		JsonElement jsonElt = easyJson.getWrappedJsonElement();
		
		String firstName = jsonElt.getAsJsonObject().get("book").getAsJsonObject().get("author").getAsJsonObject().get("first_name").getAsString();
		
		assertEquals(firstName, "Rick");			
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
	 * @throws IOException 
	 */
	private EasyJson getEasyJson(String resourceName) {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("./../../" + resourceName);		
		Reader reader = new InputStreamReader(resourceAsStream);		
		
		try {
			EasyJson easyGson = EasyJson.parse(reader);
			return easyGson;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
