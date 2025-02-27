package com.mx.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Examen.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{

	Rol findByNombre(String nombre);
	
}
