package com.prueba.empleados.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Clase entidad que representa un  empleado en la db
 * @author john
 * @version 1.0.0
 */
@Entity
@Table(name = "employees")
@Data
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "paternal_surname")
	private String paternalSurname;

	@Column(name = "maternal_surname")
	private String maternalSurname;

	@Column(name = "age")
	private Integer age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "position")
	private String position;

	
	
}
