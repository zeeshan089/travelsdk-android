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

import com.travelfed.travelsdk.bean.rentacar.Rentacar;
import com.travelfed.travelsdk.example.R;

/**
 * 
 * @author krumstoilov
 *
 */
public class RentacarAdapter extends ArrayAdapter<Rentacar> {
	
	private AdapterView.OnItemClickListener onItemClickListener;
	
	public RentacarAdapter(Context context, List<Rentacar> objects, AdapterView.OnItemClickListener onItemClickListener) {
		super(context, R.layout.list_item_rentacar, objects);
		this.onItemClickListener = onItemClickListener;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item_rentacar, null, true);
        } 
        
        Rentacar rentacar = getItem(position);
        
        // Model
        TextView textViewModel = (TextView) rowView.findViewById(R.id.rentacarItemModel);
        textViewModel.setText(rentacar.getModelname());
        
        // Details
		StringBuffer stringBuffer = new StringBuffer("Class: ");
		stringBuffer.append(rentacar.getClassname());
		stringBuffer.append(", doors: ").append(rentacar.getDoors());
		((TextView) rowView.findViewById(R.id.rentacarItemDetails)).setText(stringBuffer.toString());
		
        //  Total
        Button buttonGo = (Button) rowView.findViewById(R.id.rentacarItemTotal);
        buttonGo.setText(rentacar.getCurrency() + " " + rentacar.getTotalprice() + " > ");
        buttonGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick(null, v, position, 0);
			}
		});

        return rowView;
	}

}
