package com.epam.autoparking.service;

import java.util.HashMap;
import java.util.Queue;

import com.epam.autoparking.exception.SlotEmptyException;

/**
 * This class provides UnParking information.
 * 
 * @author Manasa_Maddali
 *
 */
public class UnParkingService {
	/**
	 * @param vehicle       is a HashMap.
	 * @param slotQueue     is a Queue.
	 * @param vehicleNumber is a String.
	 * @param slot          is a Integer.
	 * @return slotQueue is a Queue.
	 */
	public int unparking(HashMap<String, Integer> vehicle, String vehicleNumber, Queue<Integer> slotQueue)   {
		Integer slotNumber = 0;
		if(vehicle.size()>0) {
		slotNumber = vehicle.get(vehicleNumber);
		if (slotNumber != null) {
			WriteToLogFile writeLog = new WriteToLogFile();
			writeLog.writeToLogFile(vehicleNumber, slotNumber, "OutTime");
			vehicle.remove(vehicleNumber);
			slotQueue.add(slotNumber);
		} else {
			slotNumber = -1;
		}
		
	}
		else {
		
				try {
					throw new SlotEmptyException();
				} catch (SlotEmptyException e) {
					
					e.printStackTrace();
				}
		
		}
		return slotNumber;
	}
	
}
