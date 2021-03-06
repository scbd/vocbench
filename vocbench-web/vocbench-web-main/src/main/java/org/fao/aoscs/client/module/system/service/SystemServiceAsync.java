package org.fao.aoscs.client.module.system.service;

import java.util.ArrayList;
import java.util.HashMap;

import net.sf.gilead.pojo.gwt.LightEntity;

import org.fao.aoscs.domain.ConfigObject;
import org.fao.aoscs.domain.DBMigrationObject;
import org.fao.aoscs.domain.InitializeSystemData;
import org.fao.aoscs.domain.LanguageCode;
import org.fao.aoscs.domain.LanguageInterface;
import org.fao.aoscs.domain.OntologyInfo;
import org.fao.aoscs.domain.OwlAction;
import org.fao.aoscs.domain.OwlStatus;
import org.fao.aoscs.domain.PermissionFunctionalityMap;
import org.fao.aoscs.domain.PermissionObject;
import org.fao.aoscs.domain.StInstances;
import org.fao.aoscs.domain.UserLogin;
import org.fao.aoscs.domain.Users;
import org.fao.aoscs.domain.UsersGroups;
import org.fao.aoscs.domain.VBInitConstants;
import org.fao.aoscs.domain.ValidationFilter;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SystemServiceAsync<T> {
	void initData(UserLogin userLoginObj, AsyncCallback<InitializeSystemData> callback);
	void getAuthorize(String loginuser,String loginpassword, AsyncCallback<UserLogin> callback);
	void getAuthorization(String name, UserLogin  userLoginObj, AsyncCallback<UserLogin> callback);
	void setSessionValue(String name, LightEntity obj, AsyncCallback<Boolean> callback);
	void getAllUser(AsyncCallback<ArrayList<Users>> callback);
	void isUserExist(String username, AsyncCallback<Boolean> callback);
	void getInterfaceLang(AsyncCallback<ArrayList<LanguageInterface>> callback);
	void getUserGroup(int userid, AsyncCallback<ArrayList<UsersGroups>> callback);
	void getEncriptText(String password, AsyncCallback<String> callback);
	void checkSession(String name, AsyncCallback<UserLogin> callback);
	void clearSession(AsyncCallback<Void> callback);
	void SendMail(String to, String subject,String body,AsyncCallback<Void> callback);
	void getUserSelectedLanguageCode(int userID, int projectID,
			AsyncCallback<ArrayList<String>> callback);
	void getCountryCodes(AsyncCallback<ArrayList<String[]>> callback);
	void addLanguage(LanguageCode languageCode, AsyncCallback<ArrayList<LanguageCode>> callback);
	void editLanguage(LanguageCode languageCode, AsyncCallback<ArrayList<LanguageCode>> callback);
	void deleteLanguage(LanguageCode languageCode, AsyncCallback<ArrayList<LanguageCode>> callback);
	void updateLanguages(ArrayList<LanguageCode> languageCodes, AsyncCallback<ArrayList<LanguageCode>> callback);
	void registerUser(Users user, ArrayList<String> userGroups, ArrayList<String> userLangs, ArrayList<String> userOntology, AsyncCallback<Integer> callback);
	void addUser(Users user, AsyncCallback<Integer> callback);
	void updateUserData(Users user, AsyncCallback<Void> callback);
	void createGroup(String name , String description, int userId, AsyncCallback<Void> callback);
	void editGroup(int groupId, String name , String description, String oldDescription, int userId, AsyncCallback<Void> callback);
	void deleteGroup(int groupId, String name, String description, int userId, AsyncCallback<Void> callback);
	void addGroupPermission(int groupId, int permitId, String groupName, String permitName, int userId, AsyncCallback<Void> callback);
	void removeGroupPermission(int groupId, int permitId, String groupName, String permitName, int userId, AsyncCallback<Void> callback);
	void addGroupsToUser(String userId, ArrayList<String> groupIds, AsyncCallback<Void> callback);
	void addGroupsToUser(String userId, String projectId, ArrayList<String> groupIds, AsyncCallback<Void> callback);
	void addLanguagesToUser(String userId, ArrayList<String> languages, AsyncCallback<Void> callback);
	void addOntologiesToUser(String userId, ArrayList<String> ontologyIds, AsyncCallback<Void> callback);
	void addUserToGroup(int groupId, int userId, String groupName, String userName, int modifierId, AsyncCallback<Void> callback);
	void removeUserFromGroup(int groupId, ArrayList<Integer> selectedUsers, String groupName, String userName, int modifierId, AsyncCallback<Void> callback);
	//void addActionToGroup(int groupId, int actionId, String groupName, String action, int modifierId, AsyncCallback<Void> callback);
	void addActionToGroup(ArrayList<PermissionFunctionalityMap> map, PermissionFunctionalityMap pfm, AsyncCallback<Void> callback);
	void getSelectedGroupActionStatusID(String groupId, String actionId, AsyncCallback<Integer> callback);
	void removeActionStatusFromGroup(String groupId, String actionId, String statusId, AsyncCallback<Void> callback);
	void removeActionsFromGroup(int groupId, ArrayList<Integer> selectedActions, AsyncCallback<Void> callback);
	void removeActionFromGroup(String groupId, String actionId, String statusId, AsyncCallback<Void> callback);
	void getUnassignedActions(String groupId, AsyncCallback<ArrayList<OwlAction>> callback);
	void getUnassignedActionStatus(String groupId, String actionId, AsyncCallback<ArrayList<OwlStatus>> callback);
	void saveFilterPreferences(ValidationFilter vFilter, AsyncCallback<Void> callback);
	void getHelpURL(AsyncCallback<HashMap<String, String>> callback);
	void loadVBInitConstants(AsyncCallback<VBInitConstants> callback);
	void loadConfigConstants(
			AsyncCallback<HashMap<String, ConfigObject>> callback);
	void updateConfigConstants(HashMap<String, ConfigObject> configObjectMap,
			AsyncCallback<Void> callback);
	void getConfigConstants(String filename,
			AsyncCallback<HashMap<String, ConfigObject>> callback);
	void addOntology(String userid, OntologyInfo ontoInfo,
			AsyncCallback<OntologyInfo> callback);
	void deleteOntology(String userid, int ontologyId, AsyncCallback<ArrayList<OntologyInfo>> callback);
	void getOntology(String userid,
			AsyncCallback<ArrayList<OntologyInfo>> callback);
	void manageOntologyIndexing(boolean isIndexing, OntologyInfo ontoInfo, AsyncCallback<OntologyInfo> callback);
	
	void checkDBConnection(AsyncCallback<Boolean> callback);
	void getDBMigrationList(AsyncCallback<ArrayList<DBMigrationObject>> callback);
	void runDBMigration(String initVersion, AsyncCallback<ArrayList<DBMigrationObject>> callback);
	
	void listSTServer(OntologyInfo ontoInfo,
			AsyncCallback<ArrayList<StInstances>> callback);

	void addSTServer(OntologyInfo ontoInfo, StInstances stInstances,
			AsyncCallback<Boolean> callback);

	void deleteSTServer(OntologyInfo ontoInfo, StInstances stInstances,
			AsyncCallback<Boolean> callback);
	void getOntology(AsyncCallback<ArrayList<OntologyInfo>> callback);
	void addUsersToOntology(String ontologyId, ArrayList<String> users,
			AsyncCallback<Void> callback);
	void getUserAssignedtoOntology(String ontologyId,
			AsyncCallback<ArrayList<String[]>> callback);
	void getOntologyList(
			AsyncCallback<ArrayList<OntologyInfo>> callback);
	void deleteUsersFromOntology(String ontologyId, String userId,
			AsyncCallback<Void> callback);
	void getUser(String userId, AsyncCallback<Users> callback);
	void addLanguagesToUser(String userId, String projectId,
			ArrayList<String> languages, AsyncCallback<Void> callback);
	void getUserGroup(int userid, int projectid,
			AsyncCallback<ArrayList<UsersGroups>> callback);
	void SendMail(String to, String cc, String subject, String body,
			AsyncCallback<Void> callback);
	void getPermisions(String groupId, AsyncCallback<PermissionObject> callback);
	void getOntologyList(int userId,
			AsyncCallback<ArrayList<OntologyInfo>> callback);
	
}