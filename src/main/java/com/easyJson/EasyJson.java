/**************************************************
 * EasyGson is open-sourced software licensed under the MIT license.
 * https://opensource.org/licenses/MIT
 ***************************************************/

package com.easyJson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Consumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class EasyJson {
	JsonElement wrappedJsonElement;

	/**
	 * 
	 * @param json
	 */
	public EasyJson(JsonElement jsonElt) {
		this.wrappedJsonElement = jsonElt;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public JsonElement getWrappedJsonElement() {
		return wrappedJsonElement;
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Integer getInteger(String path, Integer defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsInt();
		}
	}
	
	public Integer getInteger(String path) {
		return this.getInteger(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getInteger() {
		return this.wrappedJsonElement.getAsInt();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public String getString(String path, String defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsString();
		}
	}
	
	public String getString(String path) {
		return this.getString(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getString() {
		return this.wrappedJsonElement.getAsString();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Boolean getBoolean(String path, Boolean defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsBoolean();
		}
	}
	
	public Boolean getBoolean(String path) {
		return this.getBoolean(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean getBoolean() {
		return this.wrappedJsonElement.getAsBoolean();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Float getFloat(String path, Float defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsFloat();
		}
	}
	
	public Float getFloat(String path) {
		return this.getFloat(path, null);
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Double getDouble(String path, Double defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsDouble();
		}
	}
	
	public Double getDouble(String path) {
		return this.getDouble(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getDouble() {
		return this.wrappedJsonElement.getAsDouble();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Long getLong(String path, Long defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsLong();
		}
	}
	
	public Long getLong(String path) {
		return this.getLong(path, null);
	}

	/**
	 * 
	 * @return
	 */
	public Long getLong() {
		return this.wrappedJsonElement.getAsLong();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public BigDecimal getBigDecimal(String path, BigDecimal defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsBigDecimal();
		}
	}
	
	public BigDecimal getBigDecimal(String path) {
		return this.getBigDecimal(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public BigDecimal getBigDecimal() {
		return this.wrappedJsonElement.getAsBigDecimal();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public BigInteger getBigInteger(String path, BigInteger defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsBigInteger();
		}
	}
	
	public BigInteger getBigInteger(String path) {
		return this.getBigInteger(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public BigInteger getBigInteger() {
		return this.wrappedJsonElement.getAsBigInteger();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Byte getByte(String path, Byte defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsByte();
		}
	}
	
	public Byte getByte(String path) {
		return this.getByte(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Byte getByte() {
		return this.wrappedJsonElement.getAsByte();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Character getCharacter(String path, Character defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsCharacter();
		}
	}
	
	public Character getCharacter(String path) {
		return this.getCharacter(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Character getCharacter() {
		return this.wrappedJsonElement.getAsCharacter();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Number getNumber(String path, Number defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsNumber();
		}
	}
	
	public Number getNumber(String path) {
		return this.getNumber(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Number getNumber() {
		return this.wrappedJsonElement.getAsNumber();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public Short getShort(String path, Short defaultVal) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return defaultVal;
		} else {
			return jsonElt.getAsShort();
		}
	}
	
	public Short getShort(String path) {
		return this.getShort(path, null);
	}
	
	/**
	 * 
	 * @return
	 */
	public Short getShort() {
		return this.wrappedJsonElement.getAsShort();
	}

	/**
	 * 
	 * @param path
	 * @param consumer
	 */
	public void iterate(String path, Consumer<EasyJson> consumer) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt != null && !jsonElt.isJsonNull() && jsonElt instanceof JsonArray) {
			JsonArray arr = jsonElt.getAsJsonArray();

			for (JsonElement arrElt : arr) {
				consumer.accept(new EasyJson(arrElt));
			}
		}
	}

	/**
	 * 
	 * @param path
	 * @param consumer
	 */
	public void iterateRaw(String path, Consumer<JsonElement> consumer) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt != null && !jsonElt.isJsonNull() && jsonElt instanceof JsonArray) {
			JsonArray arr = jsonElt.getAsJsonArray();

			for (JsonElement arrElt : arr) {
				consumer.accept(arrElt);
			}
		}
	}

	/**
	 * 
	 * @param consumer
	 */
	public void iterate(Consumer<EasyJson> consumer) {
		JsonElement jsonElt = this.wrappedJsonElement;

		if (jsonElt != null && !jsonElt.isJsonNull() && jsonElt instanceof JsonArray) {
			JsonArray arr = jsonElt.getAsJsonArray();

			for (JsonElement arrElt : arr) {
				consumer.accept(new EasyJson(arrElt));
			}
		}
	}

	/**
	 * 
	 * @param consumer
	 */
	public void iterateRaw(Consumer<JsonElement> consumer) {
		JsonElement jsonElt = this.wrappedJsonElement;

		if (jsonElt != null && !jsonElt.isJsonNull() && jsonElt instanceof JsonArray) {
			JsonArray arr = jsonElt.getAsJsonArray();

			for (JsonElement arrElt : arr) {
				consumer.accept(arrElt);
			}
		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public JsonObject getJsonObject(String path) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return null;
		} else {
			return jsonElt.getAsJsonObject();
		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public JsonArray getJsonArray(String path) {
		JsonElement jsonElt = getLastJsonEltInPath(path);

		if (jsonElt == null || jsonElt.isJsonNull()) {
			return null;
		} else {
			return jsonElt.getAsJsonArray();
		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	private JsonElement getLastJsonEltInPath(String path) {
		String[] properties = path.split("\\.");
		JsonObject jsonObj = this.wrappedJsonElement.getAsJsonObject();
		int len = properties.length - 1;

		for (int i = 0; i < len; i++) {
			String prop = properties[i];
			JsonElement jsonElement = jsonObj.get(prop);

			if (jsonElement.isJsonNull()) {
				return null;
			}

			jsonObj = jsonElement.getAsJsonObject();

			if (jsonObj == null) {
				return null;
			}
		}

		String prop = properties[properties.length - 1];
		JsonElement jsonElement = jsonObj.get(prop);

		if (jsonElement == null || jsonElement.isJsonNull()) {
			return null;
		} else {
			return jsonElement;
		}
	}
}
