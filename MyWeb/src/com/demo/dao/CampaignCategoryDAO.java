package com.demo.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.model.CampaignCategory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CampaignCategory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.demo.model.CampaignCategory
 * @author MyEclipse Persistence Tools
 */
public class CampaignCategoryDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CampaignCategoryDAO.class);
	// property constants
	public static final String CATAGORY_NAME = "catagoryName";
	public static final String DESCR = "descr";
	public static final String MODIFIER = "modifier";

	protected void initDao() {
		// do nothing
	}

	public void save(CampaignCategory transientInstance) {
		log.debug("saving CampaignCategory instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CampaignCategory persistentInstance) {
		log.debug("deleting CampaignCategory instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CampaignCategory findById(java.lang.Integer id) {
		log.debug("getting CampaignCategory instance with id: " + id);
		try {
			CampaignCategory instance = (CampaignCategory) getHibernateTemplate().get("com.xxxxxx.CampaignCategory",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CampaignCategory instance) {
		log.debug("finding CampaignCategory instance by example");
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
		log.debug("finding CampaignCategory instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CampaignCategory as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCatagoryName(Object catagoryName) {
		return findByProperty(CATAGORY_NAME, catagoryName);
	}

	public List findByDescr(Object descr) {
		return findByProperty(DESCR, descr);
	}

	public List findByModifier(Object modifier) {
		return findByProperty(MODIFIER, modifier);
	}

	public List findAll() {
		log.debug("finding all CampaignCategory instances");
		try {
			String queryString = "from CampaignCategory";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CampaignCategory merge(CampaignCategory detachedInstance) {
		log.debug("merging CampaignCategory instance");
		try {
			CampaignCategory result = (CampaignCategory) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CampaignCategory instance) {
		log.debug("attaching dirty CampaignCategory instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CampaignCategory instance) {
		log.debug("attaching clean CampaignCategory instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CampaignCategoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CampaignCategoryDAO) ctx.getBean("CampaignCategoryDAO");
	}
}