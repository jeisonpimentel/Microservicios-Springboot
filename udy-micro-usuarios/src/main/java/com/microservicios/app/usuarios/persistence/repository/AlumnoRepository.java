package com.microservicios.app.usuarios.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.udy.commons.alumnos.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {
	
	@Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %?1% or a.apellido LIKE %?1%")
	public List<Alumno> findByNombreOrApellidoLike( String termino );
	

}
