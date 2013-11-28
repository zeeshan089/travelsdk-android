/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Source code is free to use, copy and modify without limitations.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
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
import android.widget.DatePicker;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.bean.hotel.HotelSearchParameters;
import com.travelfed.travelsdk.process.ProcessSearchHotels;

/**
 * 
 * @author krumstoilov
 *
 */
public class HotelSearchActivity extends Activity implements DatePickerDialog.OnDateSetListener {

	private final static int REQUEST_DESTINATION = 0;
	private final static int REQUEST_HOTEL_RESULTS = 1;
	
	private final static int PICK_DEPARTURE_DATE = 0;
	private final static int PICK_RETURN_DATE = 1;
	
	private Button buttonDestination;
	private Button buttonCheckInDate;
	private Button buttonCheckOutDate;
	private Button buttonAdults;
	private Button buttonCategory;
	
	private int pickDate;
	
	private HotelSearchParameters hotelSearchParameters = new HotelSearchParameters();
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel_search);
		
		// Destination 
		buttonDestination = (Button) findViewById(R.id.buttonDestination);
		buttonDestination.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Select destination on the map
				Intent intent = new Intent(HotelSearchActivity.this, MapActivity.class);
				startActivityForResult(intent, REQUEST_DESTINATION);
			}
		});
		
		// Check in date
		buttonCheckInDate = (Button) findViewById(R.id.buttonCheckInDate);
		buttonCheckInDate.setText(dateFormat.format(hotelSearchParameters.getDepartureDate()));
		buttonCheckInDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(HotelSearchActivity.this, 
							HotelSearchActivity.this, hotelSearchParameters.getDepartureYear(), 
				hotelSearchParameters.getDepartureMonth(), hotelSearchParameters.getDepartureDayOfMonth());
				pickDate = PICK_DEPARTURE_DATE;
				datePickerDialog.show();
			}
		});
		
		// Check out date
		buttonCheckOutDate = (Button) findViewById(R.id.buttonCheckOutDate);
		buttonCheckOutDate.setText(dateFormat.format(hotelSearchParameters.getReturnDate()));
		buttonCheckOutDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(HotelSearchActivity.this, 
							HotelSearchActivity.this, hotelSearchParameters.getReturnYear(), 
				hotelSearchParameters.getReturnMonth(), hotelSearchParameters.getReturnDayOfMonth());
				pickDate = PICK_RETURN_DATE;
				datePickerDialog.show();
			}
		});
		
		// Adults
		buttonAdults = (Button) findViewById(R.id.buttonAdults);
		buttonAdults.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(HotelSearchActivity.this);
				builder.setTitle("Adults").setItems(R.array.adults, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int index) {
						hotelSearchParameters.getRoomPersons().setNumberOfAdults((short)(index + 1)); 
						buttonAdults.setText(String.valueOf(index + 1));
					}
				}).create().show();
			}
		});
		
		// Category
		buttonCategory = (Button) findViewById(R.id.buttonMinCategory);
		buttonCategory.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(HotelSearchActivity.this);
				builder.setTitle("Min. category").setItems(R.array.categories, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int index) {
						hotelSearchParameters.setMinHotelCategory((short)(index+1)); 
						buttonCategory.setText(String.valueOf(index + 1));
					}
				}).create().show();
			}
		});
		
		// Search button
		Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
		buttonSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				searchHotels();
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			switch (requestCode) {			
			case REQUEST_DESTINATION:
				// update search parameters
				hotelSearchParameters.setLat(data.getDoubleExtra("lat", 0));
				hotelSearchParameters.setLon(data.getDoubleExtra("lon", 0));
				buttonDestination.setText("Lat:" + hotelSearchParameters.getLat() 
						+ "; Lon:" + hotelSearchParameters.getLon());
				break;
			case REQUEST_HOTEL_RESULTS:
				this.finish();
			}
		}
	}
	
	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
		switch (pickDate) {
		case PICK_DEPARTURE_DATE:
			// update search parameters
			hotelSearchParameters.setDepartureDate(year, month, dayOfMonth);
			buttonCheckInDate.setText(dateFormat.format(hotelSearchParameters.getDepartureDate()));
			break;
		case PICK_RETURN_DATE:
			// update search parameters
			hotelSearchParameters.setReturnDate(year, month, dayOfMonth);
			buttonCheckOutDate.setText(dateFormat.format(hotelSearchParameters.getReturnDate()));
			break;
		}
	}

	/**
	 * Search hotels
	 */
	public void searchHotels() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Searching");
		progressDialog.setCancelable(false);
		
		// Create process object to search hotels for given search parameters
		ProcessSearchHotels processSearchHotels = new ProcessSearchHotels(hotelSearchParameters) {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, HotelSearchActivity.this);
					return;
				}
				// Show results
				Intent intent = new Intent(HotelSearchActivity.this, HotelResultsActivity.class);
				MainActivity.sharedObject = getResult();
				startActivityForResult(intent, REQUEST_HOTEL_RESULTS);
			}
		};
		
		// Show progress indication
		progressDialog.show();
		// Search hotels
		TravelSDK.INSTANCE.searchHotels(processSearchHotels);
	}

}
