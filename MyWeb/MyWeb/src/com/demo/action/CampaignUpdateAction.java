package com.demo.action;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.demo.model.Campaign;
import com.demo.dao.CampaignDAO;
import com.demo.service.CampaignService;

import com.demo.model.CampaignUpdates;
import com.demo.model.Comment;
import com.demo.dao.CampaignUpdatesDAO;
import com.demo.service.CampaignUpdateService;

public class CampaignUpdateAction {
	private List<CampaignUpdates> campaignUpdatesList;
	private CampaignUpdates campaignUpdates=new CampaignUpdates();
	private CampaignUpdatesDAO campaignUpdatesDAO=new CampaignUpdatesDAO();
	private CampaignUpdateService campaignUpdateService=new CampaignUpdateService();
	
	
	private Integer updateId;
	private String flag;
	private Timestamp actionModifyTime;
	private Timestamp actionPublishTime;
	
	private Timestamp modifyTime;
	private Timestamp publishTime;
	private String content;
	private String imageUrl;
	private String modifier;
	private Campaign campaign1=new Campaign();
	private CampaignService campaignService=new CampaignService();
	private ArrayList<ShowInfo> infoList=new ArrayList<ShowInfo>();
	private CampaignDAO campaignDAO=new CampaignDAO();
	private Integer campaign;
	private String title;//campaignµÄ±êÌâ
	private Integer userid;
	
	public CampaignUpdateAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String showInfoBymodifyTime(){
		System.out.println("showInfoBymodifyTime");
		System.out.println("actionModifyTime"+actionModifyTime);
		campaignUpdatesList=campaignUpdateService.findByModifyTime(actionModifyTime);
		System.out.println("CampaignUpdate ShowInfo");
		flag="success";
		return "success";
	}
	public String showInfoBypublishTime(){
		System.out.println("showInfoBypublishTime");
		System.out.println("actionPublishTime"+actionPublishTime);
		campaignUpdatesList=campaignUpdateService.findByPublishTime(actionPublishTime);
		System.out.println("CampaignUpdate ShowInfo");
		flag="success";
		return flag;
	}
	public String insert(){
		System.out.println("insert updates");
		HttpSession session=ServletActionContext.getRequest().getSession();
		userid=((Integer)session.getAttribute("updateId"));
		System.out.println(userid);
		
		System.out.println(title);
		campaign=campaignService.findByTitle(title).getCampaignId();
		System.out.println(campaign);
		
		modifyTime=new Timestamp(new Date().getTime());
		System.out.println(modifyTime);
		
		
		
		 List<CampaignUpdates> all=campaignUpdateService.findAll();
		 int num=all.size();
		 System.out.println(num);
		 CampaignUpdates temp=all.get(num-1);
		 int index=temp.getUpdateId();
		 updateId=new Integer(index+1+"");
		 System.out.println(updateId);
		 CampaignUpdates campaignUpdates = campaignUpdateService.findById(updateId);
		 if(campaignUpdates.getModifier() != null && campaignUpdates.getModifier().equals(modifier)){
			 campaignUpdateService.insert(campaignUpdateService.findById(updateId));
		 campaignUpdates.setModifyTime(modifyTime);
		 campaignUpdates.setUpdateId(updateId);
		 campaignUpdates.setContent(content);
		 campaignUpdates.setImageUrl(imageUrl);
		 campaignUpdates.setModifier(modifier);
		 campaignUpdates.setCampaign(campaign1);
		 System.out.println(campaignUpdates);
		 campaignUpdateService.insert(campaignUpdates);
		 flag="success";
		 }
		 else
		 {
				flag="fault";
			}
			System.out.println(flag);
			return flag;	
		 
		
	}
	
	public String delete(){
		System.out.println("delete");
		System.out.println("updateId"+updateId);
		if(campaignUpdateService.findById(updateId)!=null){
			campaignUpdateService.delete(campaignUpdateService.findById(updateId));
			flag="success";
		}
		else{
			flag="fault";
		}
		System.out.println(flag);
		return flag;
	}
	
	public CampaignUpdates getCampaignUpdates() {
		return campaignUpdates;
	}
	public void setCampaignUpdates(CampaignUpdates campaignUpdates) {
		this.campaignUpdates = campaignUpdates;
	}
	
	public String execute()
	{
		System.out.println("CampaingUpdate execute!!");
		campaignUpdatesList=campaignUpdateService.findAll();
		System.out.println(campaignUpdatesList.size());
		flag="success";
		return flag;
	}
	
	public CampaignUpdatesDAO getCampaignUpdatesDAO() {
		return campaignUpdatesDAO;
	}
	public void setCampaignUpdatesDAO(CampaignUpdatesDAO campaignUpdatesDAO) {
		this.campaignUpdatesDAO = campaignUpdatesDAO;
	}
	
	public List<CampaignUpdates> getCampaignUpdatesList() {
		return campaignUpdatesList;
	}
	public void setCampaignUpdatesList(List<CampaignUpdates> campaignUpdatesList) {
		this.campaignUpdatesList = campaignUpdatesList;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public Integer getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	
	public Timestamp getActionModifyTime() {
		return actionModifyTime;
	}
	public void setActionModifyTime(Timestamp actionModifyTime) {
		this.actionModifyTime = actionModifyTime;
	}
	
	public Timestamp getActionPublishTime() {
		return actionPublishTime;
	}
	public void setActionPublishTime(Timestamp actionPublishTime) {
		this.actionPublishTime = actionPublishTime;
	}
	
	public CampaignUpdateService getCampaignUpdateService() {
		return campaignUpdateService;
	}
	public void setCampaignUpdateService(CampaignUpdateService campaignUpdateService) {
		this.campaignUpdateService = campaignUpdateService;
	}

	
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	
	public Integer getCampaign() {
		return campaign;
	}
	public void setCampaign(Integer campaign) {
		this.campaign = campaign;
	}
	
	public CampaignService getCampaignService() {
		return campaignService;
	}
	public void setCampaignService(CampaignService commentService) {
		this.campaignService = campaignService;
	}
	
	public ArrayList<ShowInfo> getInfoList() {
		return infoList;
	}
	public void setInfoList(ArrayList<ShowInfo> infoList) {
		this.infoList = infoList;
	}
	
	public CampaignDAO getCampaignDAO() {
		return campaignDAO;
	}
	public void setCampaignDAO(CampaignDAO campaignDAO) {
		this.campaignDAO = campaignDAO;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
