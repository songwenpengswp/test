package com.jzfactory.jd.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="course"
    ,catalog="school_hibernate"
)

public class Course  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer credit;
     private Set<Score> scores = new HashSet<Score>(0);
     
     private Set<Student> students=new HashSet<Student>(0);


    // Constructors

    /** default constructor */
    public Course() {
    }

    
    /** full constructor */
    public Course(String name, Integer credit, Set<Score> scores) {
        this.name = name;
        this.credit = credit;
        this.scores = scores;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="name", length=10)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="credit")

    public Integer getCredit() {
        return this.credit;
    }
    
    public void setCredit(Integer credit) {
        this.credit = credit;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="course")

    public Set<Score> getScores() {
        return this.scores;
    }
    
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    @ManyToMany(mappedBy = "courses")
	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}
   








}