package com.mx.Examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Examen.entity.Usuario;
import com.mx.Examen.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getAllUsuarios();
	}
	
	@GetMapping(path = "/page")
	public ResponseEntity<Page<Usuario>> getAllUsuariosPage(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size
	)
	{
		Page<Usuario> response = usuarioService.getAllUsuariosPage(page, size);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable("id") Integer id){
		
		Usuario response = usuarioService.getUsuarioById(id);
		
		if(response != null)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>("ID no existe", HttpStatus.OK);
		
	}
	
	@GetMapping(path = "nombre/{nombre}")
	public ResponseEntity<?> getUsuarioByNombre(@PathVariable("nombre") String nombre){
		Usuario response = usuarioService.getUsuarioByNombre(nombre);
		
		if(response != null)
			return new ResponseEntity<>(response, HttpStatus.OK);
		else
			return new ResponseEntity<>("El nombre no existe", HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createRol(@RequestBody Usuario usuario ){
		String response = usuarioService.createUsuario(usuario);
		
		if(response.equals("guardado"))
			return new ResponseEntity<>(usuario, HttpStatus.CREATED);
		else
			return new ResponseEntity<>("El nombre ya existe", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario ){
		String response = usuarioService.updateUsuario(usuario);
		
		if(response.equals("guardado"))
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		else if(response.equals("idNoExiste"))
			return new ResponseEntity<>("El id no existe", HttpStatus.OK);
		else
			return new ResponseEntity<>("El nombre ya existe", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteRol(@RequestBody Usuario usuario){
		boolean response = usuarioService.deleteUsuario(usuario.getId());
		
		if(response)
			return new ResponseEntity<>("Eliminado", HttpStatus.OK);
		else
			return new ResponseEntity<>("El id no existe", HttpStatus.OK);
		
	}

}
