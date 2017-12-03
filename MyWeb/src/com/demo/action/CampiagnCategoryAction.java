package com.demo.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.demo.dao.CampaignCategoryDAO;
import com.demo.model.CampaignCategory;
import com.demo.service.CampaignCategoryService;

public class CampiagnCategoryAction {
	
	private CampaignCategoryDAO campaignCategoryDAO = new CampaignCategoryDAO();
	private CampaignCategory campaignCategory= new CampaignCategory();
	private CampaignCategoryService campaignCategoryService = new CampaignCategoryService();
	
	
	//public String findByCategory_id() {
		//campaignList = campaignCategoryService.findAll();
		
	//}

	public CampiagnCategoryAction() {
		// TODO Auto-generated constructor stub
	}

}
