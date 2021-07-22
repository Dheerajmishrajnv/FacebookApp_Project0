package dao;

import java.util.ArrayList;

import entity.FacebookUserData;

public interface daointerface {
	public int createProfile(FacebookUserData fc);

	public FacebookUserData view(FacebookUserData fc);

	public ArrayList<FacebookUserData> viewAll();

	public int editProfile(FacebookUserData fc) throws Exception;

	public boolean loginProfile(FacebookUserData fc);

	public int deleteprofile(FacebookUserData fc);

	public FacebookUserData viewToEdit(FacebookUserData fc_old);
}
