package com.prueba.empleados.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.empleados.entity.Employee;
import com.prueba.empleados.exceptions.EmployeeException;
import com.prueba.empleados.record.EmployeeRecord;


public interface EmployeeService {
	
	List<EmployeeRecord> getAllEmployees() throws EmployeeException;
	String registerEmployee(HashMap<String,Object> employees) throws EmployeeException;
	String updateEmployee(EmployeeRecord employee) throws EmployeeException;
    String deleteEmployee(Integer idEmployee) throws EmployeeException;

}
