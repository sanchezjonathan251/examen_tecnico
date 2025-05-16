package com.prueba.empleados.exceptions;

import lombok.Getter;
import lombok.Setter;


/**
 * Excepciones de logica sobre el empleado
 * @author john
 * @version 1.0.0
 */
public class EmployeeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private int status;
	
	public EmployeeException() {
		super();
	}
	public EmployeeException(String message, Throwable cause) {
		super(message, cause);	
	}
	public EmployeeException(int status, String message) {
		super(message);
		this.status = status;
	}	

}
