package Array.Logical_Problem;

import java.util.Scanner;

public class ReverseArray {


    public static void swap(int arr[]){

        int a = arr[0];
        int b = arr.length-1;
        while(a>b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a--;
            b--;

        }
    }
public static void input(int a){
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the size of array");
    int b = sc.nextInt();
    int arr[] = new int[b];



}
}
