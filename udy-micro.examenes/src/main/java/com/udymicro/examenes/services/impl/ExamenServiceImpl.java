package com.udymicro.examenes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udy.commons.microservicios.services.impl.CommonServiceImpl;
import com.udy.commons.examenes.entity.Asignatura;
import com.udy.commons.examenes.entity.Examen;
import com.udymicro.examenes.repository.AsignaturaRepository;
import com.udymicro.examenes.repository.ExamenRepository;
import com.udymicro.examenes.services.ExamenService;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre( String termino ) {
		return repository.findByNombreContaining( termino );
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

}
