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
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.bean.excursion.ExcursionSearchParameters;
import com.travelfed.travelsdk.process.ProcessSearchExcursions;

/**
 * 
 * @author krumstoilov
 *
 */
public class ExcursionSearchActivity extends Activity implements DatePickerDialog.OnDateSetListener {

	private final static int REQUEST_DESTINATION = 0;
	private final static int REQUEST_EXCURSION_RESULTS = 1;
	
	private final static int PICK_DEPARTURE_DATE = 0;
	private final static int PICK_RETURN_DATE = 1;
	
	private Button buttonDestination;
	private Button buttonFromDate;
	private Button buttonToDate;
	
	private int pickDate;
	
	private ExcursionSearchParameters searchParameters = new ExcursionSearchParameters();
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_excursion_search);
		
		// Destination
		buttonDestination = (Button) findViewById(R.id.buttonDestination);
		buttonDestination.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Select destination on map
				Intent intent = new Intent(ExcursionSearchActivity.this, MapActivity.class);
				startActivityForResult(intent, REQUEST_DESTINATION);
			}
		});
		
		// From date
		buttonFromDate = (Button) findViewById(R.id.buttonFromDate);
		buttonFromDate.setText(dateFormat.format(searchParameters.getFromDate()));
		buttonFromDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(ExcursionSearchActivity.this, 
							ExcursionSearchActivity.this, searchParameters.getFromDateYear(), 
							searchParameters.getFromDateMonth(), searchParameters.getFromDateDayOfMonth());
				pickDate = PICK_DEPARTURE_DATE;
				datePickerDialog.show();
			}
		});
		
		// To date
		buttonToDate = (Button) findViewById(R.id.buttonToDate);
		buttonToDate.setText(dateFormat.format(searchParameters.getToDate()));
		buttonToDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(ExcursionSearchActivity.this, 
							ExcursionSearchActivity.this, searchParameters.getToDateYear(), 
							searchParameters.getToDateMonth(), searchParameters.getToDateDayOfMonth());
				pickDate = PICK_RETURN_DATE;
				datePickerDialog.show();
			}
		});
	
		// Search button
		Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
		buttonSearch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				searchExcursions();
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			switch (requestCode) {			
			case REQUEST_DESTINATION:
				// Update search parameters
				searchParameters.setLat(data.getDoubleExtra("lat", 0));
				searchParameters.setLon(data.getDoubleExtra("lon", 0));
				buttonDestination.setText("Lat:" + searchParameters.getLat() 
						+ "; Lon:" + searchParameters.getLon());
				break;
			case REQUEST_EXCURSION_RESULTS:
				this.finish();
			}
		}
	}
	
	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
		switch (pickDate) {
		case PICK_DEPARTURE_DATE:
			// Update search parameters
			searchParameters.setFromDate(year, month, dayOfMonth);
			buttonFromDate.setText(dateFormat.format(searchParameters.getFromDate()));
			break;
		case PICK_RETURN_DATE:
			// Update search parameters
			searchParameters.setToDate(year, month, dayOfMonth);
			buttonToDate.setText(dateFormat.format(searchParameters.getToDate()));
			break;
		}
	}

	/**
	 * Search excursions
	 */
	public void searchExcursions() {
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Searching");
		progressDialog.setCancelable(false);
		
		// Create process object with given searchParameters
		ProcessSearchExcursions processSearch = new ProcessSearchExcursions(searchParameters) {
			
			@Override
			public void onComplete() {
				progressDialog.dismiss();
				// Check for error first
				if(getErrorCode() != null) {
					// This will show error code but you need to show some user friendly message. See ErrorCodes
					SimpleDialog.alert("Error: " + errorCode, ExcursionSearchActivity.this);
					return;
				}
				// Get and show results
				Intent intent = new Intent(ExcursionSearchActivity.this, ExcursionResultsActivity.class);
				MainActivity.sharedObject = getResult();
				startActivityForResult(intent, REQUEST_EXCURSION_RESULTS);
			}
		};
		// Show progress indication
		progressDialog.show();
		// Search excursions
		TravelSDK.INSTANCE.searchExcursions(processSearch);
	}


	
}
