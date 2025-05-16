package com.prueba.empleados.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.prueba.empleados.entity.Employee;
import com.prueba.empleados.record.EmployeeRecord;


/**
 * Clase de mapeo entre Record y Entity del empleado
 * @author john
 * @version 1.0.0
 */
public class EmployeeMapper {
	
	/**
	 * 
	 * @param employee entity
	 * @return employee convert to record 
	 */
    public static EmployeeRecord mapToRecord(Employee employee) {
        return new EmployeeRecord(
            employee.getId(),
            employee.getFirstName(),
            employee.getMiddleName(),
            employee.getPaternalSurname(),
            employee.getMaternalSurname(),
            employee.getAge(),
            employee.getGender(),
            employee.getBirthday(),
            employee.getPosition()
        );
    }

    /**
     * 
     * @param employees entities
     * @return employees convert to record
     */
    public static List<EmployeeRecord> mapToRecords(List<Employee> employees) {
        return employees.stream()
                        .map(EmployeeMapper::mapToRecord)
                        .collect(Collectors.toList());
    }

    /**
     * 
     * @param employee record
     * @return employee convert to entity
     */
    public static Employee mapToEntity(EmployeeRecord employeeRecord) {
        Employee employee = new Employee();
        employee.setId(employeeRecord.id());
        employee.setFirstName(employeeRecord.firstName());
        employee.setMiddleName(employeeRecord.middleName());
        employee.setPaternalSurname(employeeRecord.paternalSurname());
        employee.setMaternalSurname(employeeRecord.maternalSurname());
        employee.setAge(employeeRecord.age());
        employee.setGender(employeeRecord.gender());
        employee.setBirthday(employeeRecord.birthday());
        employee.setPosition(employeeRecord.position());
        return employee;
    }

    /**
     * 
     * @param employees records
     * @return employees redords convert to entities
     */
    public static List<Employee> mapToEntities(List<EmployeeRecord> employeeRecords) {
        return employeeRecords.stream()
                              .map(EmployeeMapper::mapToEntity)
                              .collect(Collectors.toList());
    }
}
