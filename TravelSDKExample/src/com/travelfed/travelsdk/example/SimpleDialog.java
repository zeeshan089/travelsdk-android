package com.travelfed.travelsdk.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Class for alert dialog
 */
public final class SimpleDialog {

	
	private SimpleDialog() {
	}
	
	public static void alert(String message, Activity activity) {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    	builder.setTitle("Alert")
    		.setMessage(message)
    		.setCancelable(false)
    		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    				dialog.dismiss();
    			}
    		});
    	builder.show();
	}
}
