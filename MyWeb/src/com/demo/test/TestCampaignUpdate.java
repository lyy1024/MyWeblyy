package com.demo.test;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.deploy.ContextService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.action.CampaignUpdateAction;
import com.demo.action.CommentAction;
import com.demo.dao.CampaignUpdatesDAO;
import com.demo.dao.CommentDAO;
import com.demo.model.CampaignUpdates;
import com.demo.model.Comment;
import com.demo.service.CampaignUpdateService;
public class TestCampaignUpdate {
	public static void main(String[] args,CampaignUpdatesDAO CampaignUpdateService, Object campaignUpdateAction, String modifier) {  
	       //����applicationContext.xml����  
	      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      //��ȡ�����е�ʵ��  
	      CampaignUpdateAction userid =(CampaignUpdateAction)context.getBean("userid"); 
	      CampaignUpdateAction campaignUpdate=new CampaignUpdateAction();
	      
	       //��Ӹ���
	      campaignUpdate.insert();
	      campaignUpdate.setImageUrl(null);
	      campaignUpdate.setContent("����");
	      
	       //����ȫ������
	       
			List<CampaignUpdates> list = CampaignUpdateService.findAll();
  for(CampaignUpdates com : list){
 	  System.out.println(com.getModifyTime()+" "+com.getUpdateId()+" "+com.getContent());
   }
	      
	       //�����޸�ʱ��/����ʱ����Ҹ���
	       
  String C = ((CampaignUpdateAction) campaignUpdateAction).showInfoBymodifyTime();
  System.out.println(C);	      
  String C1 = ((CampaignUpdateAction) campaignUpdateAction).showInfoBypublishTime();
  System.out.println(C1);	   
	 //      ��������idɾ������
	       
    userid.delete();                                  
	    
    
	  }
}
