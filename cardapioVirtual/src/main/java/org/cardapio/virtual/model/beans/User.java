package org.cardapio.virtual.model.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name = "users")
public class User implements Serializable{
	@Id @SequenceGenerator(name="seq_users", sequenceName="seq_users", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_users") 
	@Column(name="id_user")
	private Long id;
	private String email;	
	private String name;
	private double phone;
	@Column(name="second_phone")
	private double secondPhone;
	@Temporal(TemporalType.TIMESTAMP) @Column(name="date_birth")
	private Date dateBirth;
	private String cpf;	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="ID_ADDRESS", nullable=false) 
	private Address address;
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
