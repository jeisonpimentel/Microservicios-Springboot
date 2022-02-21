package com.udymicro.examenes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udy.commons.microservicios.controllers.CommonController;
import com.udymicro.examenes.entity.Examen;
import com.udymicro.examenes.services.ExamenService;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{
	

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		
		Optional<Examen> o = this.service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDB = o.get();
		
		//Actualizar datos del examen
		examenDB.setNombre( examen.getNombre() );
		
		/*
		 * //Creamos una lista con las preguntas eliminadas List<Pregunta> eliminadas =
		 * new ArrayList<>();
		 * 
		 * examenDB.getPreguntas().forEach( pdb -> { if(!examen.getPreguntas().contains(
		 * pdb )) { eliminadas.add( pdb ); } });
		 * 
		 * eliminadas.forEach( p -> { examenDB.removePregunta( p ); });
		 */
		
		examenDB.getPreguntas()
				.stream()
				.filter( pdb -> !examen.getPreguntas().contains( pdb ))
				.forEach(examenDB::removePregunta);
		
		examenDB.setPreguntas( examen.getPreguntas() );
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save( examenDB ));
	}

}
