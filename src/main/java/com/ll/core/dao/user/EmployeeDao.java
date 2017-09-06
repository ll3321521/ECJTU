package com.ll.core.dao.user;

import java.util.List;

import com.ll.core.bean.user.Employee;
import com.ll.core.query.user.EmployeeQuery;


public interface EmployeeDao {

	public void addEmployee(Employee employee);

	public Employee getEmployeeById(String id);

	public List<Employee> getEmployeesByKeys(List<String> idList);

	public void delEmployee(String id);

	public void deleteByKeys(List<String> idList);

	public void updateEmployee(Employee employee);

	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery);

}
