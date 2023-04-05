/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Murtada
 */
import java.util.Scanner;
public class HourlyEmployee extends Employee
{
@Override
public void computeGross()
{
Scanner sc = new Scanner(System.in);
float overtime;
System.out.print("How many hours did you work? ");
hours = sc.nextInt();

System.out.print("What is your wage per hour?: $");
rate = sc.nextInt();
if(hours > 40)
{
overtime = hours - 40;
overtime = (float)((40 * rate) + (hours - 40)*(rate * 1.5));
gross = overtime * rate * 1.5f;
}
else
{
overtime = 0;
gross = rate * hours;
}

}
}
