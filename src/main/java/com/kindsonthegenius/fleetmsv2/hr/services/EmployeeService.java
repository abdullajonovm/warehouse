package com.kindsonthegenius.fleetmsv2.hr.services;

import com.kindsonthegenius.fleetmsv2.hr.models.Employee;
import com.kindsonthegenius.fleetmsv2.hr.repositories.EmployeeRepository;
import com.kindsonthegenius.fleetmsv2.reports.model.Truck;
import com.kindsonthegenius.fleetmsv2.reports.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
		
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TruckRepository truckRepository;
	
	//Get All Employees
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}	
	
	//Get Employee By Id
	public Employee findById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}	
	
	//Delete Employee
	public void delete(int id) {
		Truck truck = truckRepository.findFirstByOrderByIdDesc();
		truck.setEmployeeCount(truck.getEmployeeCount()-1);
		truckRepository.save(truck);

		employeeRepository.deleteById(id);
	}
	
	//Update Employee
	public void save( Employee employee) {

		Truck truck = truckRepository.findFirstByOrderByIdDesc();
		truck.setEmployeeCount(truck.getEmployeeCount()+1);
		truckRepository.save(truck);
		employeeRepository.save(employee);
	}
	
	//Get Employee by username
	public Employee findByUsername(String un) {
		return employeeRepository.findByUsername(un);
	}

	//Get employee by Keyword
	public List<Employee> findByKeyword(String keyword) {
		return employeeRepository.findByKeyword(keyword);
	}


}
