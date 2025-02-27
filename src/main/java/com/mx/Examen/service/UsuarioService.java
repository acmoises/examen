package com.mx.Examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Examen.entity.Usuario;
import com.mx.Examen.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	public List<Usuario> getAllUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll(); 
	}
	
	@Transactional(readOnly = true)
	public Page<Usuario> getAllUsuariosPage(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return usuarioRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Usuario getUsuarioById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public Usuario getUsuarioByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}
	
	@Transactional
	public String createUsuario(Usuario usuario) {
		
		String mensaje = "guardado";
		boolean bandera = false;
		
		String nombreR = usuario.getNombre();
		String nombre = "";
		
		for(Usuario u: usuarioRepository.findAll()) {
			if(u.getNombre().equals(nombreR)) {
				bandera = true;
				mensaje = "nombreExiste";
				break;
			}
		}
		
		if(!bandera)
			usuarioRepository.save(usuario);
		
		return mensaje;
		
	}
	
	@Transactional
	public String updateUsuario(Usuario usuario) {
		String mensaje = "guardado";
		boolean bandera = false;
		boolean banderaId = false;
		
		String nombreR = usuario.getNombre();
		String nombre = "";
		
		for(Usuario u: usuarioRepository.findAll()) {
			if(u.getNombre().equals(nombreR)) {
				bandera = true;
				mensaje = "nombreExiste";
			}
			
			if(u.getId().equals(usuario.getId())){
				banderaId = true;
				break;
			}
				
		}
		
		if(!bandera)
			usuarioRepository.save(usuario);
		
		if(!banderaId)
			mensaje = "idNoExiste";
			
		
		return mensaje;
	}
	
	public boolean deleteUsuario(Integer id) {
		boolean bandera = false;
		
		for(Usuario u: usuarioRepository.findAll()) {
			
			if(u.getId().equals(id)){
				bandera = true;
				break;
			}
				
		}
		
		if(bandera)
			usuarioRepository.deleteById(id);
		
		return bandera;
	}
	
}
