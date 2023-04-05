/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

/**
 *
 * @author Alyas
 */
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class Employee implements Serializable {

    private static final float taxrate = 0.2f;
    protected NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

    public Employee() {

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int selection;
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Calculate Gross Pay");
            System.out.println("2) Calculate Tax");
            System.out.println("3) Calculate Net Pay");
            System.out.println("4) Calculate Net Percent");
            System.out.println("5) Display All");
            System.out.println("6) Exit");
            System.out.println("Please select an option:");
            selection = sc.nextInt();
            if (selection < 1 || selection > 6) {
                System.out.println("Invalid choice. Try again: ");
            }
            switch (selection) {
                case 1:
                    System.out.println("Gross: " + currency.format(computeGross()));
                    break;
                case 2:
                    System.out.println("Tax: " + currency.format(computeTax()));
                    break;
                case 3:
                    System.out.println("Net: " + currency.format(computeNet()));
                    break;
                case 4:
                    System.out.println("Net%: " + computeNetPerc() + "%");
                    break;
                case 5:
                    displayEmployee();
                    break;
                case 6:
                    exit = true;
                    break;
            }
        }
    }

    public double computeTax() {
        return computeGross() * taxrate;
    }

    public double computeNet() {
        return computeGross() - computeTax();
    }

    public double computeNetPerc() {
        return (computeNet() / computeGross()) * 100;
    }

    protected void displayEmployee() {

        System.out.println("Gross: " + currency.format(computeGross()));
        System.out.println("Tax: " + currency.format(computeTax()));
        System.out.println("Net: " + currency.format(computeNet()));
        System.out.println("Net%: " + String.format("%.2f",computeNetPerc()) + "%");
    }

    public abstract double computeGross();

}

class HourlyEmployee extends Employee implements Serializable {

    private int hours;
    private double rate;

    public HourlyEmployee(Scanner sc) {

        System.out.println("How many hours did you work? ");
        hours = sc.nextInt();

        System.out.println("What is your wage per hour?: $");
        rate = sc.nextDouble();
    }

    @Override
    protected void displayEmployee() {
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + currency.format(rate));
        super.displayEmployee();
    }

    @Override
    public double computeGross() {

        double gross;
        if (hours > 40) {
            gross = (float) ((40 * rate) + (hours - 40) * (rate * 1.5));
        } else {
            gross = rate * hours;
        }
        return gross;
    }
}

class CommissionEmployee extends Employee implements Serializable {

    private int itemsSold;
    private float unitPrice;

    public CommissionEmployee(Scanner sc) {
      
        System.out.println("How items were sold? ");
        itemsSold = sc.nextInt();
        System.out.println("What was the unit price? $");
        unitPrice = sc.nextInt();
    }

    @Override
    protected void displayEmployee() {
        System.out.println("Items Sold: " + itemsSold);
        System.out.println("Unit Price: " + currency.format(unitPrice));
        super.displayEmployee();
    }

    @Override
    public double computeGross() {

        double gross = (float) ((itemsSold * unitPrice) * .03);

        return gross;
    }
}

class SalaryEmployee extends Employee implements Serializable {

    private double gross;

    public SalaryEmployee(Scanner sc) {
        int input;
        System.out.println("Are you Staff (S) or Executive (E)? ");
        input = sc.next().charAt(0);
        if (input == 'S' || input == 's') {
//staff employee
            gross = 50000;

        } else if (input == 'E' || input == 'e') {
//executive employee
            gross = 100000;
        }
    }

    @Override
    protected void displayEmployee() {
        System.out.println("Yearly Gross: " + currency.format(gross));
        super.displayEmployee();
    }

    @Override
    public double computeGross() {

        return gross / 52;
    }
}