/*
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License");  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * http//www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * The Original Code is st-core-framework.
 *
 * The Initial Developer of the Original Code is University of Roma Tor Vergata.
 * Portions created by University of Roma Tor Vergata are Copyright (C) 2012.
 * All Rights Reserved.
 *
 * st-core-framework was developed by the Artificial Intelligence Research Group
 * (ai-nlp.info.uniroma2.it) at the University of Roma Tor Vergata
 * Current information about st-core-framework can be obtained at 
 * http//ai-nlp.info.uniroma2.it/software/...
 *
 */

/*
 * Contributor(s): Armando Stellato stellato@info.uniroma2.it
 */
package org.fao.aoscs.model.semanticturkey.util;

import it.uniroma2.art.owlart.exceptions.ModelAccessException;
import it.uniroma2.art.owlart.model.ARTBNode;
import it.uniroma2.art.owlart.model.ARTLiteral;
import it.uniroma2.art.owlart.model.ARTNode;
import it.uniroma2.art.owlart.model.ARTResource;
import it.uniroma2.art.owlart.model.ARTURIResource;
import it.uniroma2.art.owlart.models.RDFModel;
import it.uniroma2.art.owlart.utilities.ModelUtilities;
import it.uniroma2.art.owlart.utilities.RDFRenderer;
import it.uniroma2.art.owlart.vocabulary.RDFResourceRolesEnum;
import it.uniroma2.art.owlart.vocabulary.RDFTypesEnum;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;

public class STNodeFactory {

	public static STLiteral createSTRDFLiteral(ARTLiteral node, boolean explicit) {
		return new STLiteralImpl(node, explicit, null);
	}

	public static STLiteral createSTRDFLiteral(ARTLiteral node, boolean explicit, String show) {
		return new STLiteralImpl(node, explicit, show);
	}

	public static STLiteral createSTRDFLiteral(ARTLiteral node, boolean explicit, String show,
			String dtQName) {
		return new STLiteralImpl(node, explicit, show, dtQName);
	}

	public static STURIImpl createSTRDFURI(ARTURIResource node, RDFResourceRolesEnum role,
			boolean explicit, String show) {
		return new STURIImpl(node, role, explicit, show);
	}

	public static STURIImpl createSTRDFURI(ARTURIResource node, boolean explicit) {
		return new STURIImpl(node, null, explicit, null);
	}

	public static STBNodeImpl createSTRDFBNode(ARTBNode node, RDFResourceRolesEnum role, boolean explicit,
			String show) {
		return new STBNodeImpl(node, role, explicit, show);
	}

	public static STBNodeImpl createSTRDFBNode(ARTBNode node, boolean explicit) {
		return new STBNodeImpl(node, null, explicit, null);
	}

	/**
	 * This method has nothing to do with an enhanced POJO which can be used to serialize RDF nodes and
	 * accompanying information.<br/>
	 * 
	 * It simply renders the description of a RDF node under a an appropriate POJO, and additional information
	 * that needs to be presented can be defined in the request. <br/>
	 * First, the nature ({@link RDFTypesEnum}) of the node is revealed, among:
	 * <ul>
	 * <li>uri</li>
	 * <li>bnode</li>
	 * <li>plainLiteral</li>
	 * <li>typedLiteral</li>
	 * </ul>
	 * then additional information, such as the node <em>role</em> ({@link RDFResourceRolesEnum}), can be
	 * optionally added<br/>
	 * an optional <code>rendering</code> argument enables for a rendered visualization of the node<br/>
	 * <br/>
	 * <em>Note: of the above options, only the <code>role</code> requires further retrieval operations. For this
	 * reason, it should be used with care, only when the nature of the resource is known to be variable and
	 * the user is interested in knowing it</em><br/>
	 * <br/>
	 * 
	 * 
	 * @param parent
	 *            the XML parent element the newly created description is attached to
	 * @param model
	 *            the model to be queried for describing the RDFNode
	 * @param node
	 *            the node which is being described
	 * @param role
	 *            when <code>true</code>, if the node is a resource, it tells the role of the resource (cls,
	 *            ontology, property...). see {@link RDFResourceRolesEnum}
	 * @param rendering
	 *            If true, it provides a human readable representation of the node
	 *            <ul>
	 *            <li>a <code>show</code> attribute representing the node</li>
	 *            <li>if the value is a typed literal, a <code>typeQName</code> attribute providing a qname
	 *            for the datatype</li>
	 *            </ul>
	 * @return
	 * @throws DOMException
	 * @throws ModelAccessException
	 */
	public static STNode createSTRDFNode(RDFModel model, ARTNode node, boolean role, boolean explicit,
			boolean rendering) throws DOMException, ModelAccessException {
		if (node.isResource()) {
			return createSTRDFResource(model, node.asResource(), role, explicit, rendering);
		} else {
			// literal
			ARTLiteral lit = node.asLiteral();
			STLiteral stLit = createSTRDFLiteral(lit, explicit);
			if (rendering) {
				ARTURIResource dt = lit.getDatatype();
				if (dt != null)
					stLit.setDatatypeQName(model.getQName(dt.getURI()));
			}

			return stLit;
		}
	}

	public static STResource createSTRDFResource(RDFModel model, ARTResource node, boolean role,
			boolean explicit, boolean rendering) throws DOMException, ModelAccessException {

		if (role)
			return createSTRDFResource(model, node, ModelUtilities.getResourceRole(node.asResource(), model),
					explicit, rendering);

		return createSTRDFResource(model, node, null, explicit, rendering);
	}

	public static STResource createSTRDFResource(RDFModel model, ARTResource node,
			RDFResourceRolesEnum role, boolean explicit, boolean rendering) throws DOMException,
			ModelAccessException {
		STResource stRes;
		if (node.isURIResource()) {
			// uri
			stRes = createSTRDFURI(node.asURIResource(), explicit);
			if (rendering)
				stRes.setRendering(RDFRenderer.renderRDFNode(model, node.asURIResource()));
		} else {
			// bnode
			stRes = createSTRDFBNode(node.asBNode(), explicit);
			if (rendering)
				stRes.setRendering(RDFRenderer.renderRDFNode(model, node.asBNode()));
		}

		if (role != null)
			stRes.setRole(role);

		return stRes;
	}

	public static Collection<STResource> createEmptyResourceCollection() {
		return new ArrayList<STResource>();
	}

	/*
	 * public static Collection<STRDFURIImpl> createSTRDFURICollection(RDFModel model, ARTURIResourceIterator
	 * it, RDFResourceRolesEnum role, boolean explicit) { Collection<STRDFURIImpl> uris = new
	 * ArrayList<STRDFURIImpl>(); while (it.streamOpen()) { uris.add(createSTRDFURI(it.getNext(), role,
	 * explicit)); } it.close(); return uris; }
	 * 
	 * public static STRDFURIImpl createSTRDFURICollection(RDFModel model, ARTURIResourceIterator it, boolean
	 * explicit) { return new STRDFURIImpl(node, null, explicit, null); }
	 * 
	 * public static void createSTRDFNodeCollection(RDFModel model, RDFIterator<? extends ARTNode> node,
	 * boolean role, boolean explicit, boolean rendering) {
	 * 
	 * }
	 */

}
