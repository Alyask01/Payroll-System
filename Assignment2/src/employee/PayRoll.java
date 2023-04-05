/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

/**
 *
 * @author Alyas
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class PayRoll {

    private Employee[] myAccts = new Employee[3];
    private int selectedIndex = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        PayRoll myEMP = new PayRoll();
        myEMP.SelectMenu();
    }

    public void SelectMenu() throws IOException {
        int selection;
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Populate employee");
            System.out.println("2) Select employee");
            System.out.println("3) Save employee");
            System.out.println("4) Load employee");
            System.out.println("5) Exit");
            System.out.println("Please select an option: ");
            selection = sc.nextInt();
            sc.nextLine();
            if (selection < 1 || selection > 5) {
                System.out.println("Invalid choice. Try again: ");
            }

            switch (selection) {
                case 1:
                    populate();
                    break;
                case 2:
                    select();
                    break;
                case 3:
                    save();
                    break;
                case 4:
                    load();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }

    public void populate() {
        if (selectedIndex == myAccts.length) {
            System.out.println("The array is full");
            return;
        }
        char input = ' ';
        System.out.println("Are you an Hourly (H), Salary (S), or Commission (C) employee? ");
        String line = sc.nextLine().trim();
        if (line.length() > 0) {
            input = line.charAt(0);
        }
        if (input == 'H' || input == 'h') {
            myAccts[selectedIndex] = new HourlyEmployee(sc);
            selectedIndex++;
        } else if (input == 'S' || input == 's') {
            myAccts[selectedIndex] = new SalaryEmployee(sc);
            selectedIndex++;
        } else if (input == 'C' || input == 'c') {
            myAccts[selectedIndex] = new CommissionEmployee(sc);
            selectedIndex++;
        } else {
            System.out.println("Invalid employee type");
        }
    }

    public void select() throws IOException {
        try {
            System.out.println("Please select an employee 0,1,2: ");
            int input = sc.nextInt();
            myAccts[input].menu();
        } catch (Exception ioe) {
            System.out.println("Employee does not exist");
            System.out.println();
        }
    }

    public void save() {
        try {
            FileOutputStream outStream = new FileOutputStream("file1.out");
            ObjectOutputStream os = new ObjectOutputStream(outStream);
            os.writeObject(myAccts);
            os.flush();
            os.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }

    }

    public void load() {
        try {
            FileInputStream inStream = new FileInputStream("file1.out");
            ObjectInputStream is = new ObjectInputStream(inStream);
            myAccts = (Employee[]) is.readObject();
            is.close();
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}