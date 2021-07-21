package utilities;

import controller.FacebookController;
import controller.facebookcontrollerinterface;

public class ControllerFactory {
	private ControllerFactory() {}
	
	public static facebookcontrollerinterface createObject() {
			FacebookController fc=new FacebookController();
		return fc;
	}
}
