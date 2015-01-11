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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity @Table(name = "company")
public class Franchise implements Serializable {
	@Id @SequenceGenerator(name="seq_franchise", sequenceName="seq_franchise", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_franchise") 
	@Column(name="ID_COMPANY")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = false)
	@JoinColumn(name="ID_COMPANY", nullable=false) 
	private Company company;
	@Column(length=14)
	private double cnpj;
	
}