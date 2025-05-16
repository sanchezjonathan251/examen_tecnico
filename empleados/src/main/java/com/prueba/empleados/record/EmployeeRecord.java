package com.prueba.empleados.record;

/**
 * @author john
 * @version 1.0.0
 */
public record EmployeeRecord(
		Integer  id,
	    String firstName,
	    String middleName,
	    String paternalSurname,
	    String maternalSurname,
	    Integer age,
	    String gender,
	    String birthday,
	    String position) {

}
