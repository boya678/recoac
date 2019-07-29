package com.astoudcommerce.task1.engine;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.astoudcommerce.task1.model.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonGetter {

	private static final String URL = "https://jsonplaceholder.typicode.com/todos";

	private static JsonGetter jsonGetter;

	public static JsonGetter use() {
		if (jsonGetter == null) {
			jsonGetter = new JsonGetter();
		}
		return jsonGetter;
	}

	public List<Task> getList() {
		URL url;
		try {
			url = new URL(URL);
			URLConnection request = url.openConnection();
			request.connect();
			Gson gson = new Gson();
			Type typeTaskList = new TypeToken<List<Task>>() {
			}.getType();
			final List<Task> taskList = gson.fromJson(new InputStreamReader((InputStream) request.getContent()),
					typeTaskList);
			return taskList;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String printJSon(Task task) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(task); 
	}

}
