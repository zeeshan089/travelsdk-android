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
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.TravelSDKException;
import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.RentacarBasketItem;
import com.travelfed.travelsdk.bean.rentacar.RentacarsResult;
import com.travelfed.travelsdk.example.adapter.RentacarAdapter;
import com.travelfed.travelsdk.process.ProcessRentacarVerify;

/**
 * 
 * @author krumstoilov
 *
 */
public class RentacarResultsActivity extends Activity implements AdapterView.OnItemClickListener {

	private RentacarsResult rentacarsResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rentacar_results);
		
		// Get rentacars result
		rentacarsResult = (RentacarsResult) MainActivity.sharedObject;
		
		// total results, records count and page offset
		TextView textView = (TextView) findViewById(R.id.textViewRentacarRecords);
		textView.setText("Records: " + (rentacarsResult.getOffset() + 1) + " to " + rentacarsResult.getRentacars().size() 
				+ " from " + rentacarsResult.getTotal() + " total");
		
		// Load results into the list
		ListView listView = (ListView) findViewById(R.id.listViewRentacarResults);
		RentacarAdapter adapter = new RentacarAdapter(this, rentacarsResult.getRentacars(), this);
		listView.setAdapter(adapter);
	}

	@Override
	/**
	 * Handle "Add to basket"
	 */
	public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Verifying");
		progressDialog.setCancelable(false);

		// Verify before adding to the basket
		// Create process object for verify
		ProcessRentacarVerify processVerify = new ProcessRentacarVerify(rentacarsResult.getRentacars().get(index)) {
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if (getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, RentacarResultsActivity.this);
					return;
				}
				// Verify is successful.
				// Add to basket
				try {
					Basket.addBasketItem(new RentacarBasketItem(getRentacar(), getResult()));
					AlertDialog.Builder builder = new AlertDialog.Builder(RentacarResultsActivity.this);
					builder.setTitle("Alert").setMessage("Added to basket").setCancelable(false)
							.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.dismiss();
									RentacarResultsActivity.this.setResult(RESULT_OK);
									RentacarResultsActivity.this.finish();
								}
							});
					builder.show();
				} catch (TravelSDKException e) {
					SimpleDialog.alert("Error: " + e.getErrorCode(), RentacarResultsActivity.this);
				}
			}
		};

		// Show progress indication
		progressDialog.show();
		// Verify
		TravelSDK.INSTANCE.verifyRentacar(processVerify);
	}

}
