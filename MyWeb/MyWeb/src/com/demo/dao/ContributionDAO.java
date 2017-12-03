package com.demo.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.demo.model.Contribution;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contribution entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.demo.model.Contribution
 * @author MyEclipse Persistence Tools
 */
public class ContributionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ContributionDAO.class);
	// property constants
	public static final String CONTRIBUTE_BY = "contributeBy";
	public static final String FUNDER_ID = "funderId";
	public static final String CONTRIBUTION_TIME = "contributionTime";

	protected void initDao() {
		// do nothing
	}

	public void save(Contribution transientInstance) {
		log.debug("saving Contribution instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Contribution persistentInstance) {
		log.debug("deleting Contribution instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contribution findById(java.lang.Integer id) {
		log.debug("getting Contribution instance with id: " + id);
		try {
			Contribution instance = (Contribution) getHibernateTemplate().get("com.xxxxxx.Contribution", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contribution instance) {
		log.debug("finding Contribution instance by example");
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
		log.debug("finding Contribution instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Contribution as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContributeBy(Object contributeBy) {
		return findByProperty(CONTRIBUTE_BY, contributeBy);
	}

	public List findByFunderId(Object funderId) {
		return findByProperty(FUNDER_ID, funderId);
	}

	public List findByContributionTime(Object contributionTime) {
		return findByProperty(CONTRIBUTION_TIME, contributionTime);
	}

	public List findAll() {
		log.debug("finding all Contribution instances");
		try {
			String queryString = "from Contribution";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Contribution merge(Contribution detachedInstance) {
		log.debug("merging Contribution instance");
		try {
			Contribution result = (Contribution) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contribution instance) {
		log.debug("attaching dirty Contribution instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contribution instance) {
		log.debug("attaching clean Contribution instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ContributionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ContributionDAO) ctx.getBean("ContributionDAO");
	}
}