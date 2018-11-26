package com.logo.ui.components;

import java.util.List;

import com.github.appreciated.material.MaterialTheme;
import com.logo.LogoresMainUI;
import com.logo.data.entity.ReAlbaniankv;
import com.logo.data.entity.ReArabiceg;
import com.logo.data.entity.ReArabicjo;
import com.logo.data.entity.ReArabicsa;
import com.logo.data.entity.ReAzerbaijaniaz;
import com.logo.data.entity.ReBulgarianbg;
import com.logo.data.entity.ReEnglishus;
import com.logo.data.entity.ReFrenchfr;
import com.logo.data.entity.ReGeorgiange;
import com.logo.data.entity.ReGermande;
import com.logo.data.entity.RePersianir;
import com.logo.data.entity.ReResource;
import com.logo.data.entity.ReResourceitem;
import com.logo.data.entity.ReRomanianro;
import com.logo.data.entity.ReRussianru;
import com.logo.data.entity.ReTurkishtr;
import com.logo.data.entity.ReTurkmentm;
import com.logo.data.entity.ReUser;
import com.logo.data.repository.ReResourceRep;
import com.logo.data.repository.ReResourceitemRep;
import com.logo.ui.view.ResourceViewNew;
import com.logo.util.LogoResConstants;
import com.logo.util.enums.ResourceType;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class RowLayout extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean focus = false;

	private boolean isSingleForm = false;
	
	private transient ReResource reResource;

	private transient ReResourceRep reResourceRep;
	
	private transient ReResourceitem reResourceitem;

	private transient ReResourceitemRep reResourceitemRep;

	ReEnglishus reEnglishus = null;
	private transient List<ReEnglishus> reEnglishuses = null;
	
	ReGermande reGermande = null;
	private transient List<ReGermande> reGermandes = null;
	
	RePersianir rePersianir = null;
	private transient List<RePersianir> rePersianirs = null;
	
	ReAzerbaijaniaz reAzerbaijaniaz = null;
	private transient List<ReAzerbaijaniaz> reAzerbaijaniazs = null;

	ReBulgarianbg reBulgarianbg = null;
	private transient List<ReBulgarianbg> reBulgarianbgs = null;

	ReRussianru reRussianru = null;
	private transient List<ReRussianru> reRussianrus = null;

	ReRomanianro reRomanianro = null;
	private transient List<ReRomanianro> reRomanianros = null;

	ReGeorgiange reGeorgiange = null;
	private transient List<ReGeorgiange> reGeorgianges = null;

	ReArabicjo reArabicjo = null;
	private transient List<ReArabicjo> reArabicjos = null;

	ReFrenchfr reFrenchfr = null;
	private transient List<ReFrenchfr> reFrenchfrs = null;
	
	ReAlbaniankv reAlbaniankv = null;
	private transient List<ReAlbaniankv> reAlbaniankvs = null;
	
	ReTurkmentm reTurkmentm = null;
	private transient List<ReTurkmentm> reTurkmentms = null;

	ReArabiceg reArabiceg = null;
	private transient List<ReArabiceg> reArabicegs = null;

	ReArabicsa reArabicsa = null;
	private transient List<ReArabicsa> reArabicsas = null;

	CustomHorizontalLayout layoutENUS;
	CustomHorizontalLayout layoutFAIR;
	CustomHorizontalLayout layoutDEDE; 
	CustomHorizontalLayout layoutAZAZ; 
	CustomHorizontalLayout layoutBGBG; 
	CustomHorizontalLayout layoutRURU;
	CustomHorizontalLayout layoutRORO;
	CustomHorizontalLayout layoutKAGE;
	CustomHorizontalLayout layoutARJO;
	CustomHorizontalLayout layoutFRFR;
	CustomHorizontalLayout layoutSQKV;
	CustomHorizontalLayout layoutTKTM;
	CustomHorizontalLayout layoutAREG;
	CustomHorizontalLayout layoutARSA;
	
	String valTR = "";
	String valEN = "";
	String valGE = "";
	String valIR = "";
	String valAZ = "";
	String valBG = "";
	String valRU = "";
	String valRO = "";
	String valKA = "";
	String valJO = "";
	String valFR = "";
	String valSQ = "";
	String valTK = "";
	String valEG = "";
	String valSA = "";
	
	private ResourceViewNew resView;
	private ReUser reUser;
	
	public RowLayout(ReResource reResource, ReResourceitem reResourceitem, boolean focus, boolean vertical, ResourceViewNew resView, boolean isSingleForm,
			ReUser user) {
		this.reResource = reResource;
		this.reResourceitem = reResourceitem;
		this.reResourceitemRep = LogoresMainUI.getMrepositorycontainer().getReResourceitemRep();
		this.reResourceRep = LogoresMainUI.getMrepositorycontainer().getResRepo();
		this.focus = focus;
		this.resView = resView;
		this.isSingleForm = isSingleForm;
		this.reUser = user;

		if(reResource == null)
			this.reResource = reResourceRep.findByid(reResourceitem.getResourceref());

		addStyleName("backColorPage2");
		setSpacing(false);
		setMargin(false);
		addComponent(resourceDetailCardHorizontal(vertical));
	}

	private HorizontalLayout resourceDetailCardHorizontal(boolean isVertical) {

		VaadinIcons iconUp;
		VaadinIcons iconDown;
		if(isVertical)
		{
			iconUp = VaadinIcons.ANGLE_UP;
			iconDown = VaadinIcons.ANGLE_DOWN;
		}
		else
		{
			iconUp = VaadinIcons.ANGLE_LEFT;
			iconDown = VaadinIcons.ANGLE_RIGHT;
		}
			
		HorizontalLayout resDetCard = new HorizontalLayout();
		resDetCard.setSizeFull();
		resDetCard.setSpacing(false);
		resDetCard.setMargin(false);

		Layout tabSheet = getTabSheet(isVertical);
		tabSheet.setSizeFull();
		
		List<ReTurkishtr> reTurkishtrs = reResourceitem.getReTurkishtr();
		
		ReTurkishtr dummyTurkish = new ReTurkishtr();
		if ((reTurkishtrs != null) && !reTurkishtrs.isEmpty())
		{
			dummyTurkish = reTurkishtrs.get(0);
			valTR = reTurkishtrs.get(0).getResourcestr();
		}
			
		if (reResource.getResourcetype().equals(ResourceType.LOCALIZABLE))
		{
			reEnglishuses = reResourceitem.getReEnglishus();
			reGermandes = reResourceitem.getReGermande();
			rePersianirs = reResourceitem.getRePersianir();
			reAzerbaijaniazs = reResourceitem.getReAzerbaijaniaz();
			reBulgarianbgs = reResourceitem.getReBulgarianbg();
			reRussianrus = reResourceitem.getReRussianru();
			reRomanianros = reResourceitem.getReRomanianro();
			reGeorgianges = reResourceitem.getReGeorgiange();
			reArabicjos = reResourceitem.getReArabicjo();
			reFrenchfrs = reResourceitem.getReFrenchfr();
			reAlbaniankvs = reResourceitem.getReAlbaniankv();
			reTurkmentms = reResourceitem.getReTurkmentm();
			reArabicegs = reResourceitem.getReArabiceg();
			reArabicsas = reResourceitem.getReArabicsa();
		}
		
		if ((reEnglishuses != null) && !reEnglishuses.isEmpty())
		{
			reEnglishus = reEnglishuses.get(0);
			valEN = reEnglishus.getResourcestr();
		}

		if ((reGermandes != null) && !reGermandes.isEmpty())
		{
			reGermande = reGermandes.get(0);
			valGE = reGermande.getResourcestr();
		}			
		
		if ((rePersianirs != null) && !rePersianirs.isEmpty())
		{
			rePersianir = rePersianirs.get(0);
			valIR = rePersianir.getResourcestr();
		}		

		if ((reAzerbaijaniazs != null) && !reAzerbaijaniazs.isEmpty())
		{
			reAzerbaijaniaz = reAzerbaijaniazs.get(0);
			valAZ = reAzerbaijaniaz.getResourcestr();
		}

		if ((reBulgarianbgs != null) && !reBulgarianbgs.isEmpty())
		{
			reBulgarianbg = reBulgarianbgs.get(0);
			valBG = reBulgarianbg.getResourcestr();
		}

		if ((reRussianrus != null) && !reRussianrus.isEmpty())
		{
			reRussianru = reRussianrus.get(0);
			valRU = reRussianru.getResourcestr();
		}

		if ((reRomanianros != null) && !reRomanianros.isEmpty())
		{
			reRomanianro = reRomanianros.get(0);
			valRO = reRomanianro.getResourcestr();
		}

		if ((reGeorgianges != null) && !reGeorgianges.isEmpty())
		{
			reGeorgiange = reGeorgianges.get(0);
			valKA = reGeorgiange.getResourcestr();
		}

		if ((reArabicjos != null) && !reArabicjos.isEmpty())
		{
			reArabicjo  = reArabicjos.get(0);
			valJO = reArabicjo.getResourcestr();
		}

		if ((reFrenchfrs != null) && !reFrenchfrs.isEmpty())
		{
			reFrenchfr  = reFrenchfrs.get(0);
			valFR = reFrenchfr.getResourcestr();
		}

		if ((reAlbaniankvs != null) && !reAlbaniankvs.isEmpty())
		{
			reAlbaniankv  = reAlbaniankvs.get(0);
			valSQ = reAlbaniankv.getResourcestr();
		}

		if ((reTurkmentms != null) && !reTurkmentms.isEmpty())
		{
			reTurkmentm  = reTurkmentms.get(0);
			valTK = reTurkmentm.getResourcestr();
		}
		
		if ((reArabicegs != null) && !reArabicegs.isEmpty())
		{
			reArabiceg  = reArabicegs.get(0);
			valEG = reArabiceg.getResourcestr();
		}		

		if ((reArabicsas != null) && !reArabicsas.isEmpty())
		{
			reArabicsa  = reArabicsas.get(0);
			valSA = reArabicsa.getResourcestr();
		}
		
		CustomHorizontalLayout layoutTRTR = new CustomHorizontalLayout(reResourceitem.getId(),dummyTurkish, valTR, valTR, LogoResConstants.RE_TURKISHTR_NAME,false);
	
		tabSheet.addComponent(layoutTRTR);

		Panel tabPanel = new Panel();
		tabPanel.setSizeFull();
		tabPanel.addStyleName(MaterialTheme.PANEL_BORDERLESS);
		tabPanel.setWidth("200%");

		tabPanel.setContent(tabSheet);
		
		VerticalLayout resourceDetailForm = createResourceDetailForm();
		resourceDetailForm.setWidth("100%");
		tabPanel.setWidth("100%");
		
		resDetCard.addComponent(resourceDetailForm);
		if(isVertical)
			resDetCard.addComponent(tabSheet);
		else
			resDetCard.addComponent(tabPanel);
		
		resDetCard.setExpandRatio(resourceDetailForm, 1.30f);
		resDetCard.setComponentAlignment(resourceDetailForm, Alignment.MIDDLE_LEFT);
		
		if(isVertical)
		{
			resDetCard.setExpandRatio(tabSheet, 5.0f);
			resDetCard.setComponentAlignment(tabSheet, Alignment.MIDDLE_LEFT);
		}
		else
		{
			resDetCard.setExpandRatio(tabPanel, 5.0f);
			resDetCard.setComponentAlignment(tabPanel, Alignment.MIDDLE_LEFT);
		}

		Button open = new Button();
		open.setIcon(iconDown);
		open.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		open.setDescription("Tüm dilleri göster");

		if (reResource.getResourcetype().equals(ResourceType.LOCALIZABLE))
			resDetCard.addComponent(open);

		Button close = new Button();
		close.setIcon(iconUp);
		close.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		close.setDescription("Tüm dilleri gizle");
		
		layoutENUS = new CustomHorizontalLayout(reResourceitem.getId(),reEnglishus,valTR, valEN, LogoResConstants.RE_ENGLISHUS_NAME, true);
		tabSheet.addComponent(layoutENUS);

		layoutTRTR.addStyleName("csstag_1");
		layoutENUS.addStyleName("csstag_2");

		open.addClickListener(e -> {
			
			layoutFAIR = new CustomHorizontalLayout(reResourceitem.getId(), null,valTR, valIR, LogoResConstants.RE_PERSIANIR_NAME, false);
			layoutDEDE = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valGE, LogoResConstants.RE_GERMANDE_NAME, true);
			layoutAZAZ = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valAZ, LogoResConstants.RE_AZERBAIJANIAZ_NAME, true);
			layoutBGBG = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valBG, LogoResConstants.RE_BULGARIANBG_NAME, true);
			layoutRURU = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valRU, LogoResConstants.RE_RUSSIANRU_NAME, true);
			layoutRORO = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valRO, LogoResConstants.RE_ROMANIANRO_NAME, true);
			layoutKAGE = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valKA, LogoResConstants.RE_GEORGIANGE_NAME, true);
			layoutARJO = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valJO, LogoResConstants.RE_ARABICJO_NAME, true);
			layoutFRFR = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valFR, LogoResConstants.RE_FRENCHFR_NAME, true);
			layoutSQKV = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valSQ, LogoResConstants.RE_ALBANIANKV_NAME, true);
			layoutTKTM = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valTK, LogoResConstants.RE_TURKMENTM_NAME, true);
			layoutAREG = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valEG, LogoResConstants.RE_ARABICEG_NAME, true);
			layoutARSA = new CustomHorizontalLayout(reResourceitem.getId(),null,valTR, valSA, LogoResConstants.RE_ARABICSA_NAME, true);
			
			addLangLayout(tabSheet,layoutFAIR,LogoResConstants.RE_PERSIANIR_NAME);
			addLangLayout(tabSheet,layoutDEDE,LogoResConstants.RE_GERMANDE_NAME);
			addLangLayout(tabSheet,layoutAZAZ,LogoResConstants.RE_AZERBAIJANIAZ_NAME);
			addLangLayout(tabSheet,layoutBGBG,LogoResConstants.RE_BULGARIANBG_NAME);
			addLangLayout(tabSheet,layoutRURU,LogoResConstants.RE_RUSSIANRU_NAME);
			addLangLayout(tabSheet,layoutRORO,LogoResConstants.RE_ROMANIANRO_NAME);
			addLangLayout(tabSheet,layoutKAGE,LogoResConstants.RE_GEORGIANGE_NAME);
			addLangLayout(tabSheet,layoutARJO,LogoResConstants.RE_ARABICJO_NAME);
			addLangLayout(tabSheet,layoutFRFR,LogoResConstants.RE_FRENCHFR_NAME);
			addLangLayout(tabSheet,layoutSQKV,LogoResConstants.RE_ALBANIANKV_NAME);
			addLangLayout(tabSheet,layoutTKTM,LogoResConstants.RE_TURKMENTM_NAME);
			addLangLayout(tabSheet,layoutAREG,LogoResConstants.RE_ARABICEG_NAME);
			addLangLayout(tabSheet,layoutARSA,LogoResConstants.RE_ARABICSA_NAME);
			
			layoutFAIR.addStyleName("csstag_1");
			layoutDEDE.addStyleName("csstag_2");
			layoutAZAZ.addStyleName("csstag_1");
			layoutBGBG.addStyleName("csstag_2");
			layoutRURU.addStyleName("csstag_1");
			layoutRORO.addStyleName("csstag_2");
			layoutKAGE.addStyleName("csstag_1");
			layoutARJO.addStyleName("csstag_2");
			layoutFRFR.addStyleName("csstag_1");
			layoutSQKV.addStyleName("csstag_2");
			layoutTKTM.addStyleName("csstag_1");
			layoutAREG.addStyleName("csstag_2");
			layoutARSA.addStyleName("csstag_1");
			
			resDetCard.removeComponent(open);
			resDetCard.addComponent(close);
			if (!isVertical)
				tabSheet.setWidth("200%");
		});

		close.addClickListener(e -> {
			tabSheet.removeComponent(layoutFAIR);
			tabSheet.removeComponent(layoutDEDE);
			tabSheet.removeComponent(layoutAZAZ);
			tabSheet.removeComponent(layoutBGBG);
			tabSheet.removeComponent(layoutRURU);
			tabSheet.removeComponent(layoutRORO);
			tabSheet.removeComponent(layoutKAGE);
			tabSheet.removeComponent(layoutARJO);
			tabSheet.removeComponent(layoutFRFR);
			tabSheet.removeComponent(layoutSQKV);
			tabSheet.removeComponent(layoutTKTM);
			tabSheet.removeComponent(layoutAREG);
			tabSheet.removeComponent(layoutARSA);
			
			layoutFAIR.removeStyleName("csstag_1");
			layoutDEDE.removeStyleName("csstag_2");
			layoutAZAZ.removeStyleName("csstag_1");
			layoutBGBG.removeStyleName("csstag_2");
			layoutRURU.removeStyleName("csstag_1");
			layoutRORO.removeStyleName("csstag_2");
			layoutKAGE.removeStyleName("csstag_1");
			layoutARJO.removeStyleName("csstag_2");
			layoutFRFR.removeStyleName("csstag_1");
			layoutSQKV.removeStyleName("csstag_2");
			layoutTKTM.removeStyleName("csstag_1");
			layoutAREG.removeStyleName("csstag_2");
			layoutARSA.removeStyleName("csstag_1");
			
			resDetCard.removeComponent(close);
			resDetCard.addComponent(open);
			if (!isVertical)
				tabSheet.setWidth("100%");
		});
		if (focus)
			open.focus();
		
		return resDetCard;
	}

	private void addLangLayout(Layout tabSheet, CustomHorizontalLayout customHorizontalLayout, String language) {
		boolean addLayout = false;
		switch (language) {
		case LogoResConstants.RE_PERSIANIR_NAME:
			if (reUser.getFairaccessrights() > 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_GERMANDE_NAME:
			if (reUser.getDedeaccessrights() > 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_AZERBAIJANIAZ_NAME:
			if (reUser.getAzazaccessrights() > 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_BULGARIANBG_NAME:
			if (reUser.getBgbgaccessrights() > 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_RUSSIANRU_NAME:
			if (reUser.getRuruaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_ROMANIANRO_NAME:
			if (reUser.getRoroaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_GEORGIANGE_NAME:
			if (reUser.getKageaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_ARABICJO_NAME:
			if (reUser.getArjoaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_FRENCHFR_NAME:
			if (reUser.getFrfraccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_ALBANIANKV_NAME:
			if (reUser.getSqkvaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_TURKMENTM_NAME:
			if (reUser.getTktmaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_ARABICEG_NAME:
			if (reUser.getAregaccessrights()> 0)
				addLayout = true;
			break;
		case LogoResConstants.RE_ARABICSA_NAME:
			if (reUser.getArsaaccessrights()> 0)
				addLayout = true;
			break;
		default:
			break;
		}
		if (addLayout)
			tabSheet.addComponent(customHorizontalLayout);
	}
	
	private Layout getTabSheet(boolean isVertical)
	{
		FormLayout tabSheetForm = new FormLayout();
		tabSheetForm.setSizeFull();
		tabSheetForm.setSpacing(false);
		tabSheetForm.setMargin(false);
		
		HorizontalLayout tabSheet = new HorizontalLayout();
		tabSheet.setSizeFull();
		tabSheet.setSpacing(false);
		tabSheet.setMargin(false);
		if(isVertical)
			return tabSheetForm;
		else
			return tabSheet;
	}
	
	private VerticalLayout createResourceDetailForm() {
		VerticalLayout mainLayout = new VerticalLayout();
		HorizontalLayout resDetFormLayout = new HorizontalLayout();
		mainLayout.setSizeFull();
		
		resDetFormLayout.setSizeFull();
		resDetFormLayout.setWidth("100%");
	
		
		PopupTextFieldContent mypopContent = new PopupTextFieldContent(reResourceitem, reResourceitemRep);
	       
        final PopupView pop = new PopupView(mypopContent);       
        pop.setHideOnMouseOut(false);
		mypopContent.getBtSave().addClickListener(event -> {
			pop.setPopupVisible(false);
			mypopContent.save();
		});

		mypopContent.getBtCancel().addClickListener(event -> pop.setPopupVisible(false));
		
		Button resourceLink = new Button();
		
		resourceLink.setSizeUndefined();
		
		resourceLink.setCaption("<b style=text-align:left;color:#252839;>"+reResource.getResourcenr()+"</b>");
		resourceLink.setCaptionAsHtml(true);
		resourceLink.addStyleName(MaterialTheme.BUTTON_BORDER+ " "+ MaterialTheme.BUTTON_ROUND + " " + MaterialTheme.BUTTON_CUSTOM);

		
		resourceLink.addClickListener(event -> {
			String filter = reResource.getResourcegroup().name() + "->" + Integer.toString(reResource.getResourcenr());
			resView.createResoucePage(filter, true);
		});
		
		Label lbl = new Label();
		if(isSingleForm)
		{
			if (reResource.getResourcetype().equals(ResourceType.LOCALIZABLE))
			{
				if ((reEnglishuses != null) && !reEnglishuses.isEmpty())
				{
					lbl.setIcon(VaadinIcons.CHECK);
					lbl.setDescription("Çevrim yapılmış");
				}
				else
				{
					lbl.setIcon(VaadinIcons.MINUS);
					lbl.setDescription("Çevrim yapılmamış");
				}
			}

			resDetFormLayout.addComponents(pop);
			//resDetFormLayout.setComponentAlignment(lbl, Alignment.MIDDLE_LEFT);
			resDetFormLayout.setComponentAlignment(pop, Alignment.MIDDLE_CENTER);
			//resDetFormLayout.setExpandRatio(lbl, 1.0f);
			resDetFormLayout.setExpandRatio(pop, 1.0f);
		}
		else
		{
			if (reResource.getResourcetype().equals(ResourceType.LOCALIZABLE))
			{
				if ((reEnglishuses != null) && !reEnglishuses.isEmpty())
				{
					lbl.setIcon(VaadinIcons.CHECK);
					lbl.setDescription("Çevrim yapılmış");
				}
				else
				{
					lbl.setIcon(VaadinIcons.MINUS);
					lbl.setDescription("Çevrim yapılmamış");
				}
			}

			resDetFormLayout.addComponentsAndExpand(resourceLink, pop);
			//resDetFormLayout.setExpandRatio(lbl, 1.0f);
			resDetFormLayout.setExpandRatio(resourceLink, 2.0f);
			resDetFormLayout.setExpandRatio(pop, 1.0f);
		}
		mainLayout.addComponents(resDetFormLayout);
		mainLayout.setComponentAlignment(resDetFormLayout, Alignment.MIDDLE_LEFT);
		return mainLayout;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}