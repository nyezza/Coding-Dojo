package com.yezza.nadhir.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=2,max=255)
	private String firstName;
	@NotEmpty
	@Size(min=2,max=255)
	private String lastName;
	@NotNull
	@Min(10)
	@Max(100)
	private int age;
	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	
	//M:1
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojos_id")
	private Dojo matchingDojo;
	
	//Constructor
	public Ninja() {
	}
	
	// Getter & Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Dojo getMatchingDojo() {
		return matchingDojo;
	}
	public void setMatchingDojo(Dojo matchingDojo) {
		this.matchingDojo = matchingDojo;
	}
	
	
}
