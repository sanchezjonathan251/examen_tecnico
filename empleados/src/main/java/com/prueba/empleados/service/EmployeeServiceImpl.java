package com.prueba.empleados.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.empleados.entity.Employee;
import com.prueba.empleados.exceptions.EmployeeException;
import com.prueba.empleados.mapper.EmployeeMapper;
import com.prueba.empleados.record.EmployeeRecord;
import com.prueba.empleados.repository.EmployeeRepository;
import com.prueba.empleados.utils.MessagesConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author john
 * @version 1.0.0
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@SuppressWarnings("deprecation")
	Locale local = new Locale("es");
	

	/**
	 * @param No parametros
	 * @return Lista de todos los empleados existentes.
	 * @throws Excepcion de empleado
	 *
	 */
	@Override
	public List<EmployeeRecord> getAllEmployees() throws EmployeeException{
		log.debug("---Class : {}--- ---Method : {}---", this.getClass().getName(), "getAllEmployees");

		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		
		if(employees.equals(null) || employees.isEmpty()) {
			log.warn("Table Employee return 0 registers");
			throw new EmployeeException(HttpStatus.NO_CONTENT.value(),messageSource.getMessage(MessagesConstants.NO_EMPLOYEES_FOUND, null, local));
		}
			

		log.info("Employees size : {}", employees.size());
		
		return EmployeeMapper.mapToRecords(employees);
	}


	/**
	 * @param Conjunto de empleados o empleado a ser registrados
	 * @return String con respuesta correcta
	 * @throws Excepcion de empleado
	 */
	@Override
	public String registerEmployee(HashMap<String, Object> employeesRequest) throws EmployeeException{
		log.debug("---Class : {}--- ---Method : {}---", this.getClass().getName(), "registerEmployee");

		List<Employee> employees = new ArrayList<Employee>();
		String response;
		ObjectMapper mapper = new ObjectMapper();
	
		
		if (employeesRequest.containsKey("register")) {
			Object register = employeesRequest.get("register");
				if(register instanceof List<?>) {
					
	
					List<EmployeeRecord> registerAll = mapper.convertValue(
						    register,
						    new TypeReference<List<EmployeeRecord>>() {}
						);
					
					employeeRepository.saveAll(
							EmployeeMapper.mapToEntities(registerAll)
							);
					
				} else if (register instanceof Map<?,?>) {
					
					EmployeeRecord registerRecord = mapper.convertValue(register, EmployeeRecord.class);
					
					employeeRepository.save(EmployeeMapper.mapToEntity(registerRecord));
				} else throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
		}  else {
			throw new EmployeeException(HttpStatus.BAD_REQUEST.value(),messageSource.getMessage(MessagesConstants.REGISTER_ATTRIBUTE_NOT, null, local));
		}
		
		return messageSource.getMessage(MessagesConstants.SUCCESSFULLY_REGISTER, null, local);
	}
	

	/**
	 * @param  Empleado a ser actualizado 
	 * @return String con respuesta correcta
	 * @throws Excepcion de empleado
	 */
	@Override
	public String updateEmployee(EmployeeRecord employeeRecord) throws EmployeeException{
		log.debug("---Class : {}--- ---Method : {}---", this.getClass().getName(), "updateEmployee");

		log.debug("Employee : {}", employeeRecord);
		
		
		
		Optional<Employee> employeeEntity = employeeRepository.findById(employeeRecord.id());
		
		if (employeeEntity.isPresent()) {
			
			Employee employee = employeeEntity.get();
		
			employee.setFirstName(employeeRecord.firstName() != null && employeeRecord.firstName() != "" ?  employeeRecord.firstName() : employee.getFirstName());
			
			
			employee.setMiddleName(
				    employeeRecord.middleName() != null && employeeRecord.middleName() != ""
				        ? employeeRecord.middleName()
				        : employee.getMiddleName()
				);

				employee.setPaternalSurname(
				    employeeRecord.paternalSurname() != null && employeeRecord.paternalSurname() != ""
				        ? employeeRecord.paternalSurname()
				        : employee.getPaternalSurname()
				);

				employee.setMaternalSurname(
				    employeeRecord.maternalSurname() != null && employeeRecord.maternalSurname() != ""
				        ? employeeRecord.maternalSurname()
				        : employee.getMaternalSurname()
				);

				employee.setAge(
				    employeeRecord.age() != null
				        ? employeeRecord.age()
				        : employee.getAge()
				);

				employee.setGender(
				    employeeRecord.gender() != null && employeeRecord.gender() != ""
				        ? employeeRecord.gender()
				        : employee.getGender()
				);

				employee.setBirthday(
				    employeeRecord.birthday() != null && employeeRecord.birthday() != ""
				        ? employeeRecord.birthday()
				        : employee.getBirthday()
				);

				employee.setPosition(
				    employeeRecord.position() != null && employeeRecord.position() != ""
				        ? employeeRecord.position()
				        : employee.getPosition()
				);
			
			employeeRepository.save(employee);
			log.info("Id ({}) was successfully modified", employee.getId());
			
			
		} else {
			log.error("Not found employee with ID : {}", employeeRecord.id());
			throw new EmployeeException(HttpStatus.NOT_MODIFIED.value(), messageSource.getMessage(MessagesConstants.NO_EMPLOYEE_FOUND, null, local));
		}
		
		return messageSource.getMessage(MessagesConstants.SUCCESSFULLY_MODIFIED, null, local);
	}

	/**
	 * @param  Integer con el id del Empleado a ser Eliminado
	 * @return String con respuesta correcta
	 * @throws Excepcion de empleado
	 */
	@Override
	public String deleteEmployee(Integer idEmployee) throws EmployeeException {
		log.debug("---Class : {}--- ---Method : {}---", this.getClass().getName(),"deleteEmployee");

		Optional<Employee> employeeEntity = employeeRepository.findById(idEmployee);
		if (employeeEntity.isPresent()) {
			employeeRepository.delete(employeeEntity.get());
			log.info("Id ({}) was successfully deleted", idEmployee);
		} else {
			log.error("Not found employee with ID : {}", idEmployee);
			throw new EmployeeException(HttpStatus.NOT_MODIFIED.value(), messageSource.getMessage(MessagesConstants.NO_EMPLOYEE_FOUND, null, local));
		}
		
		return messageSource.getMessage(MessagesConstants.SUCCESSFULLY_DELETED, null, local);
	}
	

	
	
	

}
