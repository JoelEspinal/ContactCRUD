package com.joelespinal.crud.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contacs")
public class Contact implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "address")
	private String address; // optional
	private Date createAt = new Date();
	@Column(name = "update_at")
	private Date updateAt = new Date();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Number.class)
	@JoinColumn(name = "number_id")
	private Set<Number> numbers = new HashSet<Number>();
	
	public Contact(String name, String lastName){
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	public Contact(String name){
		super();
		this.name = name;
	}
	
	public Contact(){
		
	}
	

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Date getCreateAt() {
		return createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "number_id")
	public Set<Number> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Number> numbers) {
		this.numbers = numbers;
	}
	
	
}
