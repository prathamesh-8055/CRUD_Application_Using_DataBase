package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public List<Employee> showAllEmployees() {
		//use DAO
		List<Employee> list=empDAO.getAllEmployees();
		return list;
	}//method

	@Override
	public String registerEmployee(Employee emp) {
		int count = empDAO.insertEmployee(emp);
		return count==0?"Employee not Registered":"Employee Registered";
	}

	@Override
	public Employee fetchEmployeeByNo(int no) {
		//use DAO
		Employee emp = empDAO.getEmployeeByNo(no);
		return emp;
	}

	
	@Override
	public String modifyEmployeeByNo(Employee emp) {
		//use DAO
		int count = empDAO.updateEmployee(emp);
		return count==0?"Employee not found for updation":"Employee found and updated";
	}

	@Override
	public String removeEmployeeByNo(int no) {
		int count = empDAO.deleteEmployeeByNo(no);
		return count==0?"Employee not found for Deletion":"Employee found and deleted";
	}

}//class
