package com.udy.micro.cursos.services;

import com.udy.commons.microservicios.services.CommonService;
import com.udy.micro.cursos.entity.Curso;

public interface CursoService extends CommonService<Curso> {
	
	public Curso findCursoByAlumnoId( Long id );

}
