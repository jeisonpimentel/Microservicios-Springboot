package com.udy.micro.cursos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.udy.commons.alumnos.entity.Alumno;
import com.udy.commons.examenes.entity.Examen;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date 	createAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Examen> examenes;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Curso() {
		this.alumnos = new ArrayList<Alumno>();
	}

	/**
	 * @getters
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @setters
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @getters
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @setters
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @getters
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @setters
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/**
	 * @getters
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	/**
	 * @setters
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	/**
	 * Method for add Alumno
	 * @param alumno
	 */
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	/**
	 * Method for remove Alumno
	 * @param alumno
	 */
	public void removeAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}
	
	/**
	 * @getters
	 */
	public List<Examen> getExamenes() {
		return examenes;
	}

	/**
	 * @setters
	 */
	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	
	/**
	 * Method for add Examen
	 * @param examen
	 */
	public void addExamen(Examen examen) {
		this.examenes.add(examen);
	}
	
	/**
	 * Method for remove Examen
	 * @param examen
	 */
	public void removeExamen(Examen examen) {
		this.examenes.remove(examen);
	}

}
