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
