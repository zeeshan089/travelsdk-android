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
 * Use to set number of adults and children in a room for a hotel search.
 * Default number of adults is 1.
 */
public class RoomPersons {

	private short numberOfAdults = 1;
	private int[] childrenAges = new int[0];

	public short getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(short numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int[] getChildrenAges() {
		return childrenAges;
	}

	public void setChildrenAges(int[] childrenAges) {
		this.childrenAges = childrenAges;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + RoomPersons.hashCode(childrenAges);
		result = prime * result + numberOfAdults;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomPersons other = (RoomPersons) obj;
		if (!Arrays.equals(childrenAges, other.childrenAges))
			return false;
		if (numberOfAdults != other.numberOfAdults)
			return false;
		return true;
	}

	private static int hashCode(int[] array) {
		int prime = 31;
		if (array == null)
			return 0;
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = prime * result + array[index];
		}
		return result;
	}

}
