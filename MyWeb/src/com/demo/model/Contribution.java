package com.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Contribution entity. @author MyEclipse Persistence Tools
 */

public class Contribution implements java.io.Serializable {

	// Fields

	private Integer contributeId;
	private Perk perk;
	private Campaign campaign;
	private String contributeBy;
	private String funderId;
	private String contributionTime;
	private Set perks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Contribution() {
	}

	/** minimal constructor */
	public Contribution(Integer contributeId) {
		this.contributeId = contributeId;
	}

	/** full constructor */
	public Contribution(Integer contributeId, Perk perk, Campaign campaign, String contributeBy, String funderId,
			String contributionTime, Set perks) {
		this.contributeId = contributeId;
		this.perk = perk;
		this.campaign = campaign;
		this.contributeBy = contributeBy;
		this.funderId = funderId;
		this.contributionTime = contributionTime;
		this.perks = perks;
	}

	// Property accessors

	public Integer getContributeId() {
		return this.contributeId;
	}

	public void setContributeId(Integer contributeId) {
		this.contributeId = contributeId;
	}

	public Perk getPerk() {
		return this.perk;
	}

	public void setPerk(Perk perk) {
		this.perk = perk;
	}

	public Campaign getCampaign() {
		return this.campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public String getContributeBy() {
		return this.contributeBy;
	}

	public void setContributeBy(String contributeBy) {
		this.contributeBy = contributeBy;
	}

	public String getFunderId() {
		return this.funderId;
	}

	public void setFunderId(String funderId) {
		this.funderId = funderId;
	}

	public String getContributionTime() {
		return this.contributionTime;
	}

	public void setContributionTime(String contributionTime) {
		this.contributionTime = contributionTime;
	}

	public Set getPerks() {
		return this.perks;
	}

	public void setPerks(Set perks) {
		this.perks = perks;
	}

}