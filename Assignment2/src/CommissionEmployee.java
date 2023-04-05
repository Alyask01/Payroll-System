/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alyas
 */
import java.util.Scanner;
public class CommissionEmployee extends Employee
{
@Override
public void computeGross()
{
int items;
float unitprice;
Scanner sc = new Scanner(System.in);
System.out.print("How items were sold? ");
items = sc.nextInt();
System.out.print("What was the unit price? $");
unitprice = sc.nextInt();
gross = (float)((items * unitprice)*.5);

}
}

