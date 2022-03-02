package com.udymicro.examenes.services;

import com.udy.commons.microservicios.services.CommonService;

import java.util.List;

import com.udy.commons.examenes.entity.Asignatura;
import com.udy.commons.examenes.entity.Examen;

public interface ExamenService extends CommonService<Examen> {
	
	public List<Examen> findByNombre(String termino);
	
	public List<Asignatura> findAllAsignaturas();


}
