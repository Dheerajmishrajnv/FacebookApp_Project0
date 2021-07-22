package dao;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.FacebookUserData;
// This class implements the daointerface. 
public class DaoImplementation implements daointerface {
	private BufferedReader br;
	//This method create the profile of user. 
	//Return - It will return the integer i.
	public int createProfile(FacebookUserData fc) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con
					.prepareStatement("Insert into facebook(name,passward,Email,Address) values(?,?,?,?)");
			ps.setString(1, fc.getName());
			ps.setString(2, fc.getPassword());
			ps.setString(3, fc.getEmail());
			ps.setString(4, fc.getAddress());
			i = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	// This method will show the view of a user.
	// Return - It will return the object of FacebookUser.
	public FacebookUserData view(FacebookUserData fc) {
		FacebookUserData fcResult = new FacebookUserData();
		fcResult = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con.prepareStatement("Select * from facebook where name = ?");
			ps.setString(1, fc.getName());
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.println("Here is your view");
				fcResult = new FacebookUserData();
				fcResult.setName(res.getString(2));
				fcResult.setEmail(res.getString(4));
				fcResult.setAddress(res.getString(5));
			} else {
				System.out.println("No match found");
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fcResult;
	}
	// This method will show the view for the edit.
	// Return - It will return the object of FacebookUser.
	public FacebookUserData viewToEdit(FacebookUserData fc) {
		FacebookUserData fcResult = new FacebookUserData();
		fcResult = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con.prepareStatement("Select * from facebook where name = ?");
			ps.setString(1, fc.getName());
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				System.out.println("Here is your view");
				fcResult = new FacebookUserData();
				fcResult.setName(res.getString(2));
				fcResult.setPassword(res.getString(3));
				fcResult.setEmail(res.getString(4));
				fcResult.setAddress(res.getString(5));
			} else {
				System.out.println("No match found");
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fcResult;
	}
	// This method will show the view of all the user.
	// Return - It will return ArrayList holding the object of FacebookUser.

	public ArrayList<FacebookUserData> viewAll() {
		ArrayList<FacebookUserData> store = new ArrayList<FacebookUserData>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con.prepareStatement("Select * from facebook");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				FacebookUserData fcNew = new FacebookUserData();
				fcNew.setName(res.getString(2));
				fcNew.setPassword(res.getString(3));
				fcNew.setEmail(res.getString(4));
				fcNew.setAddress(res.getString(5));
				store.add(fcNew);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return store;

	}
	// This method will perform the login action.
	// Return - It will return the boolean value b.
	public boolean loginProfile(FacebookUserData fc) {
		FacebookUserData fcNew = new FacebookUserData();
		boolean b = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con.prepareStatement("Select * from facebook where Email=? and passward=?");
			ps.setString(1, fc.getEmail());
			ps.setString(2, fc.getPassword());
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	// This method will delete the user from database.
	// Return - It will return the integer i.
	public int deleteprofile(FacebookUserData fc) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con.prepareStatement("Delete from facebook where name = ?");
			ps.setString(1, fc.getName());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	// This method will edit the profile.
		// Return - It will return the integer i.
	public int editProfile(FacebookUserData fc) throws Exception {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db", "root",
					"Dheeraj@123");
			PreparedStatement ps = con
					.prepareStatement("update facebook set passward = ?,email=?,address=? where name = ?");
			ps.setString(1, fc.getPassword());
			ps.setString(2, fc.getEmail());
			ps.setString(3, fc.getAddress());
			ps.setString(4, fc.getName());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
