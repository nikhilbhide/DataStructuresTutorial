package com.nik.tutorial.dsnalgo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>(); 
		employeeList.add(new Employee("Nik", "Bhi", 1450));
		employeeList.add(new Employee("JKL","Yuil",1000));
		employeeList.add(new Employee("JKL12","Yui12l",1003));
		employeeList.add(new Employee("J12KL","Yu1il",1000));
		employeeList.remove(3);

		employeeList.forEach(employee->System.out.println(employee));
		employeeList.set(1, new Employee("OP","HJ",2000));
		//employeeList.forEach(employee->System.out.println(employee));
		//employeeList.forEach(employee->System.out.println(employee));
	}
}
