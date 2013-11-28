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

import java.util.Arrays;

/**
 * Filter parameters for excursion search.
 * Documentation: http://wiki.travelsdk.com/index.php?title=Excursion_requests#Result_Filters
 */
public class ExcursionFilterParameters {

	private float minPrice = -1;
	private float maxPrice = -1;
	private String name;
	private String[] productTypes;
	private String[] cities;
	private String[] suppliers;
	private int offset;


	public int getOffset() {
		return offset;
	}

	/**
	 *  Results offset used for pagination.
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public float getMinPrice() {
		return minPrice;
	}

	/**
	 *  Filter by min. price
	 */
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	/**
	 *  Filter by max. price
	 */
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getName() {
		return name;
	}

	/**
	 *  Filter by excursion name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String[] getProductTypes() {
		return productTypes;
	}

	/**
	 *  Filter by product type(s)
	 */
	public void setProductTypes(String[] productTypes) {
		this.productTypes = productTypes;
	}

	public String[] getCities() {
		return cities;
	}

	/**
	 *  Filter by city(es)
	 */
	public void setCities(String[] cities) {
		this.cities = cities;
	}

	public String[] getSuppliers() {
		return suppliers;
	}

	/**
	 *  Filter by supplier(s)
	 */
	public void setSuppliers(String[] suppliers) {
		this.suppliers = suppliers;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ExcursionFilterParameters.hashCode(cities);
		result = prime * result + Float.floatToIntBits(maxPrice);
		result = prime * result + Float.floatToIntBits(minPrice);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ExcursionFilterParameters.hashCode(productTypes);
		result = prime * result + ExcursionFilterParameters.hashCode(suppliers);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcursionFilterParameters other = (ExcursionFilterParameters) obj;
		if (!Arrays.equals(cities, other.cities))
			return false;
		if (Float.floatToIntBits(maxPrice) != Float.floatToIntBits(other.maxPrice))
			return false;
		if (Float.floatToIntBits(minPrice) != Float.floatToIntBits(other.minPrice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(productTypes, other.productTypes))
			return false;
		if (!Arrays.equals(suppliers, other.suppliers))
			return false;
		return true;
	}

	private static int hashCode(Object[] array) {
		int prime = 31;
		if (array == null)
			return 0;
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = prime * result + (array[index] == null ? 0 : array[index].hashCode());
		}
		return result;
	}

}
