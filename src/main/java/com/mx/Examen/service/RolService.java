package com.mx.Examen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Examen.entity.Rol;
import com.mx.Examen.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	
	
	@Transactional(readOnly = true)
	public List<Rol> getAllRoles(){
		return (List<Rol>) rolRepository.findAll(); 
	}
	
	@Transactional(readOnly = true)
	public Rol getRolById(Integer id) {
		return rolRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public Rol getRolByNombre(String nombre) {
		return rolRepository.findByNombre(nombre);
	}
	
	@Transactional
	public String createRol(Rol rol) {
		
		String mensaje = "guardado";
		boolean bandera = false;
		
		String nombreR = rol.getNombre();
		String nombre = "";
		
		for(Rol r: rolRepository.findAll()) {
			if(r.getNombre().equals(nombreR)) {
				bandera = true;
				mensaje = "nombreExiste";
				break;
			}
		}
		
		if(!bandera)
			rolRepository.save(rol);
		
		return mensaje;
		
	}
	
	@Transactional
	public String updateRol(Rol rol) {
		String mensaje = "guardado";
		boolean bandera = false;
		boolean banderaId = false;
		
		String nombreR = rol.getNombre();
		String nombre = "";
		
		for(Rol r: rolRepository.findAll()) {
			if(r.getNombre().equals(nombreR)) {
				bandera = true;
				mensaje = "nombreExiste";
			}
			
			if(r.getId().equals(rol.getId())){
				banderaId = true;
				break;
			}
				
		}
		
		if(!bandera)
			rolRepository.save(rol);
		
		if(!banderaId)
			mensaje = "idNoExiste";
			
		
		return mensaje;
	}
	
	public boolean deleteRol(Integer id) {
		boolean bandera = false;
		
		for(Rol r: rolRepository.findAll()) {
			
			if(r.getId().equals(id)){
				bandera = true;
				break;
			}
				
		}
		
		if(bandera)
			rolRepository.deleteById(id);
		
		return bandera;
	}

}
