package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.excursion.ExcursionFilterParameters;
import com.travelfed.travelsdk.bean.excursion.ExcursionsResult;
import com.travelfed.travelsdk.bean.excursion.ExcursionSearchParameters;

/**
 * Process excursions search. Documentation <a
 * href="http://wiki.travelsdk.com/index.php?title=Excursion_requests"
 * >http://wiki.travelsdk.com/index.php?title=Excursion_requests</a>
 * 
 * @author krumstoilov
 * 
 */
public abstract class ProcessSearchExcursions extends ProcessWS<ExcursionsResult> {

	private ExcursionSearchParameters searchParameters;
	private ExcursionFilterParameters filterParameters;

	public ProcessSearchExcursions(ExcursionSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	public ExcursionSearchParameters getSearchParameters() {
		return searchParameters;
	}

	public void setSearchParameters(ExcursionSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	public ExcursionFilterParameters getFilterParameters() {
		return filterParameters;
	}

	public void setFilterParameters(ExcursionFilterParameters filterParameters) {
		this.filterParameters = filterParameters;
	}

}
