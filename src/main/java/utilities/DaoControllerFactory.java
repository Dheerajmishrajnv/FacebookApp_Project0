package utilities;

import dao.DaoImplementation;
import dao.daointerface;

public class DaoControllerFactory {

	public static daointerface daoObject() {
	
		return new DaoImplementation();
	}

}
