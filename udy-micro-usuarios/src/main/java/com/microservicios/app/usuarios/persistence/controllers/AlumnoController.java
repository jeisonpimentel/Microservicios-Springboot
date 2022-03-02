package com.microservicios.app.usuarios.persistence.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.microservicios.app.usuarios.persistence.services.AlumnoService;
import com.udy.commons.alumnos.entity.Alumno;
import com.udy.commons.microservicios.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService>{
	

	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id){
		
		if( result.hasErrors()) {
			return validar( result );
		}
		
		Optional<Alumno> o = service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDB = o.get();
		
		//Actualizamos el alumno
		alumnoDB.setNombre( alumno.getNombre() );
		alumnoDB.setApellido( alumno.getApellido() );
		alumnoDB.setEmail( alumno.getEmail() );
		alumnoDB.setCreateAt( alumno.getCreateAt() );
		
		return ResponseEntity.status( HttpStatus.CREATED).body(service.save( alumnoDB ) );
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrarByTerm(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellidoLike(term));
	}

}
