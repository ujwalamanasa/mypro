package com.epam.autoparing.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.epam.autoparking.main.ParkingLauncher;

import junit.framework.TestCase;

public class TestMain extends TestCase {
public void test() {
	String inputCase1 = "manasa\n3313\n3\nParking\nAS12AS1234\nUnParking\nAS12AS1234\nexit\nmanasa\n3313";
	InputStream inputObject = new ByteArrayInputStream(inputCase1.getBytes());
	System.setIn(inputObject );
	ParkingLauncher launcherObject = new ParkingLauncher();
	launcherObject.main(null);
	
}
}
