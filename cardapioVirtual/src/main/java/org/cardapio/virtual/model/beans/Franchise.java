package org.cardapio.virtual.model.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity @Table(name = "franchise", uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
public class Franchise implements Serializable {
	@Id @SequenceGenerator(name="seq_franchise", sequenceName="seq_franchise", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_franchise") 
	@Column(name="ID_FRANCHISE")
	private Long id;
	@ManyToOne
	private Company company;
	@Column(length=14)
	private String cnpj;
	@Column(name="TYPE_FOOD")
	private String typeFood;
	@Column(name="DESCR_BUSINESS")
	private String  descriptionBusiness;
	private String password;
	private double phone;
	@Column(name="second_phone")
	private double secondPhone;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="ID_ADDRESS", nullable=false) 
	private Address address;
	@Column(nullable=false)
	private String email;
	
	public Long getId() {
		return id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	public double getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(double secondPhone) {
		this.secondPhone = secondPhone;
	}
	public String getTypeFood() {
		return typeFood;
	}
	public void setTypeFood(String typeFood) {
		this.typeFood = typeFood;
	}
	public String getDescriptionBusiness() {
		return descriptionBusiness;
	}
	public void setDescriptionBusiness(String descriptionBusiness) {
		this.descriptionBusiness = descriptionBusiness;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}