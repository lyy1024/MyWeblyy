package com.demo.service;

import com.demo.dao.CampaignUpdatesDAO;
import com.demo.model.Campaign;
import com.demo.dao.CampaignDAO;

public class CampaignService {
	private CampaignDAO campaignDAO=new CampaignDAO();
	public CampaignService() {
		// TODO Auto-generated constructor stub
	}

	public Campaign findByTitle(String title) {    //新加的方法-刘悦悦
		// TODO Auto-generated method stub
		return (Campaign) campaignDAO.findByTitle(title);
	}

	public Campaign findById(Object longValue) {    //新加的方法-刘悦悦
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
