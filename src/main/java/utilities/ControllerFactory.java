package utilities;

import controller.FacebookController;
import controller.facebookcontrollerinterface;

// This class is used to create object of Controller via static method.
public class ControllerFactory {
	private ControllerFactory() {
	}

	public static facebookcontrollerinterface createObject() {
		FacebookController fc = new FacebookController();
		return fc;
	}
}
