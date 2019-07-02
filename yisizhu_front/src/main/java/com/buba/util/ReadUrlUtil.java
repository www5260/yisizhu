package com.buba.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

public class ReadUrlUtil {
	 public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException { 
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
			String jsonText = sb.toString();
			JSONArray json = JSONArray.fromObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
}
