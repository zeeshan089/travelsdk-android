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
import com.travelfed.travelsdk.basket.ExcursionBasketItem;
import com.travelfed.travelsdk.bean.excursion.ExcursionsResult;
import com.travelfed.travelsdk.example.adapter.ExcursionAdapter;
import com.travelfed.travelsdk.process.ProcessExcursionVerify;

public class ExcursionResultsActivity extends Activity implements AdapterView.OnItemClickListener {

	private ExcursionsResult excursionResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_excursion_results);
		
		// Get excursion results from excursion search 
		excursionResult = (ExcursionsResult) MainActivity.sharedObject;
		
		// total results, records count and page offset 
		TextView textView = (TextView) findViewById(R.id.textViewRecords);
		textView.setText("Records: " + (excursionResult.getOffset() + 1) + " to " + excursionResult.getExcursions().size() 
				+ " from " + excursionResult.getTotal() + " total");
		
		// List with results
		ListView listView = (ListView) findViewById(R.id.listViewResults);
		ExcursionAdapter adapter = new ExcursionAdapter(this, excursionResult.getExcursions(), this);
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

		// Create process object
		ProcessExcursionVerify processVerify = new ProcessExcursionVerify(excursionResult.getExcursions().get(index)) {
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error
				if (getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, ExcursionResultsActivity.this);
					return;
				}
				// Verify is successful.
				// Add to basket
				try {
					Basket.addBasketItem(new ExcursionBasketItem(getExcursion(), getResult()));
					AlertDialog.Builder builder = new AlertDialog.Builder(ExcursionResultsActivity.this);
					builder.setTitle("Alert").setMessage("Added to basket").setCancelable(false)
							.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.dismiss();
									ExcursionResultsActivity.this.setResult(RESULT_OK);
									ExcursionResultsActivity.this.finish();
								}
							});
					builder.show();
				} catch (TravelSDKException e) {
					SimpleDialog.alert("Error: " + e.getErrorCode(), ExcursionResultsActivity.this);
				}
			}
		};

		// Show progress indication
		progressDialog.show();
		// Verify
		TravelSDK.INSTANCE.verifyExcursion(processVerify);
	}



}
