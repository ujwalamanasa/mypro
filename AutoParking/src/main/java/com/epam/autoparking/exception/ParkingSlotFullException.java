package com.epam.autoparking.exception;

public class ParkingSlotFullException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "PARKING SLOT IS FULL";
	}
}
