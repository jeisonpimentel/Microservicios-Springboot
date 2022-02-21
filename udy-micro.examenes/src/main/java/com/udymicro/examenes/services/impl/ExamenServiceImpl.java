package com.udymicro.examenes.services.impl;

import org.springframework.stereotype.Service;

import com.udy.commons.microservicios.services.impl.CommonServiceImpl;
import com.udy.commons.examenes.entity.Examen;
import com.udymicro.examenes.repository.ExamenRepository;
import com.udymicro.examenes.services.ExamenService;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

}
