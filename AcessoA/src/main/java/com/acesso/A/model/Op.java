package com.acesso.A.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operations")
@Getter @Setter
@NoArgsConstructor
public class Op {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String placa;
	@ManyToOne
	private Logistic logistic;
	@ManyToOne
	private Client client;
	private int tara;
	private boolean entry;
	private boolean eCopies;
	private int peso;
	private boolean endWO;
	

}
