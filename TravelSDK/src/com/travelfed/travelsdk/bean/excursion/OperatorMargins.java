/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of the Perennial UG & Co.KG nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
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
package com.travelfed.travelsdk.bean.excursion;

import org.json.JSONException;
import org.json.JSONObject;

public class OperatorMargins {
	private String generalFee;
	private String globalMargin;
	private String globalFee;
	private String generalMargin;

	public OperatorMargins(JSONObject json) throws JSONException {
		if (json.has("generalFee")) {
			this.setGeneralFee(json.getString("generalFee"));
		}
		if (json.has("globalMargin")) {
			this.setGlobalMargin(json.getString("globalMargin"));
		}
		if (json.has("globalFee")) {
			this.setGlobalFee(json.getString("globalFee"));
		}
		if (json.has("generalMargin")) {
			this.setGeneralMargin(json.getString("generalMargin"));
		}
	}

	/** @param generalFee */
	public void setGeneralFee(String generalFee) {
		this.generalFee = generalFee;
	}

	/** @return generalFee */
	public String getGeneralFee() {
		return generalFee;
	}

	/** @param globalMargin */
	public void setGlobalMargin(String globalMargin) {
		this.globalMargin = globalMargin;
	}

	/** @return globalMargin */
	public String getGlobalMargin() {
		return globalMargin;
	}

	/** @param globalFee */
	public void setGlobalFee(String globalFee) {
		this.globalFee = globalFee;
	}

	/** @return globalFee */
	public String getGlobalFee() {
		return globalFee;
	}

	/** @param generalMargin */
	public void setGeneralMargin(String generalMargin) {
		this.generalMargin = generalMargin;
	}

	/** @return generalMargin */
	public String getGeneralMargin() {
		return generalMargin;
	}
}