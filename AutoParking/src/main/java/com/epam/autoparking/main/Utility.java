package com.epam.autoparking.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Utility {
	public boolean queueUtility(HashMap<String, Integer> vehicle, Queue<Integer> slotQueue, Integer maxValue) {
boolean is_utilized = false;
		for (int index = 1; index <= maxValue; index++) {
			if (vehicle.containsValue(index)) {
				
				continue;
			} else {
				is_utilized = true;
				slotQueue.add(index);
			}
		}
		return is_utilized;
		
	}

	public Integer findMaxValue(HashMap<String, Integer> vehicle) {
		Integer maxValue;
		Map.Entry<String, Integer> maxEntry = null;
		for (Map.Entry<String, Integer> entry : vehicle.entrySet()) {
			if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
				maxEntry = entry;
			}
		}
		maxValue = maxEntry.getValue();
		return maxValue;
	}

	
}
