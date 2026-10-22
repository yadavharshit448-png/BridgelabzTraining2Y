package AdvancedRecursion;

public class TowerOfHanoi {
    public static void t(int n,char source, char helper,char destination){
         if(n==1){
             System.out.println("Move Disk "+n+" from "+source+" To "+destination);
             return ;
         }
         t(n-1,source,destination,helper);
        System.out.println("Move Disk "+n+" from "+source+" To "+destination);
        t(n-1,helper,source,destination);


    }
    public static void main(String[] args){

        int n =3;
        t(n,'A','B','C');
    }
}
