package com.travelfed.travelsdk.example;

import java.text.DateFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.bean.flight.Airport;
import com.travelfed.travelsdk.bean.flight.FlightSearchParameters;
import com.travelfed.travelsdk.process.ProcessSearchFlights;

/**
 * 
 * @author krumstoilov
 *
 */
public class FlightSeachActivity extends Activity implements DatePickerDialog.OnDateSetListener {

	private final static int REQUEST_AIRPORT_FROM = 0;
	private final static int REQUEST_AIRPORT_TO = 1;
	private final static int REQUEST_FLIGHT_RESULTS = 2;
	
	private final static int PICK_DEPARTURE_DATE = 0;
	private final static int PICK_RETURN_DATE = 1;
	
	private Button buttonFrom;
	private Button buttonTo;
	private Button buttonDepartureDate;
	private Button buttonReturnDate;
	private Button buttonAdults;
	
	private int pickDate;
	
	private FlightSearchParameters flightSearchParameters = new FlightSearchParameters();
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flight_seach);
		
		// From airport
		buttonFrom = (Button) findViewById(R.id.buttonFrom);
		buttonFrom.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FlightSeachActivity.this, AirportSearchActivity.class);
				startActivityForResult(intent, REQUEST_AIRPORT_FROM);
			}
		});
		
		// To airport
		buttonTo = (Button) findViewById(R.id.buttonTo);
		buttonTo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FlightSeachActivity.this, AirportSearchActivity.class);
				startActivityForResult(intent, REQUEST_AIRPORT_TO);
			}
		});		
		
		// Departure date
		buttonDepartureDate = (Button) findViewById(R.id.buttonDepartureDate);
		buttonDepartureDate.setText(dateFormat.format(flightSearchParameters.getDepartureDate()));
		buttonDepartureDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(FlightSeachActivity.this, 
							FlightSeachActivity.this, flightSearchParameters.getDepartureYear(), 
				flightSearchParameters.getDepartureMonth(), flightSearchParameters.getDepartureDayOfMonth());
				pickDate = PICK_DEPARTURE_DATE;
				datePickerDialog.show();
			}
		});
		
		// Return date
		CheckBox checkBoxReturn = (CheckBox) findViewById(R.id.checkBoxReturn);
		checkBoxReturn.setChecked(flightSearchParameters.isRoundTrip());
		checkBoxReturn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				flightSearchParameters.setRoundTrip(isChecked);
				buttonReturnDate.setEnabled(flightSearchParameters.isRoundTrip());
			}
		});
		
		buttonReturnDate = (Button) findViewById(R.id.buttonReturnDate);
		buttonReturnDate.setText(dateFormat.format(flightSearchParameters.getReturnDate()));
		buttonReturnDate.setEnabled(flightSearchParameters.isRoundTrip());
		buttonReturnDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(FlightSeachActivity.this, 
							FlightSeachActivity.this, flightSearchParameters.getReturnYear(), 
				flightSearchParameters.getReturnMonth(), flightSearchParameters.getReturnDayOfMonth());
				pickDate = PICK_RETURN_DATE;
				datePickerDialog.show();
			}
		});
		
		// Adults
		buttonAdults = (Button) findViewById(R.id.buttonAdults);
		buttonAdults.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(FlightSeachActivity.this);
				builder.setTitle("Adults").setItems(R.array.adults, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int index) {
						flightSearchParameters.setNumberOfAdults(index + 1); 
						buttonAdults.setText(String.valueOf(index + 1));
					}
				}).create().show();
			}
		});
		
		// Search button
		Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
		buttonSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				searchFlights();
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
				flightSearchParameters.setFromAirportId(airport.getId());
				break;
			case REQUEST_AIRPORT_TO:
				airport = (Airport) data.getExtras().get("airport");
				buttonTo.setText(airport.toString());
				// update search parameters
				flightSearchParameters.setToAirportId(airport.getId());
				break;
			case REQUEST_FLIGHT_RESULTS:
				// close to MainActivity
				this.finish();
			}
		}
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
		switch (pickDate) {
		case PICK_DEPARTURE_DATE:
			// update search parameters
			flightSearchParameters.setDepartureDate(year, month, dayOfMonth);
			buttonDepartureDate.setText(dateFormat.format(flightSearchParameters.getDepartureDate()));
			break;
		case PICK_RETURN_DATE:
			// update search parameters
			flightSearchParameters.setReturnDate(year, month, dayOfMonth);
			buttonReturnDate.setText(dateFormat.format(flightSearchParameters.getReturnDate()));
			break;
		}
	}
	
	/**
	 * Search flights
	 */
	private void searchFlights() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Searching");
		progressDialog.setCancelable(false);
		
		// Create process object with given search parameters
		ProcessSearchFlights processSearchFlights = new ProcessSearchFlights(flightSearchParameters) {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, FlightSeachActivity.this);
					return;
				}
				// Get and show results
				Intent intent = new Intent(FlightSeachActivity.this, FlightResultsActivity.class);
				MainActivity.sharedObject = getResult();
				startActivityForResult(intent, REQUEST_FLIGHT_RESULTS);
			}
		};
		
		// Show progress indication
		progressDialog.show();
		// Search flights
		TravelSDK.INSTANCE.searchFlights(processSearchFlights);
	}

}
