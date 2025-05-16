package com.prueba.empleados.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.empleados.entity.Employee;

/**
 * @author john
 * @version 1.0.0
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
