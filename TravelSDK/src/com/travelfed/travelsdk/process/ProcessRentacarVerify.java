package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.rentacar.Rentacar;

public abstract class ProcessRentacarVerify extends ProcessVerify {

	private Rentacar rentacar;
	
	public ProcessRentacarVerify(Rentacar rentacar) {
		this.rentacar = rentacar;
	}

	public Rentacar getRentacar() {
		return rentacar;
	}

	public void setRentacar(Rentacar rentacar) {
		this.rentacar = rentacar;
	}
	
	

}
