package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();
        System.out.print("How many contracts to this worker? ");
        int contractQuantity = sc.nextInt();

        Worker worker = new Worker(name, workerLevel, baseSalary, new Department(departmentName));

        for (int i = 0; i < contractQuantity; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.next();
            LocalDate dateFormatted = LocalDate.parse(date, dateTimeFormatted);
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(dateFormatted, valuePerHour, hours);
            worker.addContract(contract);
        }

        for(HourContract hc : worker.getContracts()) {
            System.out.println(hc);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthYear = sc.next();
        int month = Integer.parseInt(monthYear.substring(0,2));
        int year = Integer.parseInt(monthYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getDepartment());
        System.out.println("Income for " + monthYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
