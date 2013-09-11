package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.excursion.Excursion;

public abstract class ProcessExcursionVerify extends ProcessVerify {

	private Excursion excursion;
	
	public ProcessExcursionVerify(Excursion excursion) {
		this.excursion = excursion;
	}

	public Excursion getExcursion() {
		return excursion;
	}

	public void setExcursion(Excursion excursion) {
		this.excursion = excursion;
	}

}
