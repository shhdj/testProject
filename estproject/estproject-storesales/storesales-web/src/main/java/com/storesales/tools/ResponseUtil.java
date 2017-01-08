package com.storesales.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


/**
 * 响应工具
 * 
 * @author 
 * @since 
 * @version 0.1 初始版本
 *
 */
public class ResponseUtil {
	private static String DEFAULT_CHARACTER_ENCODING ="UTF-8"; 
	/**
	 * 输出JSON内容 (字符编码为UTF-8)
	 * 
	 * @param response
	 * @param responseMap
	 */
	public static void writeJSON(HttpServletResponse response, Map<String, Object> responseMap) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		try {
			PrintWriter writer = response.getWriter();
			writer.write(gson.toJson(responseMap));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 输出文本内容 (字符编码为UTF-8)
	 * 
	 * @param response
	 * @param responseMap
	 */
	public static void write(HttpServletResponse response, String content) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void write(HttpServletResponse response, Boolean content) {
		write(response, content + "");
	}

	/**
	 * 输出JSON内容 (字符编码为UTF-8)
	 * 
	 * @param response
	 * @param responseMap
	 */
	public static void writeJSON(HttpServletResponse response, JsonObject jsonObject) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
