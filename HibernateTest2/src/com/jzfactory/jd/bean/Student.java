package com.jzfactory.jd.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="student"
    ,catalog="school_hibernate"
)

public class Student  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Clasz clasz;
     private String name;
     private Integer age;
     private Set<Score> scores = new HashSet<Score>(0);
     
     private Set<Course>courses=new HashSet<Course>(0);


    // Constructors

    /** default constructor */
    public Student() {
    }

    
    /** full constructor */
    public Student(Clasz clasz, String name, Integer age, Set<Score> scores) {
        this.clasz = clasz;
        this.name = name;
        this.age = age;
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
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="clasz_id")

    public Clasz getClasz() {
        return this.clasz;
    }
    
    public void setClasz(Clasz clasz) {
        this.clasz = clasz;
    }
    
    @Column(name="name", length=10)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="age")

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="student")

    public Set<Score> getScores() {
        return this.scores;
    }
    
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    @ManyToMany  
	@JoinTable(name = "score", 
	           joinColumns = @JoinColumn(name = "student_id"), 
	           inverseJoinColumns = @JoinColumn(name = "course_id"))
	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
   


}