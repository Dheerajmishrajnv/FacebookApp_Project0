package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import controller.facebookcontrollerinterface;
import utilities.ControllerFactory;

// This is driver class.
public class FacebookView {
// This method is driver method.
	public static void main(String[] args) throws Exception {
		String s = "y";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (s.equals("y")) {
			System.out.println("**************MAIN MENU**********");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to edit profile");
			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to login profile");
			System.out.println("press 6 to viewAll");

			System.out.println("enter your choice");

			int c = Integer.parseInt(br.readLine());

			facebookcontrollerinterface fc = ControllerFactory.createObject();

			switch (c) {
			case 1:
				fc.createProfile();
				break;
			case 2:
				fc.viewProfile();
				break;
			case 3:
				fc.editProfile();
				break;
			case 4:
				fc.deleteProfile();
				break;

			case 5:
				fc.loginProfile();
				break;
			case 6:
				fc.viewAll();
				break;
			default:
				System.out.println("wrong choice");
			}

			System.out.println("To continue press your choice y/n");
			s = br.readLine();
		}

	}
}
