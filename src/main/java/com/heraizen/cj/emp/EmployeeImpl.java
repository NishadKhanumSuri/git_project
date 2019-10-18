package com.heraizen.cj.emp;

public class EmployeeImpl implements EmployeeService {
	
	static EmployeeImpl empImpl;
	int count = 0;
	private EmployeeImpl() {

	}
	
	public static EmployeeImpl getInstance() {
			if (empImpl == null) {
				empImpl = new EmployeeImpl();
			}
		return empImpl;
	}
	
	
	Employee[] employees = new Employee[1];

	@Override
	public Employee addEmployee(Employee emp) {

		if(employees.length==count)
		{
			Employee[] temp = new Employee[employees.length+1];
			System.arraycopy(employees, 0, temp, 0, employees.length);
			employees=temp;
		}
		
		employees[count++] = emp;
		
		return employees[count-1];
	}

	@Override
	public Employee[] getEmployee() {
		Employee temp[]=new Employee[count];
		System.arraycopy(employees, 0, temp, 0, temp.length);
		return temp;
	}

	@Override
	public int deleteEmployee(int empno) {
	
		Employee[] temp = new Employee[employees.length-1];
		int cp=0;
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i].getEmpno()==empno)
			{
				cp=i;
			}
		}
		for(int i=0;i<employees.length;i++)
		{
			int j=0;
			if(i==cp)
			{
				continue;
			}
			else
			{
				temp[j++]=employees[i];
			}
		}
		
		employees=temp;
		
		return temp.length;
		
		
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee a=new Employee();
		int j=-1;
		for( int i=0;i<employees.length;i++)
		{
			if(employees[i].getEmpno()==e.getEmpno())
			{
				a.setEmpno(e.getEmpno());
				a.setEname(e.getEname());
				a.setSalary(e.getSalary());
				employees[i]=a;
				j=i;
				break;
			}
		}
		return j!=-1?employees[j]:null;
	}

	@Override
	public String getEmpByEmpno(int empno) {
		Employee getEmp=null;
		for(Employee e:employees)
		{
			if(e.getEmpno()==empno)
			{
				getEmp=e;
				break;
			}
		}
		return getEmp.getEname();
	}
	
	@Override
	public void removeAll() {
		employees=new Employee[0];
		count=0;
	}

	@Override
	public Employee[] getEmpByName(String name) {
		Employee getEmp[]=new Employee[1];
		int i=0;
		for(Employee e:employees)
		{
			if(e.getEname().equalsIgnoreCase(name))
			{
				getEmp[i++]=e;
			}
		}
		return getEmp;
	}
}
