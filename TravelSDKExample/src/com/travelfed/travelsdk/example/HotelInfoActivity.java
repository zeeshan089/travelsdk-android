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

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.travelfed.travelsdk.bean.hotel.HotelFare;
import com.travelfed.travelsdk.bean.hotel.HotelInfo;

/**
 * 
 * @author krumstoilov
 *
 */
public class HotelInfoActivity extends Activity {

	private HotelInfo hotelInfo;
	private HotelFare hotelFare;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotel_info);
		
		// Get hotel info and hotel fare
		hotelInfo = (HotelInfo) ((Object[]) MainActivity.sharedObject)[0];
		hotelFare = (HotelFare) ((Object[]) MainActivity.sharedObject)[1];
		
		// Hotel name
		TextView textViewHotelName = (TextView) findViewById(R.id.hotelInfoHotelName);
		textViewHotelName.setText(hotelInfo.getHotelName());
		
		// Image
		ImageView imageView = (ImageView) findViewById(R.id.hotelInfoImage);
		new DownloadImageTask(imageView).execute(hotelFare.getPicture());
		
		// Category
		TextView textViewCategory = (TextView) findViewById(R.id.hotelInfoCategory);
		textViewCategory.setText("Category: " + hotelFare.getHotelCategory());
		
		// Address
		TextView textViewAddress = (TextView) findViewById(R.id.hotelInfoAddress);
		textViewAddress.setText("Address: " + hotelInfo.getStreet());
		
		// Distance
		TextView textViewDistance = (TextView) findViewById(R.id.hotelInfoDistance);
		textViewDistance.setText("Distance (km): " + hotelFare.getDistance());
		
		// Country
		TextView textViewCountry = (TextView) findViewById(R.id.hotelInfoCountry);
		textViewCountry.setText("Country: " + hotelFare.getCountry());
		
		// City
		TextView textViewArea = (TextView) findViewById(R.id.hotelInfoArea);
		textViewArea.setText("City: " + hotelFare.getArea());
		
		// Info
		TextView textViewInfo = (TextView) findViewById(R.id.hotelInfoInfo);
		textViewInfo.setText(hotelInfo.getInfo());
	}
	
	
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView imageView;

		public DownloadImageTask(ImageView bmImage) {
		    this.imageView = bmImage;
		}

		protected Bitmap doInBackground(String... urls) {
		    String urldisplay = urls[0];
		    Bitmap mIcon11 = null;
		    try {
		        InputStream in = new java.net.URL(urldisplay).openStream();
		        mIcon11 = BitmapFactory.decodeStream(in);
		    } catch (Exception e) {
		        Log.e("Error", e.getMessage());
		        e.printStackTrace();
		    }
		    return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			// show downloaded image
			imageView.setImageBitmap(result);
		}
	}

}
