package com.demo.action;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.demo.dao.CampaignDAO;
import com.demo.model.Campaign;
import com.demo.model.Comment;
import com.demo.service.CampaignService;
import com.demo.service.CommentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment> {
	public CommentAction() {
		// TODO Auto-generated constructor stub
	}
	private List<Comment> commentList;
	private Comment comment=new Comment();
	private CommentService commentService=new CommentService();
	private CampaignService campaignService=new CampaignService();
	private ArrayList<ShowInfo> infoList=new ArrayList<ShowInfo>();
	
	private CampaignDAO campaignDAO=new CampaignDAO();
	private Integer commentId;
	private Integer campaign;
	private String title;//campaignµÄ±êÌâ
	private String commentText;
	private Timestamp publishTime;
	private String modifier;
	private Timestamp modifyTime;
	private String flag;
	private Integer userid;
	private Campaign campaign1=new Campaign();
	private String actionCommentId;
	
	
	
	public String searchComment()
	{
		System.out.println("searchComment");
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//imgString=(String) session.getAttribute("imgMain");
		System.out.println(title);
		
		Campaign campaign=campaignService.findByTitle(title);
		commentList=commentService.findByCampaingId(campaign.getCId());
		
		System.out.println(commentList.size());
		
		for(int i=0;i<commentList.size();i++)
		{
			System.out.println(i);
			
			Comment el=commentList.get(i);
			Integer cId=campaign1.getCampaignId();
			
			Campaign cd=campaignService.findById(cId.longValue());
			ShowInfo info=new ShowInfo(cd.getTitle(),cd.getcampaignCategory());
		    
			System.out.println(commentList.get(i).getCommentId()+" "+commentList.get(i).getCommentText()
					+commentList.get(i).getPublishTime()+" ");	
			infoList.add(info);
		    info.print();
		}
		return "success";
	}
	
	
	/*private Campaign getCampaignid() {
		// TODO Auto-generated method stub
		return null;
	}*/


	public String insert()
	{
		commentId=1;
		System.out.println("insert comment");
		HttpSession session = ServletActionContext.getRequest().getSession();
		Integer commentId=comment.getCommentId();
		 String commentText=comment.getCommentText();
		Integer campaign=campaign1.getCampaignId();
		System.out.println(campaign);
		 //userid = ((Integer) session.getAttribute("commentId"));
		// title=((String) session.getAttribute("title"));
		//System.out.println(userid);
		//System.out.println(title);
		//campaign=campaignService.findByTitle(title).getCampaignId();
		//System.out.println(campaign);
		
		publishTime=new Timestamp(new Date().getTime());
		System.out.println(publishTime);
		
		List<Comment> all=commentService.findAll();
		int num=all.size();
		System.out.println(num);
		Comment  temp=all.get(num-1);
		//int index=Integer.parseInt(temp.getCommentId());
		int index=temp.getCommentId();
		commentId=new Integer(index+1+"");
		System.out.println(commentId);
		comment.setPublishTime(publishTime);
		comment.setCommentId(commentId);
		comment.setCommentText(commentText);
		//comment.setCampaignId(campaignId);
		
		System.out.println(comment);
		//comment.print();
		commentService.insert(comment);
		
		List<Comment> all2=commentService.findAll();
		int num2=all2.size();
		System.out.println(num2);
		return execute();
	}
	public String update() {
		System.out.println("update Comment");
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		userid = (Integer) session.getAttribute("commentId");
		
		System.out.println(modifier);
		Comment comment = commentService.findById(commentId);
		if(comment.getModifier() != null && comment.getModifier().equals(modifier))
		{
			commentService.insert(commentService.findById(commentId));
			modifyTime=new Timestamp(new Date().getTime());
			comment.setModifier(modifier);
			comment.setModifyTime(modifyTime);
			comment.setCommentText(commentText);
			
			//comment.print(); 
			System.out.println(comment);
			commentService.insert(comment);
			flag="success";
		}
		else 
		{
			flag="fault";
		}
		System.out.println(flag);
		return flag;	
	}
	
	public String serachByTitle(){
        System.out.println("search: "+title);
		
		List<Campaign> cl= campaignDAO.findByTitle(title);
		
		System.out.println(cl.size());
		if(title!=null && campaignDAO.findByTitle(title).equals(title)){
		campaign=((Campaign) cl).getCampaignId(); 
		return "success";}
		else return "fault";
	}
	public CampaignDAO getCampaignDAO() {
		return campaignDAO;
	}
	public void setCampaignDAO(CampaignDAO campaignDAO) {
		this.campaignDAO = campaignDAO;
	}
	
	public Campaign getCampaign1() {
		return campaign1;
	}
	public void setCampaign(Campaign campaign1) {
		this.campaign1 = campaign1;
	}
	
	public Integer getCampaign() {
		return campaign;
	}
	public void setCampaign(Integer campaign) {
		this.campaign = campaign;
	}
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public ArrayList<ShowInfo> getInfoList() {
		return infoList;
	}
	public void setInfoList(ArrayList<ShowInfo> infoList) {
		this.infoList = infoList;
	}
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	
	public String execute()
	{
		System.out.println("Evaluate execute!!");
		commentList=commentService.findAll();
		System.out.println(commentList.size());
		flag="success";
		return flag;
	}
	
	public String delete()
	{
		System.out.println("delete");
		
		System.out.println("commentId: "+commentId);
		
		if(commentService.findById(commentId)!=null)
		{
			commentService.delete(commentService.findById(commentId));
			flag="success";
		}
		else 
		{
			flag="fault";
		}
		System.out.println(flag);
		return flag;
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	
	public String getActionCommentId() {
		return actionCommentId;
	}
	public void setActionCommentId(String actionCommentId) {
		this.actionCommentId = actionCommentId;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	public CampaignService getCampaignService() {
		return campaignService;
	}
	public void setCampaignService(CampaignService campaignService) {
		this.campaignService = campaignService;
	}
	
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	public Timestamp PublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	
	
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	public Timestamp ModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

public Comment getModel(){
	return comment;
}
	
}
