package com.epam.autoparking.main;

import java.util.Scanner;

/**
 * This class is used to check credentials entered by the admin are valid or
 * not.
 *
 * @author Manasa_Maddali
 *
 */
public class AdminValidator {
	//Scanner scannerObject = new Scanner(System.in);

	/**
	 * If the credentials are valid returns true else returns false.
	 * 
	 * @param password
	 * @param userName
	 *
	 * @return login which is a boolean value.
	 */
	public boolean credentials(String userName, String password) {

		boolean login = false;
		if ("manasa".equalsIgnoreCase(userName) && "3313".equals(password)) {
			login = true;
		}
		return login;
	}
}
