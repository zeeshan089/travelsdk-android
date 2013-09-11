package com.travelfed.travelsdk.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.travelfed.travelsdk.bean.BookingListResult;

/**
 * 
 * @author krumstoilov
 *
 */
public class MyBookingsActivity extends Activity {

	BookingListResult bookingListResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_bookings);
		
		// Get bookings result
		bookingListResult = (BookingListResult) MainActivity.sharedObject;
		
		TextView textView = (TextView) findViewById(R.id.textViewBookings);
		textView.setText("Packages: " + bookingListResult.getBookingPackages().size());
	}

}
