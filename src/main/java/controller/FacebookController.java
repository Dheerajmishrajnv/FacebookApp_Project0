package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DaoImplementation;
import dao.daointerface;
import entity.FacebookUserData;
import utilities.DaoControllerFactory;

public class FacebookController implements facebookcontrollerinterface {

	private BufferedReader br;
	private FacebookUserData fc;
	private daointerface df;

	public FacebookController() {
		br = new BufferedReader(new InputStreamReader(System.in));
		df = DaoControllerFactory.daoObject();
	}

	public void createProfile() throws Exception {
		fc = new FacebookUserData();
		System.out.println("Enter the name");
		String name = br.readLine();
		fc.setName(name);
		System.out.println("Enter the password");
		String password = br.readLine();
		fc.setPassword(password);
		System.out.println("Enter the email");
		String email = br.readLine();
		fc.setEmail(email);
		System.out.println("Enter the Address");
		String address = br.readLine();
		fc.setAddress(address);
		int i = df.createProfile(fc);
		if (i > 0) {
			System.out.println("Profile created successfully");

		} else {
			System.out.println("Please enter the correct choice");
		}
	}

	public void viewProfile() throws Exception {
		fc = new FacebookUserData();
		System.out.println("Please enter the name ");
		String name = br.readLine();
		fc.setName(name);
		FacebookUserData viewObj = df.view(fc);
		if (viewObj != null) {
			System.out.println("Name : " + viewObj.getName());
			System.out.println("Email : " + viewObj.getEmail());
			System.out.println("Address : " + viewObj.getAddress());
		}
	}

	public void viewAll() {
		ArrayList<FacebookUserData> res = df.viewAll();
		for (FacebookUserData a : res) {
			System.out.println("******************************************");
			System.out.println("Name : " + a.getName());
			System.out.println("Name : " + a.getEmail());
			System.out.println("Name : " + a.getAddress());

		}
	}

	public void editProfile() throws Exception {
		FacebookUserData fc_old = new FacebookUserData();
		System.out.println("Enter the name to be edited");
		String name = br.readLine();
		fc_old.setName(name);
		FacebookUserData fc_data = df.viewToEdit(fc_old);
		if (fc_data != null) {
			System.out.println("Your old password is : " + fc_data.getPassword());
			System.out.println("Your old email is : " + fc_data.getEmail());
			System.out.println("Your old Address is : " + fc_data.getAddress());
			System.out.println("Enter the New password");
			String Newpassword = br.readLine();
			fc_old.setPassword(Newpassword);
			System.out.println("Enter the New email");
			String Newemail = br.readLine();
			fc_old.setEmail(Newemail);
			System.out.println("Enter the New Address");
			String Newaddress = br.readLine();
			fc_old.setAddress(Newaddress);
			int i = df.editProfile(fc_old);
			if (i > 0) {
				System.out.println("Profile edited successfully");
			} else {
				System.out.println("OOho! profile not edited");
			}
		} else {
			System.out.println("Profile not found");
		}
	}

	public void deleteProfile() throws Exception {
		FacebookUserData fc = new FacebookUserData();
		System.out.println("Enter name to be deleted");
		String a = br.readLine();
		fc.setName(a);
		int i = df.deletprofile(fc);
		if (i > 0) {
			System.out.println("The file deleted successfully");
		} else {
			System.out.println("Wrong input");
		}
	}

	public void loginProfile() throws Exception {
		fc = new FacebookUserData();
		System.out.println("Enter the email");
		String email = br.readLine();
		fc.setEmail(email);
		System.out.println("Enter the password");
		String password = br.readLine();
		fc.setPassword(password);
		boolean loginResult = df.loginProfile(fc);
		if (loginResult) {
			System.out.println("login successfully");
		} else {
			System.out.println("provide the correct input");
		}
	}

}
