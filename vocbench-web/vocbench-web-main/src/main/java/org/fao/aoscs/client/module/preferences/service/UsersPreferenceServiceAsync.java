package org.fao.aoscs.client.module.preferences.service;

import java.util.ArrayList;

import org.fao.aoscs.domain.InitializeUsersPreferenceData;
import org.fao.aoscs.domain.Users;
import org.fao.aoscs.domain.UsersLanguage;
import org.fao.aoscs.domain.UsersOntology;
import org.fao.aoscs.domain.UsersPreference;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UsersPreferenceServiceAsync<T> {
	
	void getInitData(int userID, int projectID,
			AsyncCallback<InitializeUsersPreferenceData> callback);
	public void getUser(int userID, AsyncCallback<Users> callback);
	public void updateUsers(Users users, boolean isPasswordChange, AsyncCallback<Users> callback);
	public void getUsersPreference(int userID, AsyncCallback<UsersPreference> callback);
	public void addUsersPreference(UsersPreference UsersPreference, AsyncCallback<UsersPreference> callback);
	public void updateUsersPreference(UsersPreference UsersPreference, AsyncCallback<UsersPreference> callback);
	
	void getNonAssignedAndPendingGroup(int userID, AsyncCallback<ArrayList<String[]>> callback);
	void getNonAssignedAndPendingGroup(int userID, int projectID, AsyncCallback<ArrayList<String[]>> callback);
	public void getNonAssignedUsers(int ontologyID, AsyncCallback<ArrayList<Users>> callback);
	
	public void getUsersLanguage(int userID, AsyncCallback<ArrayList<UsersLanguage>> callback);
	public void getPendingLanguage(int userID, AsyncCallback<ArrayList<String[]>> callback);
	public void getNonAssignedLanguage(int userID, AsyncCallback<ArrayList<String>> callback);
	public void getNonAssignedAndPendingLanguage(int userID, AsyncCallback<ArrayList<String[]>> callback);
	public void addUsersLanguage(ArrayList<UsersLanguage> langlist, AsyncCallback<Void> callback);
	public void deleteUsersPendingLanguage(int userID, ArrayList<String> langlist, AsyncCallback<ArrayList<String[]>> callback);
	public void deleteUsersLanguage(int userID, ArrayList<String> langlist, AsyncCallback<ArrayList<UsersLanguage>> callback);
	
	public void getUserOntology(int userID, AsyncCallback<ArrayList<String[]>> callback);
	public void getPendingOntology(int userID, AsyncCallback<ArrayList<String[]>> callback);
	public void getNonAssignedOntology(int userID, AsyncCallback<ArrayList<String[]>> callback);
	public void getNonAssignedAndPendingOntology(int userID, AsyncCallback<ArrayList<String[]>> callback);
	public void addUsersOntology(ArrayList<UsersOntology> userOntology, AsyncCallback<Void> callback);
	public void deleteUsersOntology(int userID, ArrayList<String> list, AsyncCallback<ArrayList<String[]>> callback);
	public void deleteUsersPendingOntology(int userID, ArrayList<String> langlist,
			AsyncCallback<ArrayList<String[]>> callback);
	void getPendingLanguage(AsyncCallback<ArrayList<String[]>> callback);
	void getPendingOntology(AsyncCallback<ArrayList<String[]>> callback);
	void getPendingGroup(int userID, int projectID,
			AsyncCallback<ArrayList<String[]>> callback);
	void getPendingLanguage(int userID, int projectID,
			AsyncCallback<ArrayList<String[]>> callback);
	void getNonAssignedAndPendingLanguage(int userID, int projectID,
			AsyncCallback<ArrayList<String[]>> callback);
	void getUsersPreference(int userID, int projectID,
			AsyncCallback<UsersPreference> callback);
	void getPendingUsers(int ontologyID,
			AsyncCallback<ArrayList<Users>> callback);
	void getUsersGroup(int userID, AsyncCallback<ArrayList<String[]>> callback);
	void deleteUsersGroups(int userID, ArrayList<String> list,
			AsyncCallback<ArrayList<String[]>> callback);
	void getNonAssignedGroup(int userID,
			AsyncCallback<ArrayList<String[]>> callback);
	void addUsersGroup(int userID, ArrayList<String> grouplist,
			AsyncCallback<Void> callback);
}
