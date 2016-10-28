package com.jzfactory.jd.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jzfactory.jd.bean.Score;

/**
 	* A data access object (DAO) providing persistence and search support for Score entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.jzfactory.jd.bean.Score
  * @author MyEclipse Persistence Tools 
 */
public class ScoreDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScoreDAO.class);
		//property constants
	public static final String RESULT = "result";



    
    public void save(Score transientInstance) {
        log.debug("saving Score instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Score persistentInstance) {
        log.debug("deleting Score instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Score findById( java.lang.Integer id) {
        log.debug("getting Score instance with id: " + id);
        try {
            Score instance = (Score) getSession()
                    .get("com.jzfacory.jd.bean.Score", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Score> findByExample(Score instance) {
        log.debug("finding Score instance by example");
        try {
            List<Score> results = (List<Score>) getSession()
                    .createCriteria("com.jzfacory.jd.bean.Score")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Score instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Score as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Score> findByResult(Object result
	) {
		return findByProperty(RESULT, result
		);
	}
	

	public List findAll() {
		log.debug("finding all Score instances");
		try {
			String queryString = "from Score";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Score merge(Score detachedInstance) {
        log.debug("merging Score instance");
        try {
            Score result = (Score) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Score instance) {
        log.debug("attaching dirty Score instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Score instance) {
        log.debug("attaching clean Score instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}