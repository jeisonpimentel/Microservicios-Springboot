package com.udymicro.examenes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udy.commons.examenes.entity.Examen;
import com.udy.commons.microservicios.controllers.CommonController;
import com.udymicro.examenes.services.impl.ExamenServiceImpl;

@RestController
public class ExamenController extends CommonController<Examen, ExamenServiceImpl> {
	

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Examen> o = service.findById( id );
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDb = o.get();
		examenDb.setNombre( examen.getNombre() );
		
		examenDb.getPreguntas()
				.stream()
				.filter(pdb -> !examen.getPreguntas().contains(pdb))
				.forEach( examenDb::removePregunta);
		
		examenDb.setPreguntas( examen.getPreguntas() );
		
		return ResponseEntity.status( HttpStatus.CREATED ).body( service.save( examenDb ) );
	}
	
	

}
