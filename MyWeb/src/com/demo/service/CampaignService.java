package com.demo.service;

import com.demo.dao.CampaignUpdatesDAO;
import com.demo.model.Campaign;
import com.demo.dao.CampaignDAO;

public class CampaignService {
	private CampaignDAO campaignDAO=new CampaignDAO();
	public CampaignService() {
		// TODO Auto-generated constructor stub
	}

	public Campaign findByTitle(String title) {    //�¼ӵķ���-������
		// TODO Auto-generated method stub
		return (Campaign) campaignDAO.findByTitle(title);
	}

	public Campaign findById(Object longValue) {    //�¼ӵķ���-������
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
