package com.csl.bmsri.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attn_remarks")
public class Attn_Remarks {
	
	@Id
	@Column(name="attn_rem_id")
	private int rem_id;
	
	@Column(name="remarks")
	private String remarks;

	public int getRem_id() {
		return rem_id;
	}

	public void setRem_id(int rem_id) {
		this.rem_id = rem_id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
