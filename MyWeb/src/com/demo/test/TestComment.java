package com.demo.test;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.deploy.ContextService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.action.CommentAction;
import com.demo.dao.CommentDAO;
import com.demo.model.Comment;
import com.demo.service.CommentService;
public class TestComment {
	public static void main(String[] args, CommentDAO commentService, Object commentAction, String modifier) {  
	       //����applicationContext.xml����  
	      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      //��ȡ�����е�ʵ��  
	      CommentAction userid =(CommentAction)context.getBean("userid"); 
	      CommentAction comment=new CommentAction();
	      
	       //������۲���
	      comment.insert();
			comment.setCommentText("hao");
	      
	       //�������۲���
	       
			List<Comment> list = commentService.findAll();
     for(Comment com : list){
    	  System.out.println(com.getPublishTime()+" "+com.getCommentId()+" "+com.getCommentText());
      }
	      
	       //������Ŀ����������
	       
     String C = ((CommentAction) commentAction).searchComment();
     System.out.println(C);	      
	      
	 //      ��������idɾ������
	       
       userid.delete();                                  
	     //  �޸�������Ϣ
       comment.setModifier(modifier);
	     comment.setCommentText("hao1");
	  }
}
