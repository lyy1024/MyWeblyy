package com.demo.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.model.Campaign;

/**
 * A data access object (DAO) providing persistence and search support for
 * Campaign entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.demo.model.Campaign
 * @author MyEclipse Persistence Tools
 */
public class CampaignDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CampaignDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String TITLE_URL = "titleUrl";
	public static final String DESCRIP_URL = "descripUrl";
	public static final String STATUS = "status";
	public static final String FUND_GOAL = "fundGoal";
	public static final String FUND_COLLECTED = "fundCollected";
	public static final String DONE_PERCENT = "donePercent";
	public static final String FUNDING_DAYS = "fundingDays";
	public static final String FUNDING_TYPE = "fundingType";
	public static final String CATEGORY_ID = "categoryId";
	public static final String CATEGORY_NAME = "categoryName";
	public static final String SUPPORT_AMOUNT = "supportAmount";
	public static final String IS_PASSED = "isPassed";

	protected void initDao() {
		// do nothing
	}

	public void save(Campaign transientInstance) {
		log.debug("saving Campaign instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Campaign persistentInstance) {
		log.debug("deleting Campaign instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Campaign findById(java.lang.Integer id) {
		log.debug("getting Campaign instance with id: " + id);
		try {
			Campaign instance = (Campaign) getHibernateTemplate().get("com.xxxxxx.Campaign", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Campaign instance) {
		log.debug("finding Campaign instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Campaign instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Campaign as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public  List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByTitleUrl(Object titleUrl) {
		return findByProperty(TITLE_URL, titleUrl);
	}

	public List findByDescripUrl(Object descripUrl) {
		return findByProperty(DESCRIP_URL, descripUrl);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByFundGoal(Object fundGoal) {
		return findByProperty(FUND_GOAL, fundGoal);
	}

	public List findByFundCollected(Object fundCollected) {
		return findByProperty(FUND_COLLECTED, fundCollected);
	}

	public List findByDonePercent(Object donePercent) {
		return findByProperty(DONE_PERCENT, donePercent);
	}

	public List findByFundingDays(Object fundingDays) {
		return findByProperty(FUNDING_DAYS, fundingDays);
	}

	public List findByFundingType(Object fundingType) {
		return findByProperty(FUNDING_TYPE, fundingType);
	}

	public List findByCategoryId(Object categoryId) {
		return findByProperty(CATEGORY_ID, categoryId);
	}

	public List findByCategoryName(Object categoryName) {
		return findByProperty(CATEGORY_NAME, categoryName);
	}

	public List findBySupportAmount(Object supportAmount) {
		return findByProperty(SUPPORT_AMOUNT, supportAmount);
	}

	public List findByIsPassed(Object isPassed) {
		return findByProperty(IS_PASSED, isPassed);
	}

	public List findAll() {
		log.debug("finding all Campaign instances");
		try {
			String queryString = "from Campaign";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Campaign merge(Campaign detachedInstance) {
		log.debug("merging Campaign instance");
		try {
			Campaign result = (Campaign) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Campaign instance) {
		log.debug("attaching dirty Campaign instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Campaign instance) {
		log.debug("attaching clean Campaign instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CampaignDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CampaignDAO) ctx.getBean("CampaignDAO");
	}
}