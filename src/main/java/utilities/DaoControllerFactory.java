package utilities;

import dao.DaoImplementation;
import dao.daointerface;

// This class is used to create object of DAO via static method.
public class DaoControllerFactory {

	public static daointerface daoObject() {

		return new DaoImplementation();
	}

}
