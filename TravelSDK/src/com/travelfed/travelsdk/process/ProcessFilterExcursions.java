package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.excursion.ExcursionFilterParameters;
import com.travelfed.travelsdk.bean.excursion.ExcursionsResult;

public abstract class ProcessFilterExcursions extends ProcessSearchExcursions {

	private ExcursionsResult excursionResult;
	
	public ProcessFilterExcursions(ExcursionsResult excursionResult, ExcursionFilterParameters filterParameters) {
		super(null);
		setFilterParameters(filterParameters);
		this.excursionResult = excursionResult;
	}

	public ExcursionsResult getExcursionResult() {
		return excursionResult;
	}

	public void setExcursionResult(ExcursionsResult excursionResult) {
		this.excursionResult = excursionResult;
	}

}
