package EmployeePayrollService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService 
{
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	private List<EmployeePayrollData> employeePayrollList;
	
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) 
	{
		this.employeePayrollList=employeePayrollList;
	}
	public static void main(String[] args) 
	{
		System.out.println("***Welcome to Employee Payroll Service***");
		ArrayList<EmployeePayrollData> employeePayrollList=new ArrayList<>();
		EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeePayrollList);
		Scanner scanner=new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(scanner);
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
	}
	public void writeEmployeePayrollData(IOService ioService) 
	{
		if(ioService.equals(IOService.CONSOLE_IO))
			System.out.println("Employee Payroll Details: "+ employeePayrollList);
		else if(ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
			
	}
	public void readEmployeePayrollData(Scanner scanner) 
	{
		System.out.println("Enter Employee ID:");
		int id=scanner.nextInt();
		System.out.println("Enter Employee Name:");
		String name=scanner.next();
		System.out.println("Enter Employee Salary:");
		double salary=scanner.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

}
