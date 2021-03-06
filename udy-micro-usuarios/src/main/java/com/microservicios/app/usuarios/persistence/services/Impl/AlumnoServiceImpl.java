package com.microservicios.app.usuarios.persistence.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udy.commons.alumnos.entity.Alumno;
import com.microservicios.app.usuarios.persistence.repository.AlumnoRepository;
import com.microservicios.app.usuarios.persistence.services.AlumnoService;
import com.udy.commons.microservicios.services.impl.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellidoLike(String termino) {
		return repository.findByNombreOrApellidoLike(termino);
	}

}
