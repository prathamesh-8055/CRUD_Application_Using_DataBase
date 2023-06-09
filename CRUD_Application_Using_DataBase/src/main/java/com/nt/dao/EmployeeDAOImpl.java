package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	private JdbcTemplate jt;
	private static final String GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP ORDER BY EMPNO";
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list= jt.query(GET_ALL_EMPS,rs->{
			List<Employee> list1=new ArrayList();
			while(rs.next()) {
				//copy each record of ResultSet object to Model class obj
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				
				//add model class object to List collection
				list1.add(emp);
			}
			return list1;
		});
		return list;
	}//method

	private static final String INSERT_EMP_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO)VALUES(EMP_NO_SEQ.NEXTVAL,?,?,?,?)";
	@Override
	public int insertEmployee(Employee emp) {
		int count=jt.update(INSERT_EMP_QUERY, emp.getEname(),emp.getJob(),emp.getSal(),emp.getDeptno());
		return count;
	}
	
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp=jt.queryForObject(GET_EMP_BY_NO,(rs,rowNum)->{
														Employee e = new Employee();
														e.setEmpno(rs.getInt(1));
														e.setEname(rs.getString(2));
														e.setJob(rs.getString(3));
														e.setSal(rs.getFloat(4));
														e.setDeptno(rs.getInt(5));
														return e;
													},no);
		return emp;
	}
	
	private static final String UPDATE_EMP_BY_NO="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	@Override
	public int updateEmployee(Employee emp) {
		int count=jt.update(UPDATE_EMP_BY_NO, emp.getEname(),emp.getJob(),emp.getSal(),emp.getDeptno(),emp.getEmpno());
		return count;
	}
	
	private static final String DELETE_EMP_BY_NO="DELETE FROM EMP WHERE EMPNO=?";	
	@Override
	public int deleteEmployeeByNo(int no) {
		int count = jt.update(DELETE_EMP_BY_NO, no);
		return count;
	}

}//class
