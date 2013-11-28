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
package com.travelfed.travelsdk.bean.hotel;

import java.util.Arrays;

/**
 *  Filter parameters for a hotel search.
 *  Documentation: http://wiki.travelsdk.com/index.php?title=Hotel_requests#Result_Filters
 */
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
	 *  Minimum price.
	 */
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	/**
	 *  Maximum price.
	 */
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinStars() {
		return minStars;
	}

	/**
	 *  Minimum stars.
	 */
	public void setMinStars(int minStars) {
		this.minStars = minStars;
	}

	public int getMaxStars() {
		return maxStars;
	}

	/**
	 *  Maximim stars.
	 */
	public void setMaxStars(int maxStars) {
		this.maxStars = maxStars;
	}

	public String[] getRoomTypes() {
		return roomTypes;
	}

	/**
	 *  Filter by room types.
	 */
	public void setRoomTypes(String[] roomTypes) {
		this.roomTypes = roomTypes;
	}

	public String[] getBoardTypes() {
		return boardTypes;
	}

	/**
	 *  Filter by board types.
	 */
	public void setBoardTypes(String[] boardTypes) {
		this.boardTypes = boardTypes;
	}

	public String getHotelName() {
		return hotelName;
	}

	/**
	 *  Filter by hotel name.
	 */
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
