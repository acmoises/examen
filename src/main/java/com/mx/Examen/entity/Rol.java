package com.mx.Examen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/*CREATE TABLE TROLE(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(50) NOT NULL
);*/

@Entity
@Table(name = "TROLE2")
@Data
public class Rol {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TROLE")
	Usuario usuario;
	

}
