package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> showAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeeByNo(int no);
	public String modifyEmployeeByNo(Employee emp);
	public String removeEmployeeByNo(int no);
}
