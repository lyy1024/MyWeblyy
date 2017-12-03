package com.demo.action;
import java.io.Serializable;

public class ShowInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String campaignCategory;
	
	public void print()
	{
		System.out.println(campaignCategory+" "+title);
	}
	public ShowInfo(String title, String campaignCategory)
	{
		this.title=title;
		this.campaignCategory=campaignCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getcampaignCategory() {
		return campaignCategory;
	}

	public void setcampaignCategory(String campaignCategory) {
		this.campaignCategory = campaignCategory;
	}
	
}