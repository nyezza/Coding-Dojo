package com.yezza.nadhir.models;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {

		// Member variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3,max=100,message="name must have at least 3 character")
	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date upDated;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt= new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.upDated = new Date();
	}
	
	//1/M
	@OneToMany(mappedBy = "matchingDojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjasList;

	
	//Constructor
	public Dojo() {
	}
	
	// Getter & Setter
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpDated() {
		return upDated;
	}
	public void setUpDated(Date upDated) {
		this.upDated = upDated;
	}
	public List<Ninja> getNinjasList() {
		return ninjasList;
	}
	public void setNinjasList(List<Ninja> ninjasList) {
		this.ninjasList = ninjasList;
	}
	
	
	
}
