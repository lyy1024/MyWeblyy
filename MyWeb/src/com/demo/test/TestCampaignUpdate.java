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
	       //加载applicationContext.xml配置  
	      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      //获取配置中的实例  
	      CampaignUpdateAction userid =(CampaignUpdateAction)context.getBean("userid"); 
	      CampaignUpdateAction campaignUpdate=new CampaignUpdateAction();
	      
	       //添加更新
	      campaignUpdate.insert();
	      campaignUpdate.setImageUrl(null);
	      campaignUpdate.setContent("更新");
	      
	       //查找全部更新
	       
			List<CampaignUpdates> list = CampaignUpdateService.findAll();
  for(CampaignUpdates com : list){
 	  System.out.println(com.getModifyTime()+" "+com.getUpdateId()+" "+com.getContent());
   }
	      
	       //根据修改时间/更新时间查找更新
	       
  String C = ((CampaignUpdateAction) campaignUpdateAction).showInfoBymodifyTime();
  System.out.println(C);	      
  String C1 = ((CampaignUpdateAction) campaignUpdateAction).showInfoBypublishTime();
  System.out.println(C1);	   
	 //      根据主键id删除数据
	       
    userid.delete();                                  
	    
    
	  }
}
