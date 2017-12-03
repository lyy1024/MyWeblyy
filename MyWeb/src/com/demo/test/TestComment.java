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
	       //加载applicationContext.xml配置  
	      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml"); 
	      //获取配置中的实例  
	      CommentAction userid =(CommentAction)context.getBean("userid"); 
	      CommentAction comment=new CommentAction();
	      
	       //添加评论测试
	      comment.insert();
			comment.setCommentText("hao");
	      
	       //查找评论测试
	       
			List<Comment> list = commentService.findAll();
     for(Comment com : list){
    	  System.out.println(com.getPublishTime()+" "+com.getCommentId()+" "+com.getCommentText());
      }
	      
	       //根据项目名查找评论
	       
     String C = ((CommentAction) commentAction).searchComment();
     System.out.println(C);	      
	      
	 //      根据主键id删除数据
	       
       userid.delete();                                  
	     //  修改评论信息
       comment.setModifier(modifier);
	     comment.setCommentText("hao1");
	  }
}
