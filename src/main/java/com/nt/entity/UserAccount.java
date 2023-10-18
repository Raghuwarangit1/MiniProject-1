package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity

@Table(name="USER_ACCOUNT")
//@SQLDelete(sql="UPDATE USER_ACCOUNT SET USER_STATUS='INACTIVE' WHERE USER_ID=?")
//@Where(clause ="USER_STATUS <> 'INACTIVE'")
@Data
@RequiredArgsConstructor
public class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
private Integer id;
	@Column(name="USER_NAME")
	
private String name;
	@Column(name="MAIL-ID")
	
private String email;
	@Column(name="USER_PHNO")

private Long phNo;
	@Column(name="GENDER")

private String gender;
	@Column(name="USER_DOB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate dob;
	@Column(name="USER_STATUS")
	
private String status="active";
	@CreationTimestamp
	@Column(name="DATE_OF_CREATED" ,updatable =false)//this data no one should modify thats why updatable =false
	

private LocalDateTime createdTime;
	@UpdateTimestamp
	@Column(name="LAST-UPDATE")//this data no one should insert it should come automatically thats why insertable =false
	private LocalDateTime lastUpDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhNo() {
		return phNo;
	}
	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public LocalDateTime getLastUpDate() {
		return lastUpDate;
	}
	public void setLastUpDate(LocalDateTime lastUpDate) {
		this.lastUpDate = lastUpDate;
	}

}
