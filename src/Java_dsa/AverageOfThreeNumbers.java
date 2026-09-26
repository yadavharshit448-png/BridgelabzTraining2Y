package Java_dsa;

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter third number: ");
        double num3 = sc.nextDouble();

        double average = (num1 + num2 + num3) / 3.0;
        System.out.println("Average of " + num1 + ", " + num2 + ", and " + num3 + " is: " + average);
        sc.close();
    }
}
