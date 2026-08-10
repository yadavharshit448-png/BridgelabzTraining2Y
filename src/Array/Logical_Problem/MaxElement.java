package Array.Logical_Problem;

import java.util.Locale;
import java.util.Scanner;

public class MaxElement {
    public static int maxElement(int arr[]){

       int max = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of array ");
        int b = sc.nextInt();
        int arr[] = new int[b];
        System.out.println("enter elements 10");
        for (int i = 0;i<b;i++){
            arr[i]=sc.nextInt();
        }

       int maxx =maxElement(arr);
        System.out.println(maxx );





    }
}
