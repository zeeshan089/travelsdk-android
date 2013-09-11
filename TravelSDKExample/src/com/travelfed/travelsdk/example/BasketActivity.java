package com.travelfed.travelsdk.example;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.PersonInfo;
import com.travelfed.travelsdk.example.adapter.BasketAdapter;
import com.travelfed.travelsdk.process.ProcessBooking;

/**
 * 
 * @author krumstoilov
 *
 */
public class BasketActivity extends Activity {

	private ListView listView;
	private TextView textViewTotal;
	private Button buttonBook;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basket);
		
		// ListView contains basket items
		listView = (ListView) findViewById(R.id.listViewBasket);
		listView.setAdapter(new BasketAdapter(this, Basket.getBasketItems()));
		
		// Total
		textViewTotal = (TextView) findViewById(R.id.textViewTotal);
		if(Basket.hasItems()) {
			textViewTotal.setText("Total: " + Basket.getCurrency() + " " + Basket.getTotalPrice()/100f);
		}
		
		// Button book
		buttonBook = (Button) findViewById(R.id.buttonBook);
		buttonBook.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				book();
			}
		});
	}
	
	private void book() {
		if(!Basket.hasItems()) {
			SimpleDialog.alert("Basket is empty", BasketActivity.this);
			return;
		}
		
		//set traveler data
		PersonInfo personInfo = new PersonInfo();
		personInfo.setAge("20");
		personInfo.setCity("Berlin");
		personInfo.setCompany("Test company");
		personInfo.setCountry("Germany");
		personInfo.setCountryCode("DE");
		personInfo.setEmail("test@travelsdk.com");
		personInfo.setFirstName("TravelSDK");
		personInfo.setLastName("Family");
		personInfo.setMale(true);
		personInfo.setPhone("11111");
		personInfo.setPhoneAreaCode("11");
		personInfo.setPhoneCountryCode("49");
		personInfo.setSalutation("Mr");
		personInfo.setStreet("Test street");
		personInfo.setType(PersonInfo.TYPE_ADULT);
		personInfo.setZip("1000");
		// passport data - required for some flight bookings
		personInfo.setPassport("123456789");
		personInfo.setPassportExpireYear(2016);
		personInfo.setPassportExpireMonth(10);
		personInfo.setPassportExpireDayOfMonth(1);
		personInfo.setPassportIssueYear(2012);
		personInfo.setPassportIssueMonth(10);
		personInfo.setPassportIssueDayOfMonth(1);

		// Set travelers to the Basket
		ArrayList<PersonInfo> persons = new ArrayList<PersonInfo>();
		persons.add(personInfo);	
		Basket.setPersons(persons);
		
		// ProgressDialog
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Booking");
		progressDialog.setCancelable(false);
		
		// Create process object
		ProcessBooking processBooking = new ProcessBooking(personInfo) {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, BasketActivity.this);
					listView.setAdapter(null);
					textViewTotal.setText("");
					buttonBook.setEnabled(false);
					return;
				}
				// Booking is ok
				AlertDialog.Builder builder = new AlertDialog.Builder(BasketActivity.this);
		    	builder.setTitle("Info")
		    		.setMessage("Booking OK. Package id: " + getResult().getPackageId())
		    		.setCancelable(true)
		    		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		    			public void onClick(DialogInterface dialog, int id) {
		    				dialog.dismiss();
		    				BasketActivity.this.finish();	
		    			}
		    		});
		    	builder.show();
			}
		};
		
		// Show progress indication
		progressDialog.show();
		// Book
		TravelSDK.INSTANCE.book(processBooking);
	}


}
