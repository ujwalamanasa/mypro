package com.epam.autoparing.test;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.epam.autoparking.exception.SlotEmptyException;
import com.epam.autoparking.service.UnParkingService;

public class SlotEmptyExceptionTest {
@Test(expected = SlotEmptyException.class)
public void test() {
	UnParkingService unpark = new UnParkingService();
	HashMap<String, Integer> vehicles = new HashMap<String, Integer>();
	Queue<Integer> slotQueue = new LinkedList<Integer>();
	

		
			unpark.unparking(vehicles,"AP54UI6785", slotQueue);
}
}

