package com.yezza.nadhir.models;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="name is required!")
	@Size(min=2,max=30,message="name must be between 2 and 30")
	private String name;
	
	@NotEmpty(message="Email is required!")
	@Email(message="name must be between 2 and 30")
	private String email;
	
	@NotEmpty(message="password is required!")
	@Size(min=2,max=30,message="name must be between 2 and 30")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm password is required!")
	@Size(min=2,max=30,message="name must be between 2 and 30")
	private String confirm;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();	
	}
	
	//1:M
	@OneToMany(mappedBy = "matchingUser",fetch = FetchType.EAGER)
	private List<Book> matchingUser;
	
	//Constructor
	public User() {}
	
	// getters & setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	public List<Book> getMatchingUser() {
		return matchingUser;
	}
	public void setMatchingUser(List<Book> matchingUser) {
		this.matchingUser = matchingUser;
	}
	
	
}
