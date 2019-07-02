package com.buba.util;

import com.google.gson.Gson;

public class JsonFormatUtil {
	
	private static Gson gson;
	
	public static Gson getGson() {
		if (gson == null) {
			gson = new Gson();
		}
		return gson;
	}
	
	//JAVA转换json字符串
	public static String javaToJson(Object obj) {
		getGson();
		String json = gson.toJson(obj);
		return json;
	}
	//要想使用泛型  在方法返回值类型之前加上<T>, 说明方法中出现的T都是泛型里的类型   
	//json字符串转换java
	public static <T> T jsonToJava(String json,Class<T> class1) {
		getGson();
		T t = (T)gson.fromJson(json, class1);
		return t;
	}
	
}
