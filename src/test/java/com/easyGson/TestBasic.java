package com.easyGson;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TestBasic {

	@Test
	public void test1() {		
		EasyGson easyGson = this.getEasyJson("sample1.json");
		String res = easyGson.getString("menu.popup.level");
		
		assertEquals(res, "default");
		assertNull(easyGson.getString("menu.popup.nonExistingKey"));
	}

	@Test
	public void testIterate() {
		EasyGson easyGson = this.getEasyJson("sample1.json");
		
		easyGson.iterate("menu.popup.menuitem", elt -> {
				EasyGson eg = new EasyGson(elt);
				String str = eg.getString("value");
				assertNotNull(str);
		});
	}
	
	@Test
	public void testBooks() {
		EasyGson easyGson = this.getEasyJson("books.json");
		
		easyGson.iterate("books", bookJson -> {
				EasyGson bookEg = new EasyGson(bookJson);
				
				bookEg.iterate("cat", catJson -> {
					assertNotNull(catJson.getAsString());
					
					String cat = catJson.getAsString();
					
					assertTrue(cat.equals("book") || cat.equals("paperback") || cat.equals("hardcover"));
				});
		});
	}
	
	/**
	 * Utility method
	 * 
	 * @param resourceName name of a file under src/test/resources
	 * @return
	 */
	private EasyGson getEasyJson(String resourceName) {
		InputStream resourceAsStream = this.getClass().getResourceAsStream("./../../" + resourceName);		
		Reader reader = new InputStreamReader(resourceAsStream);		
		JsonElement jsonElt = (new JsonParser()).parse(reader);
		
		EasyGson easyGson = new EasyGson(jsonElt);
		
		return easyGson;
	}

}
