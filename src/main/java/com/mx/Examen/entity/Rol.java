package com.mx.Examen.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Usuario> lista = new ArrayList<Usuario>();
	

}
