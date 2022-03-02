package com.udymicro.examenes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udy.commons.examenes.entity.Examen;

public interface ExamenRepository extends CrudRepository<Examen, Long>{
	
	@Query("SELECT e FROM Examen e WHERE e.nombre %?1%")
	public List<Examen> findByNombre(String termino);
	

}
