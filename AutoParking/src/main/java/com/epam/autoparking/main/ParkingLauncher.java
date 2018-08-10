package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.epam.autoparking.exception.*;
import com.epam.autoparking.service.*;

/**
 * ParkingLauncher displays all the operations to be performed.
 *
 * @author Manasa_Maddali
 *
 */
public class ParkingLauncher {

	/**
	 * This is a main method.
	 * 
	 * @param args are command line arguments.
	 */
	@SuppressWarnings("resource")
	public static void main(final String[] args) {
		HashMap<String, Integer> vehicle = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		Scanner scannerObject = new Scanner(System.in);
		Integer maxValue = null;
		AdminValidator adminValidator = new AdminValidator();
		
		Integer totalSlots = 0;
		int slot = 0;
		//System.out.printf("\nEnter username: ");
		String userName = args[0];
		//System.out.printf("\nEnter Password: ");
		String password = args[1];
		String argument = args[2];
		if(argument.equals("1")) {
			//System.out.println("Enter total number of slots");
			 totalSlots = Integer.parseInt(args[3]);
			 boolean is_valid = adminValidator.credentials(userName, password);
				try {
			 FileWriter slotFileObject = new FileWriter("slotfile.csv");
			
				slotFileObject.write(totalSlots.toString());
				System.out.println(totalSlots);
				slotFileObject.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
			//File fileObject = new File("Transaction.csv");
		else if (argument.equals("0")) {

			try {
				FileReader readerObject = new FileReader("slotfile.csv");
				totalSlots = readerObject.read();
				//System.out.println(totalSlots);
				readerObject.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					File fileObject = new File("Transaction.csv");
					if(fileObject.exists()) {
					BufferedReader br;
					br = new BufferedReader(new FileReader("Transaction.csv"));
					if (br.readLine() != null) {
						FileToHashMap readFile = new FileToHashMap();
						vehicle = readFile.copyFileToHashMap();
						Utility utilityObject = new Utility();
						maxValue = utilityObject.findMaxValue(vehicle);
						utilityObject.queueUtility(vehicle, slotQueue, maxValue);
						slot = maxValue;
					}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}

			String vehicleNumber;
			boolean flag = true;
			Integer slotNumber = null;
			
			VehicleNumberValidator valid = new VehicleNumberValidator();
			boolean is_valid = adminValidator.credentials(userName, password);
			if (is_valid) {
			while (flag) {
				System.out.printf("\n  Parking\n  UnParking\n  Exit");
				String userChoice = scannerObject.next();

				switch (userChoice) {
				case "Parking":
					System.out.printf("\nenter vehicle number: ");
					vehicleNumber = scannerObject.next();

					boolean is_vehicleValid = valid.validateNumber(vehicleNumber);
					if (slot > totalSlots) {

						throw new ParkingSlotFullException();

					}

					if (is_vehicleValid) {

						ParkingService park = new ParkingService();
						if (slotQueue.isEmpty()) {
							slot++;
						}
						slotNumber = park.vehicleparking(vehicle, slotQueue, vehicleNumber, slot);

						WriteToTransactionFile wf1 = new WriteToTransactionFile();
						wf1.writeToTranscationFile(vehicle);
						System.out.printf("\nYour slotNumber: " + slotNumber);
					} else {
						System.out.println("Enter valid vehicle number");
					}
					break;
				case "UnParking":
					System.out.printf("\nenter vehicle number: ");
					vehicleNumber = scannerObject.next();
					is_vehicleValid = valid.validateNumber(vehicleNumber);
					if (is_vehicleValid) {
						UnParkingService unpark = new UnParkingService();
						
							
								slotNumber = unpark.unparking(vehicle, vehicleNumber, slotQueue);
							
						

						if (slotNumber != -1) {
							WriteToTransactionFile wf = new WriteToTransactionFile();
							wf.writeToTranscationFile(vehicle);
							System.out.printf("\nYour slotNumber: " + slotNumber);
							System.out.printf("\nUnparking sucess");
						} else {
							try {
								throw new VehicleNotFoundException();
							} catch (VehicleNotFoundException e) {
								System.out.printf("\nYour vehicle is not parked here");
							}

						}
					}

					break;

				case "exit":
					is_valid = adminValidator.credentials(userName, password);
					if (is_valid) {

						flag = false;
					}
					break;
				default:
					break;
				}
			}
		} else

		{
			System.out.printf("\nInvalid username or password");
		}
		scannerObject.close();
	}

}
