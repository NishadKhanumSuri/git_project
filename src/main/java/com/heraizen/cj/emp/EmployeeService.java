package com.heraizen.cj.emp;

public interface EmployeeService {
	Employee addEmployee(Employee emp);
	Employee[] getEmployee();
	int  deleteEmployee(int empno);
	Employee updateEmployee(Employee e);
	String getEmpByEmpno(int empno);
	public void removeAll();
	public Employee[] getEmpByName(String name);
	}

