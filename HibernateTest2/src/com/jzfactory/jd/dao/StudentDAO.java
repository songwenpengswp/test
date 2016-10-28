package com.jzfactory.jd.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jzfactory.jd.bean.Student;

/**
 	* A data access object (DAO) providing persistence and search support for Student entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.jzfactory.jd.bean.Student
  * @author MyEclipse Persistence Tools 
 */
public class StudentDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String AGE = "age";



    
    public void save(Student transientInstance) {
        log.debug("saving Student instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Student persistentInstance) {
        log.debug("deleting Student instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Student findById( java.lang.Integer id) {
        log.debug("getting Student instance with id: " + id);
        try {
            Student instance = (Student) getSession()
                    .get("com.jzfactory.jd.bean.Student", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Student> findByExample(Student instance) {
        log.debug("finding Student instance by example");
        try {
            List<Student> results = (List<Student>) getSession()
                    .createCriteria("com.jzfactory.jd.bean.Student")
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
      log.debug("finding Student instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Student as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Student> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List<Student> findByAge(Object age
	) {
		return findByProperty(AGE, age
		);
	}
	

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Student merge(Student detachedInstance) {
        log.debug("merging Student instance");
        try {
            Student result = (Student) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Student instance) {
        log.debug("attaching dirty Student instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Student instance) {
        log.debug("attaching clean Student instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public static void main(String[] args) {
		StudentDAO dao=new StudentDAO();
		Student stud=dao.findById(1);
		//System.out.println(stud.getClasz());
		System.out.println(stud.getCourses());
	}
    
     
}