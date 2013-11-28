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

import com.travelfed.travelsdk.bean.flight.FlightFare;
import com.travelfed.travelsdk.bean.flight.Segment;
import com.travelfed.travelsdk.example.R;

/**
 * 
 * @author krumstoilov
 *
 */
public class FlightAdapter extends ArrayAdapter<FlightFare> {
	
	private AdapterView.OnItemClickListener onItemClickListener;
	
	public FlightAdapter(Context context, List<FlightFare> objects, AdapterView.OnItemClickListener onItemClickListener) {
		super(context, R.layout.list_item_flight, objects);
		this.onItemClickListener = onItemClickListener;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item_flight, null, true);
        } 
        
        FlightFare flightFare = getItem(position);
        
        // Airline
        ((TextView) rowView.findViewById(R.id.flightItemAirline)).setText(flightFare.getCarrier().getDeclaration());
        
        // Departure
		List<Segment> outFlightSegments = flightFare.getFlights().get(0).getSegments();
		Segment segment = outFlightSegments.get(0);
		StringBuffer stringBuffer = new StringBuffer("Dep: ");
		stringBuffer.append(segment.getDeptime()).append(", Arrival: ");
		Segment arrivalSegment = outFlightSegments.get(outFlightSegments.size() - 1);
		stringBuffer.append(arrivalSegment.getArrtime());
		((TextView) rowView.findViewById(R.id.flightItemDeparture)).setText(stringBuffer.toString());
		
		// Return
		if (flightFare.isRoundTrip()) {
			List<Segment> inFlightSegments = flightFare.getFlights().get(1).getSegments();
			segment = inFlightSegments.get(0);
			stringBuffer = new StringBuffer("Return - Dep: ");
			stringBuffer.append(segment.getDeptime()).append(", Arrival: ");
			arrivalSegment = inFlightSegments.get(inFlightSegments.size() - 1);
			stringBuffer.append(arrivalSegment.getArrtime());
			((TextView) rowView.findViewById(R.id.flightItemReturn)).setText(stringBuffer.toString());
		} else {
			((TextView) rowView.findViewById(R.id.flightItemReturn)).setHeight(1);
		}

        // Class and Total
        ((TextView) rowView.findViewById(R.id.flightItemInfo)).setText("Class: " +  flightFare.getCabinName());
        
        Button buttonGo = (Button) rowView.findViewById(R.id.flightItemButtonTotal);
        buttonGo.setText(flightFare.getCurrency() + " " + flightFare.getTotal() + " > ");
        buttonGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick(null, v, position, 0);
			}
		});

        return rowView;
	}


	
	

}
