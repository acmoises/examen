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

/*CREATE TABLE TUSUARIO(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(50) NOT NULL,
A_PATERNO VARCHAR2(50) NOT NULL,
A_MATERNO VARCHAR2(50) NOT NULL,
ID_TROLE NUMBER,
FOREIGN KEY(ID_TROLE) REFERENCES TROLE(ID)
);*/

@Entity
@Table(name = "TUSUARIO2")
@Data
public class Usuario {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOMBRE")
	private String nombre; 
	
	@Column(name = "A_PATERNO")
	private String aPaterno;
	
	@Column(name = "A_MATERNO")
	private String aMaterno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TROLE")
	Rol rol;
	

}
