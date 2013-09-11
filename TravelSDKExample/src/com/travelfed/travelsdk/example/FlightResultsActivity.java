package com.travelfed.travelsdk.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.TravelSDKException;
import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.FlightBasketItem;
import com.travelfed.travelsdk.bean.flight.FlightsResult;
import com.travelfed.travelsdk.example.adapter.FlightAdapter;
import com.travelfed.travelsdk.process.ProcessFlightVerify;

/**
 * 
 * @author krumstoilov
 *
 */
public class FlightResultsActivity extends Activity implements AdapterView.OnItemClickListener {

	private FlightsResult  flightsResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flight_results);
		
		// get results
		flightsResult = (FlightsResult) MainActivity.sharedObject;
		
		// total results, records count and page offset
		TextView textView = (TextView) findViewById(R.id.textViewFlightRecords);
		textView.setText("Records: " + (flightsResult.getOffset() + 1) + " to " + flightsResult.getFares().size() 
				+ " from " + flightsResult.getTotal() + " total");
		
		// Load results
		ListView listViewFlights = (ListView) findViewById(R.id.listViewFlightResults);
		FlightAdapter flightAdapter = new FlightAdapter(this, flightsResult.getFares(), this);
		listViewFlights.setAdapter(flightAdapter);
	}

	@Override
	/**
	 * Handle "Add to basket" click
	 */
	public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Verifying");
		progressDialog.setCancelable(false);
		
		// Verify record before adding it to the basket.
		// Create process object
		ProcessFlightVerify processVerify = new ProcessFlightVerify(flightsResult.getFares().get(index)) {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, FlightResultsActivity.this);
					return;
				}
				// Verify is successful.
				// Add to basket
				try {
					Basket.addBasketItem(new FlightBasketItem(getFlightFare(), getResult()));
					AlertDialog.Builder builder = new AlertDialog.Builder(FlightResultsActivity.this);
			    	builder.setTitle("Alert")
			    		.setMessage("Added to basket")
			    		.setCancelable(false)
			    		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			    			public void onClick(DialogInterface dialog, int id) {
			    				dialog.dismiss();
			    				FlightResultsActivity.this.setResult(RESULT_OK);
								FlightResultsActivity.this.finish();	
			    			}
			    		});
			    	builder.show();
				} catch (TravelSDKException e) {
					SimpleDialog.alert("Error: " + e.getErrorCode(), FlightResultsActivity.this);
				}
				
			}
		};
		// Show progress indication
		progressDialog.show();
		// Verify
		TravelSDK.INSTANCE.verifyFlight(processVerify);
	}


}
