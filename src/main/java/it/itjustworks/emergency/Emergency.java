package it.itjustworks.emergency;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Emergency {

	private OkHttpClient client;
	private static String ENDPOINT = "https://emergency-server.herokuapp.com";
	
	public Emergency() {
		this.client = new OkHttpClient();
	}
	
	public String sendRequest(Requestable req) throws IOException {
		Request request = new Request.Builder().url(ENDPOINT + req.url()).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	
	
}
