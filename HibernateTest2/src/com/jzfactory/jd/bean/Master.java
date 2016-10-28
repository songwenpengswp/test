package com.jzfactory.jd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Master entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="master"
    ,catalog="school_hibernate"
)

public class Master  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer sex;
     private Clasz clasz;


    // Constructors

    /** default constructor */
    public Master() {
    }

    
    /** full constructor */
    public Master(String name, Integer sex, Clasz clasz) {
        this.name = name;
        this.sex = sex;
        this.clasz = clasz;
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
    
    @Column(name="sex")

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
	@OneToOne(fetch=FetchType.LAZY, mappedBy="master")

    public Clasz getClasz() {
        return this.clasz;
    }
    
    public void setClasz(Clasz clasz) {
        this.clasz = clasz;
    }
   








}