package com.aptech.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="bills")
public class Bills extends AbstractModel{
	@Column(name = "fullname")
	private String fullName;
	@Column(columnDefinition ="TEXT")
	private String address;
	private int phone;
	@Column(columnDefinition ="TEXT")
	private String note;
	private String email;
	private Timestamp date;
	// match product
	@OneToMany(mappedBy = "bills")
	private List<BillDetail> billDetails;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	
}
