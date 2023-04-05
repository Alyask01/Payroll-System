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
public class SalaryEmployee extends Employee1
{
@Override
public void computeGross()
{
Scanner sc = new Scanner(System.in);
int input;
System.out.print("Are you Staff (S) or Executive (E)? ");
input = sc.next().charAt(0);
if(input == 'S' || input == 's')
{
//staff employee
gross = 50000;

}
else if(input == 'E' || input == 'e')
{
//executive employee
gross = 100000;
}
}
}
