package com.demo.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Perk entity. @author MyEclipse Persistence Tools
 */

public class Perk implements java.io.Serializable {

	// Fields

	private Integer perkId;
	private Contribution contribution;
	private String perkAmount;
	private String description;
	private Integer numberClaimed;
	private Integer numberAvailiable;
	private Set contributions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Perk() {
	}

	/** minimal constructor */
	public Perk(Integer perkId) {
		this.perkId = perkId;
	}

	/** full constructor */
	public Perk(Integer perkId, Contribution contribution, String perkAmount, String description, Integer numberClaimed,
			Integer numberAvailiable, Set contributions) {
		this.perkId = perkId;
		this.contribution = contribution;
		this.perkAmount = perkAmount;
		this.description = description;
		this.numberClaimed = numberClaimed;
		this.numberAvailiable = numberAvailiable;
		this.contributions = contributions;
	}

	// Property accessors

	public Integer getPerkId() {
		return this.perkId;
	}

	public void setPerkId(Integer perkId) {
		this.perkId = perkId;
	}

	public Contribution getContribution() {
		return this.contribution;
	}

	public void setContribution(Contribution contribution) {
		this.contribution = contribution;
	}

	public String getPerkAmount() {
		return this.perkAmount;
	}

	public void setPerkAmount(String perkAmount) {
		this.perkAmount = perkAmount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberClaimed() {
		return this.numberClaimed;
	}

	public void setNumberClaimed(Integer numberClaimed) {
		this.numberClaimed = numberClaimed;
	}

	public Integer getNumberAvailiable() {
		return this.numberAvailiable;
	}

	public void setNumberAvailiable(Integer numberAvailiable) {
		this.numberAvailiable = numberAvailiable;
	}

	public Set getContributions() {
		return this.contributions;
	}

	public void setContributions(Set contributions) {
		this.contributions = contributions;
	}

}