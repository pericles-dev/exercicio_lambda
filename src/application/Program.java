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
			}
		} catch (IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}

		sc.close();

	}

}
