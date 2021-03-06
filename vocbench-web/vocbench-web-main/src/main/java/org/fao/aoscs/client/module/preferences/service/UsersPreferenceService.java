package org.fao.aoscs.client.module.preferences.service;

import java.util.ArrayList;

import org.fao.aoscs.domain.InitializeUsersPreferenceData;
import org.fao.aoscs.domain.Users;
import org.fao.aoscs.domain.UsersLanguage;
import org.fao.aoscs.domain.UsersOntology;
import org.fao.aoscs.domain.UsersPreference;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("usersPreference")
public interface UsersPreferenceService extends RemoteService{
	
	InitializeUsersPreferenceData getInitData(int userID, int projectID);
	public Users getUser(int userID) throws Exception;
	public Users updateUsers(Users users , boolean isPasswordChange) throws Exception;
	public UsersPreference getUsersPreference(int userID) throws Exception;
	public UsersPreference getUsersPreference(int userID, int projectID) throws Exception;
	public UsersPreference addUsersPreference(UsersPreference UsersPreference) throws Exception;
	public UsersPreference updateUsersPreference(UsersPreference UsersPreference) throws Exception;
	
	
	public ArrayList<String[]> getUsersGroup(int userID) throws Exception;
	public ArrayList<String[]> getNonAssignedGroup(int userID) throws Exception;
	public ArrayList<String[]> getNonAssignedAndPendingGroup(int userID) throws Exception;
	public ArrayList<String[]> getNonAssignedAndPendingGroup(int userID, int projectID) throws Exception;
	public ArrayList<String[]> getPendingGroup(int userID, int projectID) throws Exception;
	public ArrayList<Users> getNonAssignedUsers(int ontologyID);
	public ArrayList<Users> getPendingUsers(int ontologyID);
	public ArrayList<UsersLanguage> getUsersLanguage(int userID) throws Exception;
	public ArrayList<String[]> getPendingLanguage(int userID) throws Exception;
	public ArrayList<String[]> getPendingLanguage(int userID, int projectID) throws Exception;
	public ArrayList<String[]> getPendingLanguage() throws Exception;
	public ArrayList<String> getNonAssignedLanguage(int userID) throws Exception;
	public ArrayList<String[]> getNonAssignedAndPendingLanguage(int userID) throws Exception;
	public ArrayList<String[]> getNonAssignedAndPendingLanguage(int userID, int projectID) throws Exception;
	public void addUsersLanguage(ArrayList<UsersLanguage> langlist) throws Exception;
	public void addUsersGroup(int userID, ArrayList<String> grouplist) throws Exception;
	public ArrayList<String[]> deleteUsersPendingLanguage(int userID, ArrayList<String> langlist) throws Exception;
	public ArrayList<UsersLanguage> deleteUsersLanguage(int userID, ArrayList<String> langlist) throws Exception;
	public ArrayList<String[]> deleteUsersGroups(int userID, ArrayList<String> list) throws Exception;
	
	public ArrayList<String[]> getUserOntology(int userID) throws Exception;
	public ArrayList<String[]> getPendingOntology(int userID) throws Exception;
	public ArrayList<String[]> getPendingOntology() throws Exception;
	public ArrayList<String[]> getNonAssignedOntology(int userID) throws Exception;
	public ArrayList<String[]> getNonAssignedAndPendingOntology(int userID) throws Exception;
	public void addUsersOntology(ArrayList<UsersOntology> userOntology) throws Exception;
	public ArrayList<String[]> deleteUsersPendingOntology(int userID, ArrayList<String> langlist) throws Exception;
	public ArrayList<String[]> deleteUsersOntology(int userID, ArrayList<String> list) throws Exception;
	
	public static class UserPreferenceServiceUtil{
		private static UsersPreferenceServiceAsync<?> instance;
		public static UsersPreferenceServiceAsync<?> getInstance()
		{
			if (instance == null) {
				instance = (UsersPreferenceServiceAsync<?>) GWT.create(UsersPreferenceService.class);
			}
			return instance;
		}
    }

}
