package application;

import java.util.Scanner;

import utility.Company;
import utility.Individual;

public class App {
public static void main(String[] args) throws Exception {
    Scanner userInput = new Scanner(System.in);
    System.out.println("CALCULADORA DE IMPOSTO DE RENDA");
    System.out.println("--------------------------------");

    double total = 0;
    int answer = 0;
    while (answer != 1 && answer != 2) {
        System.out.print("Digite 1 para pessoa física ou 2 para Pessoa jurídica: ");
        answer = userInput.nextInt();
    }

    if (answer == 1) {
        System.out.println("--- Pessoa Física ---");
        System.out.print("Digite o numero de pessoas: ");
        int n = userInput.nextInt();
        Individual[] list = new Individual[n];
        
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ª Pessoa: %n", (i+1));
            userInput.nextLine();
            System.out.print("Nome: ");
            String name = userInput.nextLine();
            System.out.print("Renda anual: ");
            double anualIncome = userInput.nextDouble();
            System.out.print("Gastos Medicos (digite 0 se nenhum): ");
            double healthExp = userInput.nextDouble();
            list[i] = new Individual(name, anualIncome, healthExp);
            total = total + list[i].tax();
        }
        
        System.out.println("---------------");
        System.out.println("Imposto por pessoa: ");
        for (int i = 0; i < list.length; i++) {;
            System.out.println(list[i]);
        }
        System.out.println("");
        System.out.printf("Valor total a pagar: %.2f %n", total);
    } 
    else if (answer == 2) {
        System.out.println("--- Pessoa Jurídica ---");
        userInput.nextLine();
        System.out.print("Nome: ");
        String name = userInput.nextLine();
        System.out.print("Digite o numero de funcionários: ");
        int numberEmployees = userInput.nextInt();
        System.out.print("Digite renda anual: ");
        double anualIncome = userInput.nextDouble();
        Company company = new Company(name, anualIncome, numberEmployees);

        System.out.println("Valor total a pagar: " + company);
    }

    userInput.close();
}
}
