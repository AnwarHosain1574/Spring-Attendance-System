package com.csl.bmsri.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "user_login_bk")
public class User {
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE6")
	 @SequenceGenerator(name="SEQUENCE6", sequenceName="login_seq", allocationSize=1)
	 
	 @Column(name = "login_id")
	 private int login_id;
	 
	 @Column(name="emp_name")
	 private String empname;
	 
	 @Column(name="email")
	 private String email;
	 
	 @Column(name="password")
	 private String password;
	 
	 @Column(name="idno")
	 private String idno;
	 
	 @Column(name="active")
	 private int active;
	 
	 @Column(name="role_id")
	 private int role_id;	
	 
	 @Column(name="SS_FACTY_ID")
	 private long ss_facty_id;

	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	 private Set<Role> roles;
	 
	 
	 
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public long getSs_facty_id() {
		return ss_facty_id;
	}

	public void setSs_facty_id(long ss_facty_id) {
		this.ss_facty_id = ss_facty_id;
	}

}
