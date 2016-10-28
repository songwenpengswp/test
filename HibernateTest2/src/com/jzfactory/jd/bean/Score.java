package com.jzfactory.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Score entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="score"
    ,catalog="school_hibernate"
)

public class Score  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Course course;
     private Student student;
     private Integer result;


    // Constructors

    /** default constructor */
    public Score() {
    }

    
    /** full constructor */
    public Score(Course course, Student student, Integer result) {
        this.course = course;
        this.student = student;
        this.result = result;
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
        @JoinColumn(name="course_id")

    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="student_id")

    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Column(name="result")

    public Integer getResult() {
        return this.result;
    }
    
    public void setResult(Integer result) {
        this.result = result;
    }
   








}