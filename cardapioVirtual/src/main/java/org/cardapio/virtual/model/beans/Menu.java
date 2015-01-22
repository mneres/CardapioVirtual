package org.cardapio.virtual.model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity @Table(name = "Menu")
public class Menu implements Serializable {
	@Id @SequenceGenerator(name="seq_menu", sequenceName="seq_menu", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_menu") 
	@Column(name="ID_MENU")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="ID_FRANCHISE", nullable=true)
	private Franchise franchise;
	@Column(name="NAME_MENU")
	private String name;
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="MENU_PRODUCT", 
               joinColumns=  @JoinColumn( name = "id_menu"), 
               inverseJoinColumns= @JoinColumn(name = "id_product") )
	private List<Product> product = new ArrayList<Product>();

	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Franchise getFranchise() {
		return franchise;
	}
	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
