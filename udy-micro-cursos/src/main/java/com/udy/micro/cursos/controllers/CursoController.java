package com.udy.micro.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udy.commons.alumnos.entity.Alumno;
import com.udy.commons.microservicios.controllers.CommonController;
import com.udy.micro.cursos.entity.Curso;
import com.udy.micro.cursos.services.CursoService;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Curso curso, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		if(!o.isPresent())
			return ResponseEntity.notFound().build();
		
		Curso cursoDB = o.get();
		cursoDB.setNombre( curso.getNombre() );
		cursoDB.setCreateAt( curso.getCreateAt() );
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		 
		Optional<Curso> o = this.service.findById(id);
		 
		if ( !o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDB = o.get();
		
		alumnos.forEach(a -> {
			cursoDB.addAlumno(a);
		});
		 
		 return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		 
		Optional<Curso> o = this.service.findById(id);
		 
		if ( !o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDB = o.get();
		
		cursoDB.removeAlumno(alumno);
		 
		 return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> getCursoByAlumnoId(@PathVariable Long id){
		Curso curso = this.service.findCursoByAlumnoId(id);
		return ResponseEntity.ok( curso);
	}
	
	
	
	
	
	

}
