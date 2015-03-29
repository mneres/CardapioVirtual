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
import javax.persistence.UniqueConstraint;

@Entity @Table(name = "Evaluation_Product", uniqueConstraints=@UniqueConstraint(columnNames={"id_user","ID_PRODUCT"}))
public class EvaluationProduct implements Serializable{
	
	@Id @SequenceGenerator(name="seq_eval_prod", sequenceName="seq_eval_prod", allocationSize=1) 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_eval_prod") 
	@Column(name="id_eval_prod")
	private Long id;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="ID_PRODUCT", nullable=false) 
	private Product prod;
	@Column(name="comment_prod")
	private String comment;
	private int evaluation;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="id_user", nullable=false) 
	private User user;
	@Temporal(TemporalType.DATE) @Column(name="date_eval")
	private Date data;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
