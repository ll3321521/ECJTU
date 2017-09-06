package com.ll.core.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.core.bean.user.Employee;
import com.ll.core.dao.user.EmployeeDao;
import com.ll.core.query.user.EmployeeQuery;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public void addEmployee(Employee employee){
		employeeDao.addEmployee(employee);
	}

	public Employee getEmployeeById(String id){
		return employeeDao.getEmployeeById(id);
	}
	
	public void delEmployee(String id){
		employeeDao.delEmployee(id);
	}
	
	public void updateEmployee(Employee employee){
		employeeDao.updateEmployee(employee);
	}

	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery){
		return employeeDao.getEmployeeList(employeeQuery);
	}
	
}
