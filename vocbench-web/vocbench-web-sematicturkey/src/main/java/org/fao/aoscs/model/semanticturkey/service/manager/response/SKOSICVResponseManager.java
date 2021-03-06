package org.fao.aoscs.model.semanticturkey.service.manager.response;

import it.uniroma2.art.semanticturkey.servlet.Response;
import it.uniroma2.art.semanticturkey.servlet.XMLResponseREPLY;

import org.fao.aoscs.domain.OntologyInfo;
import org.fao.aoscs.model.semanticturkey.util.STModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rajbhandari
 *
 */
public class SKOSICVResponseManager extends ResponseManager {
	
	protected static Logger logger = LoggerFactory.getLogger(SKOSICVResponseManager.class);
	
	public static XMLResponseREPLY listDanglingConceptsRequest(OntologyInfo ontoInfo, String limit)
	{
		
		Response resp = getSTModel(ontoInfo).icvService.makeNewRequest("listDanglingConcepts", 
				STModel.par("limit", limit),
				STModel.par("ctx_project", ontoInfo.getDbTableName()));
		return getXMLResponseREPLY(resp);
	}
	
}
