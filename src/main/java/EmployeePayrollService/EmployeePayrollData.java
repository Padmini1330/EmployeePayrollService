package EmployeePayrollService;

public class EmployeePayrollData 
{
	public int id;
	public String name;
	public double salary;
	
	public EmployeePayrollData(int id, String name, double salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	public double getSalary() 
	{
		return salary;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setSalary(double salary) 
	{
		this.salary = salary;
	}

	@Override
	public String toString() 
	{
		return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
