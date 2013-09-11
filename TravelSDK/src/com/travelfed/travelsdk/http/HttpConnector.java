package com.travelfed.travelsdk.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.util.Log;

import com.travelfed.travelsdk.Logger;

public class HttpConnector {
	
	private static Logger logger = new Logger(HttpConnector.class);
	
	public static HttpEntity get(String url, HashMap<String, String> headers) throws HttpException {
		HttpEntity resEntityGet = null;
		try {
			logger.debug("GET URL: " + url);
			
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			if(headers != null) {
				Set<String> headersSet = headers.keySet();
				for (String key : headersSet) {
					get.setHeader(key, headers.get(key));
				}
			}
			
			HttpResponse responseGet = client.execute(get);
			resEntityGet = responseGet.getEntity();
		} catch (Exception e) {
			Log.e("GET RESPONSE", e.getMessage(), e);
			throw new HttpException(e.getMessage());
		} 
		
		return resEntityGet;
	}

	public static HttpEntity post(String url, Hashtable<String, String> params, HashMap<String, String> headers) throws HttpException {
		HttpEntity resEntityPost = null;
		try {
			logger.debug("POST URL: " + url);
			
			ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
			if(headers != null) {
				Set<String> headersSet = headers.keySet();
				for (String key : headersSet) {
					nameValuePairs.add(new BasicNameValuePair(key, headers.get(key)));
				}
			}
			
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8);
			post.setEntity(ent);
			
			// Set Params
			ArrayList<BasicNameValuePair> paramsArrayList = new ArrayList<BasicNameValuePair>();
			Set<String> keys = params.keySet();
			Iterator<String> iterator = keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				paramsArrayList.add(new BasicNameValuePair(key, params.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(paramsArrayList));
			
			if(headers != null) {
				Set<String> headersSet = headers.keySet();
				for (String key : headersSet) {
					post.setHeader(key, headers.get(key));
				}
			}
			
			HttpResponse responsePOST = client.execute(post);
			resEntityPost = responsePOST.getEntity();
		} catch (Exception e) {
			Log.e("POST RESPONSE", e.getMessage(), e);
			throw new HttpException(e.getMessage());
		} 
		
		return resEntityPost;
	}
}
