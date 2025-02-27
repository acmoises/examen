package com.mx.Examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.mx.Examen.entity.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>, JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);
	
	// Consulta nativa para Oracle con paginación usando ROWNUM
    @Query(value = "SELECT * FROM (SELECT u.*, ROWNUM AS rn FROM tusuario2 u) WHERE rn BETWEEN :start AND :end", nativeQuery = true)
    List<Usuario> findUsuariosWithPagination(@Param("start") int start, @Param("end") int end);
	
}
