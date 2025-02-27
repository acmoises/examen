package com.mx.Examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Examen.entity.Rol;
import com.mx.Examen.service.RolService;


@RestController
@RequestMapping(path = "/api/rol")
@CrossOrigin
public class RolController {
	
	@Autowired
	RolService rolService;
	
	@GetMapping
	public List<Rol> getAllRoles(){
		return rolService.getAllRoles();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getRolById(@PathVariable("id") Integer id){
		
		Rol response = rolService.getRolById(id);
		
		if(response != null)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>("ID no existe", HttpStatus.OK);
		
	}
	
	@GetMapping(path = "nombre/{nombre}")
	public ResponseEntity<?> getRolByNombre(@PathVariable("nombre") String nombre){
		Rol response = rolService.getRolByNombre(nombre);
		
		if(response != null)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>("El nombre no existe", HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createRol(@RequestBody Rol rol ){
		String response = rolService.createRol(rol);
		
		if(response.equals("guardado"))
			return new ResponseEntity<>(rol, HttpStatus.CREATED);
		else
			return new ResponseEntity<>("El nombre ya existe", HttpStatus.OK);
	}

	
	@PutMapping
	public ResponseEntity<?> updateRol(@RequestBody Rol rol ){
		String response = rolService.updateRol(rol);
		
		if(response.equals("guardado"))
			return new ResponseEntity<>(rol, HttpStatus.OK);
		else if(response.equals("idNoExiste"))
			return new ResponseEntity<>("El id no existe", HttpStatus.OK);
		else
			return new ResponseEntity<>("El nombre ya existe", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteRol(@RequestBody Rol rol){
		boolean response = rolService.deleteRol(rol.getId());
		
		if(response)
			return new ResponseEntity<>("Eliminado", HttpStatus.OK);
		else
			return new ResponseEntity<>("El id no existe", HttpStatus.OK);
		
	}
	

}
