package org.cardapio.virtual.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity @Table(name = "address")
public class Address implements Serializable{
	@Id @SequenceGenerator(name="seq_address", sequenceName="seq_address", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_address") 
	@Column(name="ID_ADDRESS")
	private Long id;
	private String street;
	private int ad_number;
	private String neighborhood;
	private String code;
	private String city;
			
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getAd_number() {
		return ad_number;
	}
	public void setAd_number(int ad_number) {
		this.ad_number = ad_number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
