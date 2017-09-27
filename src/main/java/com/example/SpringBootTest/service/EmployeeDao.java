package com.example.SpringBootTest.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.example.SpringBootTest.model.Employee;
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long> {

}