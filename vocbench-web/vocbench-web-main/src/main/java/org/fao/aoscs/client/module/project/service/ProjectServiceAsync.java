package org.fao.aoscs.client.module.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.fao.aoscs.domain.OntologyConfigurationManager;
import org.fao.aoscs.domain.OntologyInfo;
import org.fao.aoscs.domain.PluginConfiguration;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author rajbhandari
 *
 */
public interface ProjectServiceAsync<T> {
	
	void initializeProject(OntologyInfo ontoInfo,
			AsyncCallback<String[]> callback);

	void createNewProject(OntologyInfo ontoInfo, String projectName,
			String baseuri, String ontomanager, String ontMgrConfiguration,
			String ontologyType, HashMap<String, String> cfgPars,
			String uriGeneratorFactoryID, String uriGenConfigurationClass,
			HashMap<String, String> uriGenConfiguration,
			AsyncCallback<Boolean> callback);

	void deleteProject(OntologyInfo ontoInfo, String projectName,
			AsyncCallback<Boolean> callback);

	void listTripleStores(OntologyInfo ontoInfo,
			AsyncCallback<ArrayList<String>> callback);

	void getOntManagerParameters(OntologyInfo ontoInfo, String ontMgrID,
			AsyncCallback<ArrayList<OntologyConfigurationManager>> callback);

	void isSTServerStarted(OntologyInfo ontoInfo,
			AsyncCallback<Boolean> callback);

	void getAvailablePlugins(OntologyInfo ontoInfo, String extensionPoint,
			AsyncCallback<ArrayList<String>> callback);

	void getPluginConfigurations(OntologyInfo ontoInfo, String factoryID,
			AsyncCallback<ArrayList<PluginConfiguration>> callback);

}
