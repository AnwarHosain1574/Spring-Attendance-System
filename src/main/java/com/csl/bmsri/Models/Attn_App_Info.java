package com.csl.bmsri.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="attn_app_info")
public class Attn_App_Info {

	@Id
	@Column(name="attn_app_id")
	private int attn_app_id;
	
	@Column(name="idno")
	private String idno;
	
	@Column(name="att_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MMM-dd")
	private Date date;
	
	@Column(name="att_time")
	private String time;
	
	@Column(name="ATTN_REM_ID")
	private int attnremid;
	
	
	@Column(name="narration")
	private String narration;
	
	@Column(name="attn_status")
	private String attn_status;
	
	public String getAttn_status() {
		return attn_status;
	}

	public void setAttn_status(String attn_status) {
		this.attn_status = attn_status;
	}

	public int getAttn_app_id() {
		return attn_app_id;
	}

	public void setAttn_app_id(int attn_app_id) {
		this.attn_app_id = attn_app_id;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public int getAttnremid() {
		return attnremid;
	}

	public void setAttnremid(int attnremid) {
		this.attnremid = attnremid;
	}
	
}