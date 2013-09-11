package com.travelfed.travelsdk.example;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

/**
 * 
 * @author krumstoilov
 *
 */
public class MapActivity extends FragmentActivity implements GoogleMap.OnCameraChangeListener {

	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		// Select location
		Button buttonSelect = (Button) findViewById(R.id.buttonMapSelect);
		buttonSelect.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("lat", map.getCameraPosition().target.latitude);
				intent.putExtra("lon", map.getCameraPosition().target.longitude);
				MapActivity.this.setResult(RESULT_OK, intent);
				MapActivity.this.finish();
			}
		});
		
		map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		if(map != null) {
			map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(52.51, 13.38)));
			map.moveCamera(CameraUpdateFactory.zoomTo(11));
			map.setOnCameraChangeListener(this);
		}
		
	}

	@Override
	public void onCameraChange(CameraPosition position) {
		// Add circle in center of the map
		map.clear();
		CircleOptions circleOptions = new CircleOptions();
		circleOptions.center(position.target);
		circleOptions.radius(2000); // 2km
		circleOptions.strokeColor(Color.BLUE);
		circleOptions.strokeWidth(1);
		circleOptions.fillColor(0x200000FF);
		map.addCircle(circleOptions);
	}


}
