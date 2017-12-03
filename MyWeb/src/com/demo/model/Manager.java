package com.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private Integer manageId;
	private String managePsd;
	private String phone;
	private String email;
	private Set campaigns = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** minimal constructor */
	public Manager(Integer manageId) {
		this.manageId = manageId;
	}

	/** full constructor */
	public Manager(Integer manageId, String managePsd, String phone, String email, Set campaigns, Set users) {
		this.manageId = manageId;
		this.managePsd = managePsd;
		this.phone = phone;
		this.email = email;
		this.campaigns = campaigns;
		this.users = users;
	}

	// Property accessors

	public Integer getManageId() {
		return this.manageId;
	}

	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}

	public String getManagePsd() {
		return this.managePsd;
	}

	public void setManagePsd(String managePsd) {
		this.managePsd = managePsd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getCampaigns() {
		return this.campaigns;
	}

	public void setCampaigns(Set campaigns) {
		this.campaigns = campaigns;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}