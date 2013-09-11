package com.travelfed.travelsdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.travelfed.travelsdk.Logger;

/**
 * This class is a wrapper class of URLEncoder
 * 
 * @author Nikolay Taskov
 */
public class URLEncoderUtil {
	
	private static Logger logger = new Logger(URLEncoder.class);
	
	public static String encodeUTF8(String str) {
		String encodedString = null;
		try {
			encodedString = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			encodedString = str;
			logger.error(e);
		}
		return encodedString;
	}
}
