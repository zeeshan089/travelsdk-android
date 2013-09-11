package com.travelfed.travelsdk.example;

import java.text.DateFormat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.bean.flight.Airport;
import com.travelfed.travelsdk.bean.rentacar.RentacarSearchParameters;
import com.travelfed.travelsdk.process.ProcessSearchRentacars;

/**
 * 
 * @author krumstoilov
 *
 */
public class RentacarSeachActivity extends Activity implements DatePickerDialog.OnDateSetListener {

	private final static int REQUEST_AIRPORT_FROM = 0;
	private final static int REQUEST_AIRPORT_TO = 1;
	private final static int REQUEST_RENTACARS_RESULTS = 2;
	
	private final static int PICK_DEPARTURE_DATE = 0;
	private final static int PICK_RETURN_DATE = 1;
	
	private Button buttonFrom;
	private Button buttonTo;
	private Button buttonPickUpDate;
	private Button buttonDropOffDate;
	
	private int pickDate;
	
	private RentacarSearchParameters searchParameters = new RentacarSearchParameters();
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rentacar_seach);
		
		// From airport
		buttonFrom = (Button) findViewById(R.id.buttonFrom);
		buttonFrom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Show search airport
				Intent intent = new Intent(RentacarSeachActivity.this, AirportSearchActivity.class);
				startActivityForResult(intent, REQUEST_AIRPORT_FROM);
			}
		});
		
		// To airport
		buttonTo = (Button) findViewById(R.id.buttonTo);
		buttonTo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Show search airport
				Intent intent = new Intent(RentacarSeachActivity.this, AirportSearchActivity.class);
				startActivityForResult(intent, REQUEST_AIRPORT_TO);
			}
		});		
		
		// Pick up date
		buttonPickUpDate = (Button) findViewById(R.id.buttonPickUpDate);
		buttonPickUpDate.setText(dateFormat.format(searchParameters.getDepartureDate()));
		buttonPickUpDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(RentacarSeachActivity.this, 
							RentacarSeachActivity.this, searchParameters.getDepartureYear(), 
				searchParameters.getDepartureMonth(), searchParameters.getDepartureDayOfMonth());
				pickDate = PICK_DEPARTURE_DATE;
				datePickerDialog.show();
			}
		});
		
		// Drop off date
		buttonDropOffDate = (Button) findViewById(R.id.buttonDropOffDate);
		buttonDropOffDate.setText(dateFormat.format(searchParameters.getReturnDate()));
		buttonDropOffDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(RentacarSeachActivity.this, 
							RentacarSeachActivity.this, searchParameters.getReturnYear(), 
				searchParameters.getReturnMonth(), searchParameters.getReturnDayOfMonth());
				pickDate = PICK_RETURN_DATE;
				datePickerDialog.show();
			}
		});
		
		// Search button
		Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
		buttonSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				searchRentacars();
			}
		});
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			Airport airport;
			switch (requestCode) {			
			case REQUEST_AIRPORT_FROM:
				airport = (Airport) data.getExtras().get("airport");
				buttonFrom.setText(airport.toString());
				// update search parameters
				searchParameters.setFromAirportId(airport.getId());
				break;
			case REQUEST_AIRPORT_TO:
				airport = (Airport) data.getExtras().get("airport");
				buttonTo.setText(airport.toString());
				// update search parameters
				searchParameters.setToAirportId(airport.getId());
				break;
			case REQUEST_RENTACARS_RESULTS:
				this.finish();
			}
		}
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
		switch (pickDate) {
		case PICK_DEPARTURE_DATE:
			// update search parameters
			searchParameters.setDepartureDate(year, month, dayOfMonth);
			buttonPickUpDate.setText(dateFormat.format(searchParameters.getDepartureDate()));
			break;
		case PICK_RETURN_DATE:
			// update search parameters
			searchParameters.setReturnDate(year, month, dayOfMonth);
			buttonDropOffDate.setText(dateFormat.format(searchParameters.getReturnDate()));
			break;
		}
	}
	
	/**
	 * Search
	 */
	private void searchRentacars() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Searching");
		progressDialog.setCancelable(false);
		
		// Create process object with given search parameters
		ProcessSearchRentacars processSearch = new ProcessSearchRentacars(searchParameters) {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, RentacarSeachActivity.this);
					return;
				}
				// Show results
				Intent intent = new Intent(RentacarSeachActivity.this, RentacarResultsActivity.class);
				MainActivity.sharedObject = getResult();
				startActivityForResult(intent, REQUEST_RENTACARS_RESULTS);
			}
		};
		
		// Show progress indication
		progressDialog.show();
		// Search rentacars
		TravelSDK.INSTANCE.searchRentacars(processSearch);
	}

}
