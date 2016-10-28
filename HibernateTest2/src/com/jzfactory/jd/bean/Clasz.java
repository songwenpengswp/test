package com.jzfactory.jd.bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Clasz entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="clasz"
    ,catalog="school_hibernate"
, uniqueConstraints = @UniqueConstraint(columnNames="master_id")
)

public class Clasz  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Master master;
     private String name;
     private String local;
     private Set<Student> students = new HashSet<Student>(0);


    // Constructors

    /** default constructor */
    public Clasz() {
    }

    
    /** full constructor */
    public Clasz(Master master, String name, String local, Set<Student> students) {
        this.master = master;
        this.name = name;
        this.local = local;
        this.students = students;
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
	@OneToOne(fetch=FetchType.LAZY)

    public Master getMaster() {
        return this.master;
    }
    
    public void setMaster(Master master) {
        this.master = master;
    }
    
    @Column(name="name", length=10)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="local", length=30)

    public String getLocal() {
        return this.local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="clasz")

    public Set<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
   








}