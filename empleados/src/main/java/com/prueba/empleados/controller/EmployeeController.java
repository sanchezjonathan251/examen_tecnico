package com.prueba.empleados.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.empleados.exceptions.EmployeeException;
import com.prueba.empleados.record.EmployeeRecord;
import com.prueba.empleados.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/")
@Tag(name = "Empleado API", description = "Operaciones relacionadas con empleados")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("getAll/employee")
	@Operation(summary = "Obtener", description = "Proporciona detalles de los empleados y muestra el token de acceso que viene en el encabezado")
	public ResponseEntity<Object> getAllEmployees(@RequestHeader("Authorization") String authHeader) {
		List<EmployeeRecord> body = null;
		
		try {
			
			log.info("-------- Token en el encabezado    :     {}", authHeader);
			
			body = employeeService.getAllEmployees();
			
			return ResponseEntity.status(HttpStatus.OK.value()).body(body);
			
		} catch (EmployeeException e) {
		
			return ResponseEntity.status(e.getStatus()).header("Message Error", e.getMessage())
                    .build();
		}
	
	}
	
	@PostMapping("register/employees")
	@Operation(summary = "Registro", description = "Permite registrar tanto un objeto empleado como un listado")
	public ResponseEntity<String> registerEmployees(@RequestBody HashMap<String,Object> register){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK.value()).body(employeeService.registerEmployee(register));
			
		} catch (EmployeeException e) {
			log.error("employee");
			 return ResponseEntity.status(e.getStatus())
                     .body(e.getMessage());
		} 
		
	}
	
	@PutMapping("update/employee")
	@Operation(summary = "Actualizacion", description = "Actualiza los campos de empleado")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeRecord register){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK.value()).body(employeeService.updateEmployee(register));
			
		} catch (EmployeeException e) {
			return ResponseEntity.status(e.getStatus()).header("Message Error", e.getMessage())
                    .build();
		} 
		
	}
	
	@DeleteMapping("delete/employee")
	@Operation(summary = "Elimina", description = "Elimina un empleado por su id")
	public ResponseEntity<String> updateEmployee(@RequestParam Integer id){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK.value()).body(employeeService.deleteEmployee(id));
			
		} catch (EmployeeException e) {
			 return ResponseEntity.status(e.getStatus()).header("Message Error", e.getMessage())
                     .build();
		} 
		
	}
	
}
