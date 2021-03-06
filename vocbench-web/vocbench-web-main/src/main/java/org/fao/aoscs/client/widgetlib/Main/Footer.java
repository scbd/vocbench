package org.fao.aoscs.client.widgetlib.Main;

import java.util.Date;

import org.fao.aoscs.client.Main;
import org.fao.aoscs.client.PartnersDialogBox;
import org.fao.aoscs.client.locale.LocaleConstants;
import org.fao.aoscs.client.module.constant.VBConstants;
import org.fao.aoscs.client.utility.HelpUtility;
import org.fao.aoscs.client.widgetlib.shared.label.LinkLabel;
import org.fao.aoscs.client.widgetlib.shared.panel.Spacer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Footer extends VerticalPanel {
    private static LocaleConstants constants = (LocaleConstants) GWT.create(LocaleConstants.class);
    private PartnersDialogBox partnersDialog;

    public Footer() {
    	super();

    	LinkLabel about = new LinkLabel("", null, constants.menuAbout());
    	about.setWidth("100%");
    	DOM.setStyleAttribute(about.getElement(), "color", "#FFF");
    	DOM.setStyleAttribute(about.getElement(), "paddingLeft", "20px");
    	about.addClickHandler(new ClickHandler() {
    		public void onClick(ClickEvent event) {
    			HelpUtility.openHelp("ABOUTAGROVOC");
    		}
    	});

    	LinkLabel webservices = new LinkLabel("", null, constants.menuWebServices());
    	webservices.setWidth("100%");
    	DOM.setStyleAttribute(webservices.getElement(), "color", "#FFF");
    	webservices.addClickHandler(new ClickHandler() {
    		public void onClick(ClickEvent event) {
    			Main.openURL(VBConstants.WEBSERVICESINFO , "_blank");
    		}
    	});

    	LinkLabel contactUs = new LinkLabel("", null, constants.footerContactUs());
    	DOM.setStyleAttribute(contactUs.getElement(), "color", "#FFF");
    	contactUs.addClickHandler(new ClickHandler() {
    		public void onClick(ClickEvent event) {

    		}
    	});

    	LinkLabel partners = new LinkLabel("", null, constants.footerPartners());
    	partners.setWidth("100%");
    	DOM.setStyleAttribute(partners.getElement(), "color", "#FFF");
    	partners.addClickHandler(new ClickHandler() {
    		public void onClick(ClickEvent event) {
    			if (partnersDialog == null || !partnersDialog.isLoaded){
    				partnersDialog = new PartnersDialogBox();
    				partnersDialog.setWidth("150px");
    			}
    			partnersDialog.show();
    		}
    	});

    	Spacer space1 = new Spacer("10px", "100%", "|");
    	DOM.setStyleAttribute(space1.innerText.getElement(), "color", "#FFF");

    	Spacer space2 = new Spacer("10px", "100%", "|");
    	DOM.setStyleAttribute(space2.innerText.getElement(), "color", "#FFF");

    	Spacer space3 = new Spacer("10px", "100%", "|");
    	DOM.setStyleAttribute(space3.innerText.getElement(), "color", "#FFF");

    	HorizontalPanel hp = new HorizontalPanel();
    	hp.setWidth("100%");

    	hp.add(about);
    	hp.add(space1);
    	hp.add(webservices);
    	hp.add(space2);
    	hp.add(contactUs);
    	hp.add(space3);
    	hp.add(partners);	
    	hp.add(new HTML("&nbsp;"));

    	hp.setCellVerticalAlignment(about, HasVerticalAlignment.ALIGN_MIDDLE);
    	hp.setCellHorizontalAlignment(about, HasHorizontalAlignment.ALIGN_LEFT);
    	hp.setCellVerticalAlignment(contactUs, HasVerticalAlignment.ALIGN_MIDDLE);
    	hp.setCellHorizontalAlignment(contactUs, HasHorizontalAlignment.ALIGN_LEFT);
    	hp.setCellVerticalAlignment(partners, HasVerticalAlignment.ALIGN_MIDDLE);
    	hp.setCellHorizontalAlignment(partners, HasHorizontalAlignment.ALIGN_LEFT);
    	hp.setCellWidth(hp.getWidget(7), "100%");

    	LinkLabel copy1 = new LinkLabel(null, null, constants.footerCopyRight() + "&nbsp;", "footer-copyright");
    	copy1.setLabelStyle("footer-copyright");
    	copy1.setClickable(false);

    	LinkLabel copy2 = new LinkLabel(null, null, "&nbsp;&&nbsp;", "footer-copyright");
    	copy2.setLabelStyle("footer-copyright");
    	copy2.setClickable(false);

    	LinkLabel copy3 = new LinkLabel(null, null, ",&nbsp;" + DateTimeFormat.getFormat("yyyy").format(new Date()), "footer-copyright");
    	copy3.setLabelStyle("footer-copyright");
    	copy3.setClickable(false);
    	
    	LinkLabel copyFAO = new LinkLabel(null, null, constants.footerOrganization(), "footer-copyright");
    	copyFAO.setLabelStyle("footer-copyright");
    	copyFAO.addClickHandler(new ClickHandler(){
    		public void onClick(ClickEvent arg0) {
    			HelpUtility.openURL(VBConstants.COPYRIGHTLINK);
    		}

    	});
    	LinkLabel copyART = new LinkLabel(null, null, constants.footerART(), "footer-copyright");
    	copyART.setLabelStyle("footer-copyright");
    	copyART.addClickHandler(new ClickHandler(){
    		public void onClick(ClickEvent arg0) {
    			HelpUtility.openURL(VBConstants.ARTGROUPLINK);
    		}

    	});
    	
    	HorizontalPanel rightFooterPanel = new HorizontalPanel();
    	rightFooterPanel.add(copy1);	
    	rightFooterPanel.add(copyFAO);	
    	rightFooterPanel.add(copy2);	
    	rightFooterPanel.add(copyART);	
    	rightFooterPanel.add(copy3);	
    	rightFooterPanel.setCellVerticalAlignment(copyFAO, HasVerticalAlignment.ALIGN_MIDDLE);
    	rightFooterPanel.setCellHorizontalAlignment(copyFAO, HasHorizontalAlignment.ALIGN_RIGHT);
    	DOM.setStyleAttribute(rightFooterPanel.getElement(), "paddingRight", "20px");

    	HorizontalPanel footer = new HorizontalPanel();
    	footer.setStyleName("footer");
    	//footer.add(hp);
    	footer.add(rightFooterPanel);
    	footer.setCellVerticalAlignment(rightFooterPanel, HasVerticalAlignment.ALIGN_MIDDLE);
    	footer.setCellHorizontalAlignment(rightFooterPanel, HasHorizontalAlignment.ALIGN_RIGHT);
    	//footer.setCellVerticalAlignment(hp, HasVerticalAlignment.ALIGN_MIDDLE);
    	//footer.setCellHorizontalAlignment(hp, HasHorizontalAlignment.ALIGN_LEFT);

    	footer.setCellWidth(hp, "100%");
    	this.add(footer);
    	this.setSize("100%", "21px");
    }

}
