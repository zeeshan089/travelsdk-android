package com.travelfed.travelsdk.example;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.bean.flight.Airport;
import com.travelfed.travelsdk.process.ProcessSearchAirports;

/**
 * 
 * @author krumstoilov
 *
 */
public class AirportSearchActivity extends Activity {

	private List<Airport> airports;
	private ListView listViewAirports;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_airport_search);
		
		// Search button
		Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
		buttonSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				searchAirports();
			}
		});
		
		// ListView for results
		listViewAirports = (ListView)this.findViewById(R.id.listViewAirports);
		listViewAirports.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent();
				if(airports != null) {
					// set selected airport for result
					Airport airport = airports.get(position);
					intent.putExtra("airport", airport);
					setResult(RESULT_OK, intent);
				} else {
					setResult(RESULT_CANCELED, intent);
				}
				// close activity
				finish();
			}
		});
	}
	
	/**
	 * Search airports by entered query in EditText
	 */
	private void searchAirports() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Searching");
		progressDialog.setCancelable(false);
		
		EditText editTextQuery = (EditText) findViewById(R.id.editTextQuery);
		// Create process object
		ProcessSearchAirports processSearchAirports = new ProcessSearchAirports(editTextQuery.getText().toString()) {
			
			@Override
			public void onComplete() {
				// Hide progress indication
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, AirportSearchActivity.this);
					return;
				}
				// Get result
				AirportSearchActivity.this.airports = getResult().getAirports();				
				AirportSearchActivity.this.runOnUiThread(new Runnable() {
				    public void run() {
				    	// Show results
				    	listViewAirports.setAdapter(new ArrayAdapter<Airport>(AirportSearchActivity.this, 
				    			android.R.layout.simple_list_item_1, airports));
				    }
				});
			}
		};
		// Show progress indication
		progressDialog.show();
		// Search airports
		TravelSDK.INSTANCE.searchAirports(processSearchAirports);
	}

}
