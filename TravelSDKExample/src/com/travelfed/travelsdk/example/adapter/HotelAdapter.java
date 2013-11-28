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
