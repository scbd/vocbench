package org.fao.aoscs.client.module.concept.widgetlib;

import org.fao.aoscs.client.locale.LocaleConstants;
import org.fao.aoscs.client.utility.Convert;
import org.fao.aoscs.client.widgetlib.shared.panel.Spacer;
import org.fao.aoscs.domain.ConceptDetailObject;
import org.fao.aoscs.domain.InitializeConceptData;
import org.fao.aoscs.domain.PermissionObject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ConceptDetailTabPanel extends Composite{
	
	private LocaleConstants constants = (LocaleConstants) GWT.create(LocaleConstants.class);
	
	public HorizontalPanel topBar = new HorizontalPanel();
	public HorizontalPanel selectedConceptPanel;	
	public CheckBox showInferredAndExplicit = new CheckBox();
	public HTML showInferredAndExplicitHTML= new HTML("&nbsp;"+constants.conceptShowInferredAndExplicit());
	public DecoratedTabPanel tabPanel ; 
	
	public ConceptInformation cInfo;
	public ConceptImage cImage ;
	public ConceptDefinition cDef ;
	public ConceptRelationship cRel ;
	public ConceptProperty cNote;
	public ConceptProperty cAttrib;
	public ConceptProperty cNotation;
	public ConceptSchemes cScheme;
	public ConceptHierarchy cHier;
	public Term t ;
	
	public  void sayLoading(){
		t.sayLoading();
		cInfo.sayLoading();
		cImage.sayLoading();
		cDef.sayLoading();
		cRel.sayLoading();
		cNote.sayLoading();
		cAttrib.sayLoading();
		cNotation.sayLoading();
		cScheme.sayLoading();
		cHier.sayLoading();
	}
	
	public void setSetSelectedTab(int index){
		tabPanel.selectTab(index);
	}
	
	public void reload(){
		t.reload();
		cInfo.reload();
		cImage.reload();
		cDef.reload();
		cRel.reload();
		cNote.reload();
		cAttrib.reload();
		cNotation.reload();
		cScheme.reload();
		cHier.reload();
	}
	
	public ConceptDetailTabPanel(PermissionObject permisstionTable,InitializeConceptData initData){

		selectedConceptPanel = new HorizontalPanel();		
		selectedConceptPanel.setWidth("100%");
		selectedConceptPanel.setSpacing(2);
		
		tabPanel = new DecoratedTabPanel();
		tabPanel.setAnimationEnabled(true);
		tabPanel.setSize("99%", "100%");
		tabPanel.getDeckPanel().setHeight("100%");
		
		cInfo = new ConceptInformation(permisstionTable,initData, this, null);
		cImage = new ConceptImage(permisstionTable,initData, this, null);
		cDef = new ConceptDefinition(permisstionTable,initData, this, null);
		cRel = new ConceptRelationship(permisstionTable,initData, this, null);
		cNote = new ConceptProperty(ConceptProperty.CONCEPTNOTE, permisstionTable, initData, this, null);
		cAttrib = new ConceptProperty(ConceptProperty.CONCEPTATTRIBUTE, permisstionTable, initData, this, null);
		cNotation = new ConceptProperty(ConceptProperty.CONCEPTNOTATION, permisstionTable, initData, this, null);
		cScheme = new ConceptSchemes(permisstionTable, initData, this, null);
		cHier = new ConceptHierarchy(permisstionTable, initData, this, null);
		t = new Term(permisstionTable,initData, this, null);

		tabPanel.add(t, Convert.replaceSpace(constants.conceptTerm()));
		tabPanel.add(cDef, Convert.replaceSpace(constants.conceptDefinition()));
		tabPanel.add(cNote, Convert.replaceSpace(constants.conceptNote()));
		tabPanel.add(cAttrib, Convert.replaceSpace(constants.conceptAttribute()));
		tabPanel.add(cNotation, Convert.replaceSpace(constants.conceptNotation()));
		tabPanel.add(cRel, Convert.replaceSpace(constants.conceptRelationship()));
		tabPanel.add(cInfo, Convert.replaceSpace(constants.conceptHistory()));
		tabPanel.add(cImage, Convert.replaceSpace(constants.conceptImage()));
		tabPanel.add(cScheme, Convert.replaceSpace(constants.conceptScheme()));
		tabPanel.add(cHier, Convert.replaceSpace(constants.conceptHierarchy()));
		
		tabPanel.addSelectionHandler(new SelectionHandler<Integer>()
		{

			public void onSelection(SelectionEvent<Integer> event) {
				switch(event.getSelectedItem())
				{
				case 0: //Term
					if(t.getConceptObject()!=null)
						t.initData();
					break;
				case 1: //Definition
					if(cDef.getConceptObject()!=null)
						cDef.initData();
					break;
				case 2: //Note
					if(cNote.getConceptObject()!=null)
						cNote.initData();
					break;
				case 3: //Attribute
					if(cAttrib.getConceptObject()!=null)
						cAttrib.initData();
					break;
				case 4: //Notation
					if(cNotation.getConceptObject()!=null)
						cNotation.initData();
					break;
				case 5://Relationship
					if(cRel.getConceptObject()!=null)
						cRel.initData();
					break;
				case 6://History
					if(cInfo.getConceptObject()!=null)
						cInfo.initData();
					break;
				case 7://Image
					if(cImage.getConceptObject()!=null)
						cImage.initData();
					break;
				case 8://Schemes
					if(cScheme.getConceptObject()!=null)
						cScheme.initData();
					break;
				case 9://Hierarchy
					if(cHier.getConceptObject()!=null)
						cHier.initData();
					break;
				default:
					if(t.getConceptObject()!=null)
						t.initData();
					break;
					
				}
			}
			
		});
		
		HorizontalPanel tabHP = new HorizontalPanel();
		tabHP.setSize("100%", "100%");
		tabHP.setSpacing(5);
		tabHP.add(tabPanel);
		tabHP.setCellHeight(tabPanel, "100%");
		
		topBar.setStyleName("showshort");
		topBar.setWidth("100%");
		
		topBar.add(selectedConceptPanel);					
		topBar.add(showInferredAndExplicit);
		topBar.add(showInferredAndExplicitHTML);
		topBar.add(new Spacer("10px", "100%"));
		
		topBar.setCellHorizontalAlignment(selectedConceptPanel, HasHorizontalAlignment.ALIGN_LEFT);
		topBar.setCellWidth(selectedConceptPanel, "100%");
		topBar.setCellHorizontalAlignment(showInferredAndExplicit, HasHorizontalAlignment.ALIGN_RIGHT);
		topBar.setCellVerticalAlignment(showInferredAndExplicit, HasVerticalAlignment.ALIGN_MIDDLE);
		topBar.setCellHorizontalAlignment(showInferredAndExplicitHTML, HasHorizontalAlignment.ALIGN_RIGHT);
		topBar.setCellVerticalAlignment(showInferredAndExplicitHTML, HasVerticalAlignment.ALIGN_MIDDLE);
		
		VerticalPanel panel = new VerticalPanel();		
		panel.add(topBar);					
		panel.add(tabHP);
		panel.setCellHeight(topBar, "18px");
		panel.setCellHeight(tabHP, "100%");
		panel.setCellWidth(tabHP, "100%");
		panel.setCellVerticalAlignment(tabHP, HasVerticalAlignment.ALIGN_TOP);
		panel.setSize("100%", "100%");		
		initWidget(panel);
	}
	
	public void resetTab()
	{
		//tabPanel.selectTab(InfoTab.tabSelect);
		tabPanel.getTabBar().setTabHTML(InfoTab.term, Convert.replaceSpace(constants.conceptTerm()));
		tabPanel.getTabBar().setTabHTML(InfoTab.definition, Convert.replaceSpace(constants.conceptDefinition()));
		tabPanel.getTabBar().setTabHTML(InfoTab.note, Convert.replaceSpace(constants.conceptNote()));
		tabPanel.getTabBar().setTabHTML(InfoTab.attribute, Convert.replaceSpace(constants.conceptAttribute()));
		tabPanel.getTabBar().setTabHTML(InfoTab.notation, Convert.replaceSpace(constants.conceptNotation()));
		tabPanel.getTabBar().setTabHTML(InfoTab.relationship, Convert.replaceSpace(constants.conceptRelationship()));
		tabPanel.getTabBar().setTabHTML(InfoTab.history, Convert.replaceSpace(constants.conceptHistory()));
		tabPanel.getTabBar().setTabHTML(InfoTab.image, Convert.replaceSpace(constants.conceptImage()));
		tabPanel.getTabBar().setTabHTML(InfoTab.scheme, Convert.replaceSpace(constants.conceptScheme()));
		tabPanel.getTabBar().setTabHTML(InfoTab.hierarchy, Convert.replaceSpace(constants.conceptHierarchy()));
	}
	
	public void initData(ConceptDetailObject cDetailObj){
		if(cDetailObj!=null)
		{
			t.setConceptObject(cDetailObj.getConceptObject());
			cDef.setConceptObject(cDetailObj.getConceptObject());
			cNote.setConceptObject(cDetailObj.getConceptObject());
			cAttrib.setConceptObject(cDetailObj.getConceptObject());
			cNotation.setConceptObject(cDetailObj.getConceptObject());
			cRel.setConceptObject(cDetailObj.getConceptObject());
			cInfo.setConceptObject(cDetailObj.getConceptObject());
			cImage.setConceptObject(cDetailObj.getConceptObject());
			cScheme.setConceptObject(cDetailObj.getConceptObject());
			cHier.setConceptObject(cDetailObj.getConceptObject());
			
			t.setConceptDetailObject(cDetailObj);
			cDef.setConceptDetailObject(cDetailObj);
			cNote.setConceptDetailObject(cDetailObj);
			cAttrib.setConceptDetailObject(cDetailObj);
			cNotation.setConceptDetailObject(cDetailObj);
			cRel.setConceptDetailObject(cDetailObj);
			cInfo.setConceptDetailObject(cDetailObj);
			cImage.setConceptDetailObject(cDetailObj);
			cScheme.setConceptDetailObject(cDetailObj);
			cHier.setConceptDetailObject(cDetailObj);
			
			//t.initData();
		}
		
	}
	
	public void loadTab(ConceptDetailObject cDetailObj)
	{
		tabPanel.selectTab(InfoTab.tabSelect);
		//tabPanel.getTabBar().setTabHTML(InfoTab.term, Convert.replaceSpace((cDetailObj.getTermCount())>1? constants.conceptTerms():constants.conceptTerm() ) +"&nbsp;("+(cDetailObj.getTermCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.definition, Convert.replaceSpace((cDetailObj.getDefinitionCount())>1? constants.conceptDefinitions():constants.conceptDefinition() ) +"&nbsp;("+(cDetailObj.getDefinitionCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.note, Convert.replaceSpace((cDetailObj.getNoteCount())>1? constants.conceptNotes():constants.conceptNote() ) +"&nbsp;("+(cDetailObj.getNoteCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.attribute, Convert.replaceSpace((cDetailObj.getAttributeCount())>1? constants.conceptAttributes():constants.conceptAttribute() ) +"&nbsp;("+(cDetailObj.getAttributeCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.notation, Convert.replaceSpace((cDetailObj.getNotationCount())>1? constants.conceptNotations():constants.conceptNotation() ) +"&nbsp;("+(cDetailObj.getNotationCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.relationship, Convert.replaceSpace((cDetailObj.getRelationCount())>1? constants.conceptRelationships():constants.conceptRelationship() ) +"&nbsp;("+(cDetailObj.getRelationCount())+")" );
		//tabPanel.getTabBar().setTabHTML(InfoTab.history, Convert.replaceSpace((cDetailObj.getHistoryCount())>1? constants.conceptHistory():constants.conceptHistory() ) +"&nbsp;("+(cDetailObj.getHistoryCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.image, Convert.replaceSpace((cDetailObj.getImageCount())>1? constants.conceptImages():constants.conceptImage() ) +"&nbsp;("+(cDetailObj.getImageCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.scheme, Convert.replaceSpace((cDetailObj.getSchemeCount())>1? constants.conceptSchemes():constants.conceptScheme() ) +"&nbsp;("+(cDetailObj.getSchemeCount())+")" );
		tabPanel.getTabBar().setTabHTML(InfoTab.hierarchy, Convert.replaceSpace(constants.conceptHierarchy()));
	}
	
	public void loadHistoryTab(int historyCount)
	{
		tabPanel.getTabBar().setTabHTML(InfoTab.history, Convert.replaceSpace((historyCount)>1? constants.conceptHistory():constants.conceptHistory() ) +"&nbsp;("+(historyCount)+")" );
	}
	
	public void clearData(){
		t.sayLoading();
		cDef.sayLoading();
		cNote.sayLoading();
		cAttrib.sayLoading();
		cNotation.sayLoading();
		cRel.sayLoading();
		cInfo.sayLoading();
		cImage.sayLoading();
		cScheme.sayLoading();
		cHier.sayLoading();
	}
}
