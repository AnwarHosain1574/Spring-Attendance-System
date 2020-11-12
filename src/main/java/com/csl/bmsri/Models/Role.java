package com.csl.bmsri.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
@SequenceGenerator(name="SEQUENCE1", sequenceName="role_seq", allocationSize=1) 
@Column(name="role_id")
private int id;
 
 @Column(name="role")
 private String role;
 
 private String module;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getRole() {
  return role;
 }

 public void setRole(String role) {
  this.role = role;
 }
 
 public String getModule() {
	 return module;
 }
 public void setModule(String  module) {
	 this.module=module;
 }

}
