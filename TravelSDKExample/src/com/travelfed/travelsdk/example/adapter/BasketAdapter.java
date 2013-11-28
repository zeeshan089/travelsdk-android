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
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.travelfed.travelsdk.basket.BasketItem;
import com.travelfed.travelsdk.basket.ExcursionBasketItem;
import com.travelfed.travelsdk.basket.FlightBasketItem;
import com.travelfed.travelsdk.basket.HotelBasketItem;
import com.travelfed.travelsdk.basket.RentacarBasketItem;
import com.travelfed.travelsdk.bean.excursion.Excursion;
import com.travelfed.travelsdk.bean.flight.FlightFare;
import com.travelfed.travelsdk.bean.flight.Segment;
import com.travelfed.travelsdk.bean.hotel.HotelFare;
import com.travelfed.travelsdk.bean.rentacar.Rentacar;
import com.travelfed.travelsdk.example.R;

/**
 * 
 * @author krumstoilov
 *
 */
public class BasketAdapter extends ArrayAdapter<BasketItem> {

	private View rowViewFlight;
	private View rowViewHotel;
	private View rowViewRentacar;
	private View rowViewExcursion;
	
	public BasketAdapter(Context context, BasketItem[] objects) {
		super(context, R.layout.list_item_flight_basket, objects);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		BasketItem item = getItem(position);
		if(item instanceof FlightBasketItem) {
			return getFlightView((FlightBasketItem) item);
		} else if(item instanceof HotelBasketItem) {
			return getHotelView((HotelBasketItem) item);
		} else if(item instanceof RentacarBasketItem) {
			return getRentacarView((RentacarBasketItem) item);
		} else if(item instanceof ExcursionBasketItem) {
			return getExcursionView((ExcursionBasketItem) item);
		} else {
			View rowView = convertView;
	        if (rowView == null) 
	        {
	            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
	            rowView = inflater.inflate(R.layout.list_item_flight_basket, null, true);
	        }
	        return rowView;
		}
	}
	
	private View getFlightView(FlightBasketItem flightBasketItem) {
        if (rowViewFlight == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowViewFlight = inflater.inflate(R.layout.list_item_flight_basket, null, true);
        } 
        
        FlightFare flightFare = flightBasketItem.getFlightFare();
        
        // Airline
        ((TextView) rowViewFlight.findViewById(R.id.flightItemAirline)).setText(flightFare.getCarrier().getDeclaration());
        
        // Departure
		List<Segment> outFlightSegments = flightFare.getFlights().get(0).getSegments();
		Segment segment = outFlightSegments.get(0);
		StringBuffer stringBuffer = new StringBuffer("Dep: ");
		stringBuffer.append(segment.getDeptime()).append(", Arrival: ");
		Segment arrivalSegment = outFlightSegments.get(outFlightSegments.size() - 1);
		stringBuffer.append(arrivalSegment.getArrtime());
		((TextView) rowViewFlight.findViewById(R.id.flightItemDeparture)).setText(stringBuffer.toString());
		
		// Return
		if (flightFare.isRoundTrip()) {
			List<Segment> inFlightSegments = flightFare.getFlights().get(1).getSegments();
			segment = inFlightSegments.get(0);
			stringBuffer = new StringBuffer("Return - Dep: ");
			stringBuffer.append(segment.getDeptime()).append(", Arrival: ");
			arrivalSegment = inFlightSegments.get(inFlightSegments.size() - 1);
			stringBuffer.append(arrivalSegment.getArrtime());
			((TextView) rowViewFlight.findViewById(R.id.flightItemReturn)).setText(stringBuffer.toString());
		} else {
			((TextView) rowViewFlight.findViewById(R.id.flightItemReturn)).setHeight(1);
		}

        // Total
        ((TextView) rowViewFlight.findViewById(R.id.flightItemTotal))
        .setText(flightFare.getCurrency() + " " + flightFare.getTotal());

        return rowViewFlight;
	}
	
	private View getHotelView(HotelBasketItem hotelBasketItem) {
        if (rowViewHotel == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowViewHotel = inflater.inflate(R.layout.list_item_hotel_basket, null, true);
        } 
        
        HotelFare hotelFare = hotelBasketItem.getHotelFare();
        
        // hotel name
        TextView textViewHotelName = (TextView) rowViewHotel.findViewById(R.id.hotelItemName);
        textViewHotelName.setText(hotelFare.getHotelName());
        
        // Short info
		StringBuffer stringBuffer = new StringBuffer("Category: ");
		stringBuffer.append(hotelFare.getHotelCategory());
		stringBuffer.append(", Board type: ").append(hotelFare.getBoardTypeDescription());
		((TextView) rowViewHotel.findViewById(R.id.hotelItemInfo)).setText(stringBuffer.toString());
		
        //  Total
        TextView textViewTotal = (TextView) rowViewHotel.findViewById(R.id.hotelItemTotal);
        textViewTotal.setText(hotelFare.getCurrency() + " " + hotelFare.getTotalPrice());

        return rowViewHotel;
	}
	

	private View getRentacarView(RentacarBasketItem rentacarBasketItem) {
        if (rowViewRentacar == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowViewRentacar = inflater.inflate(R.layout.list_item_rentacar_basket, null, true);
        } 
        
        Rentacar rentacar = rentacarBasketItem.getRentacar();
        
        // Model
        TextView textViewModel = (TextView) rowViewRentacar.findViewById(R.id.rentacarItemModel);
        textViewModel.setText(rentacar.getModelname());
        
        // Details
		StringBuffer stringBuffer = new StringBuffer("Class: ");
		stringBuffer.append(rentacar.getClassname());
		stringBuffer.append(", Doors: ").append(rentacar.getDoors());
		((TextView) rowViewRentacar.findViewById(R.id.rentacarItemDetails)).setText(stringBuffer.toString());
		
        //  Total
        TextView textViewTotal = (TextView) rowViewRentacar.findViewById(R.id.rentacarItemTotal);
        textViewTotal.setText(rentacar.getCurrency() + " " + rentacar.getTotalprice());

        return rowViewRentacar;
	}
	
	private View getExcursionView(ExcursionBasketItem excursionBasketItem) {
        if (rowViewExcursion == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowViewExcursion = inflater.inflate(R.layout.list_item_excursion_basket, null, true);
        } 
        
        Excursion excursion = excursionBasketItem.getExcursion();
        
        // Name
        TextView textViewName = (TextView) rowViewExcursion.findViewById(R.id.excursionItemName);
        textViewName.setText(excursion.getName());
        
        // Info
		StringBuffer stringBuffer = new StringBuffer("City: ");
		stringBuffer.append(excursion.getCity());
		stringBuffer.append(", Duration: ").append(excursion.getDuration());
		((TextView) rowViewExcursion.findViewById(R.id.excursionItemInfo)).setText(stringBuffer.toString());
	
        //  Total
        TextView textViewTotal = (TextView) rowViewExcursion.findViewById(R.id.excursionItemTotal);
        textViewTotal.setText(excursion.getCur() + " " + excursion.getTotalPrice());

        return rowViewExcursion;
	}
}
