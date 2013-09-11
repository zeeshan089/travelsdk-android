package com.travelfed.travelsdk;

import android.util.Log;



/**
 * Class for debug and error logging.
 *
 */
public class Logger {

	private String logName;

	public Logger(Class classObject) {
		logName = classObject.getSimpleName();
	}

	public void debug(String message) {
		if (this.isDebug()) {
			Log.d(logName, message);
		}
	}

	public void error(String message) {
		Log.e(logName, message);
	}

	public void error(Exception e, String message) {
		Log.e(logName, message, e);
	}

	public void error(Exception e) {
		Log.d(logName, "", e);
	}
	
	public boolean isDebug() {
		return TravelSDK.isDebug;
	}

}
