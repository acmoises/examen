package com.mx.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mx.Examen.entity.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>, JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);
	
}
