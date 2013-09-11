package com.travelfed.travelsdk.example;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.TravelSDKException;
import com.travelfed.travelsdk.process.ProcessBookingsList;
import com.travelfed.travelsdk.process.ProcessInit;

/**
 * 
 * @author krumstoilov
 *
 */
public class MainActivity extends Activity {

	static Object sharedObject;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Flight search
		Button buttonFlightSearch = (Button) findViewById(R.id.buttonFlightSearch);
		buttonFlightSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!TravelSDK.INSTANCE.isInitialized()) {
					SimpleDialog.alert("TravelSDK is not initialized.", MainActivity.this);
					return;
				}
				Intent intent = new Intent(MainActivity.this, FlightSeachActivity.class);
				startActivity(intent);
			}
		});
		
		// Hotel search
		Button buttonHotelSearch = (Button) findViewById(R.id.buttonHotelSearch);
		buttonHotelSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!TravelSDK.INSTANCE.isInitialized()) {
					SimpleDialog.alert("TravelSDK is not initialized.", MainActivity.this);
					return;
				}
				Intent intent = new Intent(MainActivity.this, HotelSearchActivity.class);
				startActivity(intent);
			}
		});
		
		// Rentacar search
		Button buttonRentacarSearch = (Button) findViewById(R.id.buttonRentacarSearch);
		buttonRentacarSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!TravelSDK.INSTANCE.isInitialized()) {
					SimpleDialog.alert("TravelSDK is not initialized.", MainActivity.this);
					return;
				}
				Intent intent = new Intent(MainActivity.this, RentacarSeachActivity.class);
				startActivity(intent);
			}
		});
		
		// Excursion search
		Button buttonExcursionSearch = (Button) findViewById(R.id.buttonExcursionSearch);
		buttonExcursionSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!TravelSDK.INSTANCE.isInitialized()) {
					SimpleDialog.alert("TravelSDK is not initialized.", MainActivity.this);
					return;
				}
				Intent intent = new Intent(MainActivity.this, ExcursionSearchActivity.class);
				startActivity(intent);
			}
		});
		
		// Basket
		Button buttonBasket = (Button) findViewById(R.id.buttonBasket);
		buttonBasket.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!TravelSDK.INSTANCE.isInitialized()) {
					SimpleDialog.alert("TravelSDK is not initialized.", MainActivity.this);
					return;
				}
				Intent intent = new Intent(MainActivity.this, BasketActivity.class);
				startActivity(intent);
			}
		});
		
		// My bookings
		Button buttonMyBookings = (Button) findViewById(R.id.buttonBookings);
		buttonMyBookings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!TravelSDK.INSTANCE.isInitialized()) {
					SimpleDialog.alert("TravelSDK is not initialized.", MainActivity.this);
					return;
				}
				showMyBookings();
			}
		});

	}
	
	@Override
	protected void onStart() {
		super.onStart();
		// Init Travel SDK
		if(!TravelSDK.INSTANCE.isInitialized()) {
			initTravelSDK();
		}
	}

	/**
	 * Init Travel SDK
	 */
	private void initTravelSDK() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Initialization");
		progressDialog.setCancelable(false);
		
		// Create process object with given data
		ProcessInit processInit = new ProcessInit("DE015016", "demo", "demo", "demo@travelsdk.com", "") {
			
			@Override
			public void onComplete() { 
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + getErrorCode(), MainActivity.this);
					return;
				}
				// Initialization is successful
				SimpleDialog.alert("Initialization complete." +
						"\nClient ID: " + TravelSDK.INSTANCE.getAgencyInfoResult().getAgencyId() +
						"\nUser: demo" + 
						"\nAccess token: " + TravelSDK.INSTANCE.getLoginResult().getAccessToken(), MainActivity.this);
			}
		};
		
		try {
			// show some progress indication
			progressDialog.show();
			// Enable debug log
			TravelSDK.setDebug(true);
			// init travel SDK instance
			TravelSDK.INSTANCE.init(processInit);
		} catch (TravelSDKException e) {
			progressDialog.dismiss();
			SimpleDialog.alert(e.getMessage(), this);
		}
	}
	
	/**
	 * Show bookings
	 */
	private void showMyBookings() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Receiving bookings");
		progressDialog.setCancelable(false);
		
		// Create process object 
		ProcessBookingsList processBookingsList = new ProcessBookingsList() {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + getErrorCode(), MainActivity.this);
					return;
				}
				sharedObject = getResult();
				Intent intent = new Intent(MainActivity.this, MyBookingsActivity.class);
				startActivity(intent);
			}
		};
		// Show progress indication
		progressDialog.show();
		// Request bookings list
		TravelSDK.INSTANCE.receiveBookings(processBookingsList);
		
	}

}
