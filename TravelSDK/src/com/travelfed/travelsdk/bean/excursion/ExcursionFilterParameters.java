package com.travelfed.travelsdk.bean.excursion;

import java.util.Arrays;

/**
 * Documentation <a
 * href="http://wiki.travelsdk.com/index.php?title=Excursion_requests#Result_Filters"
 * >http://wiki.travelsdk.com/index.php?title=Excursion_requests#Result_Filters</a>
 * 
 * 
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

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(String[] productTypes) {
		this.productTypes = productTypes;
	}

	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}

	public String[] getSuppliers() {
		return suppliers;
	}

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
