package EmployeePayrollService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService 
{
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) 
	{
		
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});

		try 
		{
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	public void printData() 
	{
		try
		{
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
				 .forEach(System.out::println);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

	public long countEntries() 
	{
		long entries=0;
		try 
		{
			entries=Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
			System.out.println("Number of entries in file is: "+ entries);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return entries;
	}

	public List<String> readDataFromFile() 
	{
		List<String> employeePayrollList = new ArrayList<String>();
		System.out.println("Employee payroll data:");
		try 
		{
			Files.lines(new File(PAYROLL_FILE_NAME).toPath())
				.map(employeeData -> employeeData.trim())
				.forEach(employeeData -> { 
					System.out.println(employeeData);
					employeePayrollList.add(employeeData);
			});
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return employeePayrollList;
	}
}
