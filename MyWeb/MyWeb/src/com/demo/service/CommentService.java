package com.demo.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.demo.model.Campaign;

import com.demo.model.Comment;



import com.demo.dao.CommentDAO;
public class CommentService {

	public CommentService() {
		// TODO Auto-generated constructor stub
	}
	private  CommentDAO commentDAO=new CommentDAO();
	
	
	public List<Comment> findByCampaingId(Object campaign){
		List<Comment> results=commentDAO.findByProperty("campaign_id",campaign);
		return results;
	}
	
	public void deleteById(Comment comment){
		commentDAO.delete(comment);
	}
	
	public void insert(Comment comment){
		System.out.println("beforeSave");
		commentDAO.save(comment);
		System.out.println("save");
	}
	
	public void delete(Comment comment)
	{
		commentDAO.delete(comment);
	}
	
	public Comment findById(Integer id)
	{
		return commentDAO.findById(id);
	}
	public ArrayList<Comment> findAll()
	{
		ArrayList<Comment> commentList=new ArrayList<Comment>();
		List sl=commentDAO.findAll();
		Iterator ite=sl.iterator();
		while(ite.hasNext())
		{
			Comment comment=(Comment)ite.next();
			commentList.add(comment);
		}
		return commentList;
	}
	
	
	
}
