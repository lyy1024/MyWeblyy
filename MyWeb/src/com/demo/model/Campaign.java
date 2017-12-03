package com.demo.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Campaign entity. @author MyEclipse Persistence Tools
 */

public class Campaign implements java.io.Serializable {

	// Fields

	private Integer campaignId;
	private CampaignCategory campaignCategory;
	private User user;
	private Manager manager;
	private String title;
	private String titleUrl;
	private String descripUrl;
	private String status;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private Integer fundGoal;
	private Integer fundCollected;
	private String donePercent;
	private Integer fundingDays;
	private String fundingType;
	private Integer categoryId;
	private String categoryName;
	private Integer supportAmount;
	private Boolean isPassed;
	private Set contributions = new HashSet(0);
	private Set campaignUpdateses = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Campaign() {
	}

	/** minimal constructor */
	public Campaign(Integer campaignId) {
		this.campaignId = campaignId;
	}

	/** full constructor */
	public Campaign(Integer campaignId, CampaignCategory campaignCategory, User user, Manager manager, String title,
			String titleUrl, String descripUrl, String status, Timestamp createdTime, Timestamp updatedTime,
			Integer fundGoal, Integer fundCollected, String donePercent, Integer fundingDays, String fundingType,
			Integer categoryId, String categoryName, Integer supportAmount, Boolean isPassed, Set contributions,
			Set campaignUpdateses, Set comments) {
		this.campaignId = campaignId;
		this.campaignCategory = campaignCategory;
		this.user = user;
		this.manager = manager;
		this.title = title;
		this.titleUrl = titleUrl;
		this.descripUrl = descripUrl;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.fundGoal = fundGoal;
		this.fundCollected = fundCollected;
		this.donePercent = donePercent;
		this.fundingDays = fundingDays;
		this.fundingType = fundingType;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.supportAmount = supportAmount;
		this.isPassed = isPassed;
		this.contributions = contributions;
		this.campaignUpdateses = campaignUpdateses;
		this.comments = comments;
	}

	// Property accessors

	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public CampaignCategory getCampaignCategory() {
		return this.campaignCategory;
	}

	public void setCampaignCategory(CampaignCategory campaignCategory) {
		this.campaignCategory = campaignCategory;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleUrl() {
		return this.titleUrl;
	}

	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}

	public String getDescripUrl() {
		return this.descripUrl;
	}

	public void setDescripUrl(String descripUrl) {
		this.descripUrl = descripUrl;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getFundGoal() {
		return this.fundGoal;
	}

	public void setFundGoal(Integer fundGoal) {
		this.fundGoal = fundGoal;
	}

	public Integer getFundCollected() {
		return this.fundCollected;
	}

	public void setFundCollected(Integer fundCollected) {
		this.fundCollected = fundCollected;
	}

	public String getDonePercent() {
		return this.donePercent;
	}

	public void setDonePercent(String donePercent) {
		this.donePercent = donePercent;
	}

	public Integer getFundingDays() {
		return this.fundingDays;
	}

	public void setFundingDays(Integer fundingDays) {
		this.fundingDays = fundingDays;
	}

	public String getFundingType() {
		return this.fundingType;
	}

	public void setFundingType(String fundingType) {
		this.fundingType = fundingType;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getSupportAmount() {
		return this.supportAmount;
	}

	public void setSupportAmount(Integer supportAmount) {
		this.supportAmount = supportAmount;
	}

	public Boolean getIsPassed() {
		return this.isPassed;
	}

	public void setIsPassed(Boolean isPassed) {
		this.isPassed = isPassed;
	}

	public Set getContributions() {
		return this.contributions;
	}

	public void setContributions(Set contributions) {
		this.contributions = contributions;
	}

	public Set getCampaignUpdateses() {
		return this.campaignUpdateses;
	}

	public void setCampaignUpdateses(Set campaignUpdateses) {
		this.campaignUpdateses = campaignUpdateses;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Object getCId() {                           //新加的方法
		// TODO Auto-generated method stub
		return null;
	}

	public Object longValue() {                         //新加的方法
		// TODO Auto-generated method stub
		return null;
	}

	public String getcampaignCategory() {                   //新加的方法
		// TODO Auto-generated method stub
		return null;
	}

	
}