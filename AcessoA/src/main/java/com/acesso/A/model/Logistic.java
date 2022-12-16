package com.acesso.A.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "logistics")
@Getter @Setter
@NoArgsConstructor
public class Logistic {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	@OneToMany
	@JoinColumn(name="logistic_id")
	private List<Op> operation;

	}
	
