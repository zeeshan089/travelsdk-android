package com.travelfed.travelsdk.example.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.travelfed.travelsdk.bean.hotel.HotelFare;
import com.travelfed.travelsdk.example.R;

/**
 * 
 * @author krumstoilov
 *
 */
public class HotelAdapter extends ArrayAdapter<HotelFare> {
	
	private AdapterView.OnItemClickListener onItemClickListener;
	
	public HotelAdapter(Context context, List<HotelFare> objects, AdapterView.OnItemClickListener onItemClickListener) {
		super(context, R.layout.list_item_hotel, objects);
		this.onItemClickListener = onItemClickListener;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item_hotel, null, true);
        } 
        
        HotelFare hotelFare = getItem(position);
        
        // hotel name
        TextView textViewHotelName = (TextView) rowView.findViewById(R.id.hotelItemName);
        textViewHotelName.setText(hotelFare.getHotelName());
        
        // hotel info button
        Button buttonHotelInfo = (Button) rowView.findViewById(R.id.hotelItemButtonInfo);
        buttonHotelInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick(null, v, position, 0);
			}
		});
        
        // Short info
		StringBuffer stringBuffer = new StringBuffer("Category: ");
		stringBuffer.append(hotelFare.getHotelCategory());
		stringBuffer.append(", Board type: ").append(hotelFare.getBoardTypeDescription());
		((TextView) rowView.findViewById(R.id.hotelItemInfo)).setText(stringBuffer.toString());
		
        //  Total
        Button buttonGo = (Button) rowView.findViewById(R.id.hotelItemButtonTotal);
        buttonGo.setText(hotelFare.getCurrency() + " " + hotelFare.getTotalPrice() + " > ");
        buttonGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick(null, v, position, 0);
			}
		});

        return rowView;
	}

}
