package com.epam.autoparing.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.epam.autoparking.main.Utility;

public class QueueUtilityTest {

	@Test
	public void test() {

		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		Utility utilityTestObject = new Utility();
		vehicle.put("AP12AP1231", 5);
		vehicle.put("AP12AP1232", 10);

		Queue<Integer> actualQueue = new LinkedList<Integer>();
		actualQueue.add(1);

		assertTrue(utilityTestObject.queueUtility(vehicle, slotQueue, 10));

	}

}
