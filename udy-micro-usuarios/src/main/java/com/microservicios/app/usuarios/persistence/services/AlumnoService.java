package com.microservicios.app.usuarios.persistence.services;

import java.util.List;

import com.udy.commons.alumnos.entity.Alumno;
import com.udy.commons.microservicios.services.CommonService;

public interface AlumnoService extends CommonService<Alumno>{
	
	public List<Alumno> findByNombreOrApellidoLike( String termino );

}
