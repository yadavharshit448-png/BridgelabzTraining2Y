package Java_dsa;

import java.util.Scanner;

public class primeNum {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for(int i=2;i<n;i++){
            if(n%i==0){
                count = 0;
                break;

            }

            else{
                count = 1;
            }
        }
        if(count==0){
            System.out.println("not prime");
        }
        else{
            System.out.println("prime");
        }




    }
}
