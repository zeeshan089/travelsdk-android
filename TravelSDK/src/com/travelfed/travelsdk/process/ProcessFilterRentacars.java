package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.rentacar.RentacarFilterParameters;
import com.travelfed.travelsdk.bean.rentacar.RentacarsResult;

public abstract class ProcessFilterRentacars extends ProcessSearchRentacars {

	private RentacarsResult rentacarsResult;
	
	public ProcessFilterRentacars(RentacarsResult rentacarsResult, RentacarFilterParameters filterParameters) {
		super(null);
		this.setFilterParameters(filterParameters);
		this.rentacarsResult = rentacarsResult;
	}

	public RentacarsResult getRentacarsResult() {
		return rentacarsResult;
	}

	public void setRentacarsResult(RentacarsResult rentacarsResult) {
		this.rentacarsResult = rentacarsResult;
	}


}
