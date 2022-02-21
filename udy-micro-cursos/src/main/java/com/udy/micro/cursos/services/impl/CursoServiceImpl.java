package com.udy.micro.cursos.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udy.commons.microservicios.services.impl.CommonServiceImpl;
import com.udy.micro.cursos.entity.Curso;
import com.udy.micro.cursos.repository.CursoRepository;
import com.udy.micro.cursos.services.CursoService;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return this.repository.findCursoByAlumnoId( id );
	}
 
}
