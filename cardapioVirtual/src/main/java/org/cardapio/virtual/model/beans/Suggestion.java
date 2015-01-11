package org.cardapio.virtual.model.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name = "suggestion")
public class Suggestion implements Serializable{

	@Id @SequenceGenerator(name="seq_suggestion", sequenceName="seq_suggestion", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_suggestion") 
	@Column(name="id_suggestion")
	private Long id;
	private String title;
	private String description;
	@Temporal(TemporalType.TIMESTAMP) @Column(name="sug_date")
	private Date sugDate;
	@Column(name="email_contact")
	private String email;
	
	public Suggestion(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSugDate() {
		return sugDate;
	}

	public void setSugDate(Date sugDate) {
		this.sugDate = sugDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
