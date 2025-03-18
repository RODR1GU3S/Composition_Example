package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
// Essa instância criada serve para associar o (trabalhador) a um (departamento) específico  // new Department(departmentName):
																							 // Constrói um objeto do tipo Department usando o construtor:
                                                                                      	     // Aqui está instanciando a Associação Department;
                                                                                    	     //  passando departmentName do tipo String como argumento..
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
											   // O método valueOf(String name); 
											   //  Recebe uma String como entrada;
											   //  Retorna o valor do enum correspondente;
											   //   que possui exatamente o mesmo nome.
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		// Adiciona contratos ao trabalhador
		for(int i = 1; i <= n; i ++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
// Essa instância cria um objeto HourContract representando um contrato de trabalho.
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); // Criação de contratos é delegada para a classe `HourContract`

			// Associação do contract (contrato) ao Worker (trabalhador)
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		// Exibe resultados formatados
		System.out.println("Name: " + worker.getName());
		System.out.println("Department " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();

	}

}
