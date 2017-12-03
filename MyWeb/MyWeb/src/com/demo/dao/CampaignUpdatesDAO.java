package com.demo.dao;
/*import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.model.CampaignUpdates;

/**
 * A data access object (DAO) providing persistence and search support for
 * CampaignUpdates entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.demo.model.CampaignUpdates
 * @author MyEclipse Persistence Tools
 */
public class CampaignUpdatesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CampaignUpdatesDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String IMAGE_URL = "imageUrl";
	public static final String MODIFIER = "modifier";
	public static final String ATTRIBUTE39 = "attribute39";
	public static final String CAMPAIGN_ID ="campaign";
	private static final String MODIFYTIME="modifyTime";
	private static final String PUBLISHTIME="publishTime";
	protected void initDao() {
		// do nothing
	}

	public void save(CampaignUpdates transientInstance) {
		log.debug("saving CampaignUpdates instance");
		Transaction transaction=getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		transaction.commit();
		getSession().flush();
	}

	public void delete(CampaignUpdates persistentInstance) {
		log.debug("deleting CampaignUpdates instance");
		Transaction transaction=getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		transaction.commit();
		getSession().flush();
	}

	public CampaignUpdates findById(java.lang.Integer id) {
		log.debug("getting CampaignUpdates instance with id: " + id);
		try {
			CampaignUpdates instance = (CampaignUpdates) getHibernateTemplate().get("com.demo.model.CampaignUpdates", id);
			getSession().flush();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CampaignUpdates instance) {
		log.debug("finding CampaignUpdates instance by example");
		try {
			List results = getSession().createCriteria("com.demo.model.CampaignUpdates").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CampaignUpdates instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CampaignUpdates as model where model." + propertyName + "= ?";
			Query queryObject=getSession().createQuery(queryString);
			queryObject.setParameter(0,value);
			getSession().flush();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByImageUrl(Object imageUrl) {
		return findByProperty(IMAGE_URL, imageUrl);
	}

	public List findByModifier(Object modifier) {
		return findByProperty(MODIFIER, modifier);
	}

	public List findByAttribute39(Object attribute39) {
		return findByProperty(ATTRIBUTE39, attribute39);
	}
	
	public List findByModifyTime(Object modifyTime) {
		// TODO Auto-generated method stub
		return findByProperty(MODIFYTIME, modifyTime);
	}
	
	public List findByPublishTime(Object publishTime) {
		return findByProperty(PUBLISHTIME, publishTime);
	}
	
	
	public List findByCampaign_id(Object campaign) {
		return findByProperty(CAMPAIGN_ID, campaign);
	}
	
	public List findAll() {
		log.debug("finding all CampaignUpdates instances");
		try {
			String queryString = "from CampaignUpdates";
			Query queryObject = getSession().createQuery(queryString);
            getSession().flush();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CampaignUpdates merge(CampaignUpdates detachedInstance) {
		log.debug("merging CampaignUpdates instance");
		try {
			CampaignUpdates result = (CampaignUpdates) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CampaignUpdates instance) {
		log.debug("attaching dirty CampaignUpdates instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CampaignUpdates instance) {
		log.debug("attaching clean CampaignUpdates instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CampaignUpdatesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CampaignUpdatesDAO) ctx.getBean("CampaignUpdatesDAO");
	}

	

	
}