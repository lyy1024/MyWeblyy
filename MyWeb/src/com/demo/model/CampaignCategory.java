package com.demo.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CampaignCategory entity. @author MyEclipse Persistence Tools
 */

public class CampaignCategory implements java.io.Serializable {

	// Fields

	private Integer catagoryId;
	private String catagoryName;
	private String descr;
	private Timestamp publishTime;
	private String modifier;
	private Timestamp modifyTime;
	private Set campaigns = new HashSet(0);

	// Constructors

	/** default constructor */
	public CampaignCategory() {
	}

	/** minimal constructor */
	public CampaignCategory(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	/** full constructor */
	public CampaignCategory(Integer catagoryId, String catagoryName, String descr, Timestamp publishTime,
			String modifier, Timestamp modifyTime, Set campaigns) {
		this.catagoryId = catagoryId;
		this.catagoryName = catagoryName;
		this.descr = descr;
		this.publishTime = publishTime;
		this.modifier = modifier;
		this.modifyTime = modifyTime;
		this.campaigns = campaigns;
	}

	// Property accessors

	public Integer getCatagoryId() {
		return this.catagoryId;
	}

	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}

	public String getCatagoryName() {
		return this.catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Set getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(Set campaigns) {
		this.campaigns = campaigns;
	}

}