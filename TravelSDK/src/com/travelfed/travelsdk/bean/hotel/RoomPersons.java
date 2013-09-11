package com.travelfed.travelsdk.bean.hotel;

import java.util.Arrays;

/**
 * Use to store number of adults and children in a room.
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
