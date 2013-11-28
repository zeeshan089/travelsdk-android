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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.TravelSDKException;
import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.HotelBasketItem;
import com.travelfed.travelsdk.bean.hotel.HotelsResult;
import com.travelfed.travelsdk.example.adapter.HotelAdapter;
import com.travelfed.travelsdk.process.ProcessHotelInfo;
import com.travelfed.travelsdk.process.ProcessHotelVerify;

/**
 * 
 * @author krumstoilov
 *
 */
public class HotelResultsActivity extends Activity implements AdapterView.OnItemClickListener {

	private HotelsResult hotelsResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel_results);
		
		hotelsResult = (HotelsResult) MainActivity.sharedObject;
		
		// total results, records count and page offset
		TextView textView = (TextView) findViewById(R.id.textViewHotelRecords);
		textView.setText("Records: " + (hotelsResult.getOffset() + 1) + " to " + hotelsResult.getHotelsFares().size() 
				+ " from " + hotelsResult.getTotal() + " total");
		
		// Load results into the list
		ListView listViewHotel = (ListView) findViewById(R.id.listViewHotelResults);
		HotelAdapter hotelAdapter = new HotelAdapter(this, hotelsResult.getHotelsFares(), this);
		listViewHotel.setAdapter(hotelAdapter);
	}

	@Override
	/**
	 * Handle hotel info or "Add to basket"
	 */
	public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {
		final ProgressDialog progressDialog;
		switch (view.getId()) {
		case R.id.hotelItemButtonTotal: // Verify and add to basket
			progressDialog = new ProgressDialog(this);
			progressDialog.setMessage("Verifying");
			progressDialog.setCancelable(false);
			
			//Create process object to verify the record
			ProcessHotelVerify processVerify = new ProcessHotelVerify(hotelsResult.getHotelsFares().get(index)) {
				
				@Override
				public void onComplete() {
					progressDialog.dismiss();
					// Check for error
					if(getErrorCode() != null) {
						// This will show error code but you need to show some user friendly message. See ErrorCodes
						SimpleDialog.alert("Error: " + errorCode, HotelResultsActivity.this);
						return;
					}
					// Verify is successful.
					// Add to basket
					try {
						Basket.addBasketItem(new HotelBasketItem(getHotelFare(), getResult()));
						AlertDialog.Builder builder = new AlertDialog.Builder(HotelResultsActivity.this);
				    	builder.setTitle("Alert")
				    		.setMessage("Added to basket")
				    		.setCancelable(false)
				    		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				    			public void onClick(DialogInterface dialog, int id) {
				    				dialog.dismiss();
				    				HotelResultsActivity.this.setResult(RESULT_OK);
				    				HotelResultsActivity.this.finish();	
				    			}
				    		});
				    	builder.show();
					} catch (TravelSDKException e) {
						SimpleDialog.alert("Error: " + e.getErrorCode(), HotelResultsActivity.this);
					}
					
				}
			};
			//Show progress indication
			progressDialog.show();
			// Verify
			TravelSDK.INSTANCE.verifyHotel(processVerify);
			break;
			
		case R.id.hotelItemButtonInfo: // Show hotel info
			progressDialog = new ProgressDialog(this);
			progressDialog.setMessage("Receiving information");
			progressDialog.setCancelable(false);
			
			// Create process object for hotel info
			ProcessHotelInfo processHotelInfo = new ProcessHotelInfo(hotelsResult.getHotelsFares().get(index)) {
				
				@Override
				public void onComplete() {
					progressDialog.dismiss();
					// Check for error
					if(getErrorCode() != null) {
						// This will show error code but you need to show some user friendly message. See ErrorCodes
						SimpleDialog.alert("Error: " + errorCode, HotelResultsActivity.this);
						return;
					}
					// Show hotel info
					Intent intent = new Intent(HotelResultsActivity.this, HotelInfoActivity.class);
					MainActivity.sharedObject = new Object[]{getResult().getHotelInfo(), getHotelFare()};
					startActivity(intent);
				}
			};
			// Show progress indication
			progressDialog.show();
			// Request hotel info
			TravelSDK.INSTANCE.hotelInfo(processHotelInfo);
			break;
		}
		
	}

}
