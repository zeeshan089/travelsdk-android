package com.travelfed.travelsdk.bean.hotel;

import java.util.Arrays;

public class HotelFilterParameters implements BoardTypes {

	private float minPrice = -1;
	private float maxPrice = -1;
	private int minStars = -1;
	private int maxStars = -1;
	private String[] roomTypes;
	private String[] boardTypes;
	private String hotelName;
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

	public int getMinStars() {
		return minStars;
	}

	public void setMinStars(int minStars) {
		this.minStars = minStars;
	}

	public int getMaxStars() {
		return maxStars;
	}

	public void setMaxStars(int maxStars) {
		this.maxStars = maxStars;
	}

	public String[] getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(String[] roomTypes) {
		this.roomTypes = roomTypes;
	}

	public String[] getBoardTypes() {
		return boardTypes;
	}

	public void setBoardTypes(String[] boardTypes) {
		this.boardTypes = boardTypes;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + HotelFilterParameters.hashCode(boardTypes);
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + Float.floatToIntBits(maxPrice);
		result = prime * result + maxStars;
		result = prime * result + Float.floatToIntBits(minPrice);
		result = prime * result + minStars;
		result = prime * result + HotelFilterParameters.hashCode(roomTypes);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelFilterParameters other = (HotelFilterParameters) obj;
		if (!Arrays.equals(boardTypes, other.boardTypes))
			return false;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (Float.floatToIntBits(maxPrice) != Float.floatToIntBits(other.maxPrice))
			return false;
		if (maxStars != other.maxStars)
			return false;
		if (Float.floatToIntBits(minPrice) != Float.floatToIntBits(other.minPrice))
			return false;
		if (minStars != other.minStars)
			return false;
		if (!Arrays.equals(roomTypes, other.roomTypes))
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
