package com.heraizen.cj.emp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpTest {

		static Employee obj;
		static EmployeeImpl emp;
		static GenerateId genEmp;
		@BeforeEach
		public  void objCre()
		{
			obj=new Employee();
			emp=EmployeeImpl.getInstance();
		}
		@AfterEach
		public void destory()
		{
			emp.removeAll();
			GenerateId.empNo=1;
		}
		@BeforeEach
		public void add()
		{
			Employee obj1=new Employee();
			obj1.setSalary(67000);
			obj1.setEname("Virat");
			obj1.setEmpno(GenerateId.generateEmpno());
			 emp.addEmployee(obj1);
			
			Employee obj2=new Employee();
			obj2.setSalary(67000);
			obj2.setEname("Dhoni");
			obj2.setEmpno(GenerateId.generateEmpno());
			 emp.addEmployee(obj2);
			
			Employee obj3=new Employee();
			obj3.setSalary(67000);
			obj3.setEname("Rohit");
			obj3.setEmpno(GenerateId.generateEmpno());
			emp.addEmployee(obj3);
		}
		@Test
		public void addEmployeeTest()
		{
			obj.setSalary(67000);
			obj.setEname("Pravas");
			obj.setEmpno(GenerateId.generateEmpno());
			assertEquals(obj.toString(), emp.addEmployee(obj).toString());
		}
		@Test
		private void getEmpByNameTest() {
			assertEquals(1,emp.getEmpByName("pravas").length);

		}
		@Test
		public void GetEmployeeTest()
		{		
			obj.setSalary(67000);
			obj.setEname("Pravas");
			obj.setEmpno(GenerateId.generateEmpno());
			assertEquals(obj.toString(), emp.addEmployee(obj).toString());
			assertEquals(4,emp.getEmployee().length);
		}
		@Test
		public void deleteTest()
		{
			assertEquals(2,emp.deleteEmployee(2));
		}
		@Test
		public void getEmpTestByEmpno()
		{
			assertEquals("Dhoni",emp.getEmpByEmpno(2));
		}
		@Test
		public void updateEmpTest()
		{
			obj.setSalary(66000);
			obj.setEname("Pravas");
			obj.setEmpno(2);
			assertEquals(obj.toString(),emp.updateEmployee(obj).toString());
		}
	}

