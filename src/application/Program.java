package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho dos dados: ");
		String strPath = sc.next();

		File path = new File(strPath);

		List<Employee> employees = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				line = br.readLine();
				employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
			}
		} catch (IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}
		
		List<Employee> salaryEmployees = employees.stream().sorted((e1, e2) -> e1.getEmail().compareTo(e2.getEmail())).filter(e -> e.getSalary() > 2000).toList();
		
		System.out.println("Email do empregados que recebem mais de 2000");
	
		salaryEmployees.forEach(e -> System.out.println(e.getEmail()));
		
		sc.close();

	}

}
