package Array.Logical_Problem;

import java.util.Scanner;

public class FirstRepeat {
    public static int firstRepeat(int arr[]){
        for(int i =0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;i++){
                if(arr[i]==arr[j]){
                    return arr[i];
                }

            }

        }


return -1;


    }

   public static void main(String[]args){
       Scanner sc = new Scanner(System.in);
       System.out.print("enter the size of array ");
       int b = sc.nextInt();
       int arr[] = new int[b];
       System.out.println("enter elements 10");
       for (int i = 0;i<b;i++){
           arr[i]=sc.nextInt();
       }
       firstRepeat(arr);


   }
}
