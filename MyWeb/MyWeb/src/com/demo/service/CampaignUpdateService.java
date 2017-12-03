package com.demo.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Timestamp;
import com.demo.model.Campaign;
import com.demo.model.CampaignUpdates;
import com.demo.model.Comment;
import com.demo.dao.CampaignUpdatesDAO;
public class CampaignUpdateService {
	public CampaignUpdateService() {
		// TODO Auto-generated constructor stub
	}
	
	private CampaignUpdatesDAO campaignUpdatesDAO=new CampaignUpdatesDAO();
	public List<CampaignUpdates> findByCampaingId(Integer campaign){
		List<CampaignUpdates> results=campaignUpdatesDAO.findByProperty("campaign_id",campaign);
		return results;
		}
	//private CampaignUpdates campaignupdates=new CampaignUpdates();
	
	public CampaignUpdates findById(Integer id){
		return campaignUpdatesDAO.findById(id);
	}
/*	 public void saveOrUpdate(CampaignUpdates instance)
    {
		 CampaignUpdatesDAO.saveOrUpdate(instance);
    }*/
	 public void insert(CampaignUpdates campaignUpdates)
		{
			System.out.println("beforeSave");
			campaignUpdatesDAO.save(campaignUpdates);
			System.out.println("save");
		}

    public void delete(CampaignUpdates c)
    {
    	campaignUpdatesDAO.delete(c);
    }
    public List findByModifyTime(Timestamp modifyTime){
    	return campaignUpdatesDAO.findByModifyTime(modifyTime);
    }
    public List findByPublishTime(Timestamp publishTime){
    	return  campaignUpdatesDAO.findByPublishTime(publishTime);
    }
    
    public ArrayList<CampaignUpdates> findAll()
	{
		ArrayList<CampaignUpdates> updatesList=new ArrayList<CampaignUpdates>();
		List sl=campaignUpdatesDAO.findAll();
		Iterator ite=sl.iterator();
		while(ite.hasNext())
		{
			CampaignUpdates updates=(CampaignUpdates)ite.next();
			updatesList.add(updates);
		}
		return updatesList;
	}

	

	
    
}
