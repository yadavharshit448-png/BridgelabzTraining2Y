package Array.Logical_Problem;

import java.util.Scanner;

public class FirstNatural {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int sum = 0;

        while(temp>0){
            sum = sum + temp;
             temp--;
        }
        System.out.println(sum);

        System.out.println("program done");
    }
}
