package com.aptech.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="role")
public class Role extends AbstractModel{
	
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@ManyToMany(targetEntity = User.class, mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> users;
	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	

}
