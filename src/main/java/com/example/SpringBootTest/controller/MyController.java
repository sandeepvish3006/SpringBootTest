package com.example.SpringBootTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringBootTest.model.Employee;
import com.example.SpringBootTest.service.EmployeeDao;

@SuppressWarnings("unused")
@RestController
public class MyController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/hellos")
	public String hello() {

		return "hello";

	}

	/*
	 * method for create record in database
	 * 
	 * @RequestParam eId
	 */
	@RequestMapping("/create")
	public ResponseEntity<Void> createEntry(@RequestBody Employee employee) {

		employeeDao.save(employee);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// method for get one record from database

	@RequestMapping(value = "/employee/{eId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("eId") long eId) {

		System.out.println("Fetching User with id " + eId);
		Employee employee = employeeDao.findOne(eId);
		if (employee == null) {
			System.out.println("Employee with id " + eId + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// method for delete one record from database

	@RequestMapping("/delete")  //?eId=12
	public String delete(@RequestParam Long eId) {
		employeeDao.delete(eId);
		return "Record with Id " + eId + " deleted successfully";
	}

	/*
	 * method for update one record in database
	 * 
	 * @RequestParam eId
	 * 
	 * @RequestBody employee
	 */
	@RequestMapping("/update")
	public String updateRecord(@RequestParam Long eId, @RequestBody Employee employee) {
		Employee employee1 = employeeDao.findOne(eId);
		employee1.setUser(employee.getUser());
		employee1.setPassword(employee.getUser());
		employeeDao.save(employee1);
		return "Information with Id " + eId + " successfully updated";
	}

}
