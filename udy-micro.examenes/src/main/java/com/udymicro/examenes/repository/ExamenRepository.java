package com.udymicro.examenes.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.udy.commons.examenes.entity.Examen;

public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long>{
	

	//@Query("SELECT e FROM Examen e WHERE e.nombre %?1%")
	public List<Examen> findByNombreContaining( String nombre );


}
