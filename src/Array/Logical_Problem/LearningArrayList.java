package Array.Logical_Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class LearningArrayList {


    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        System.out.println("array list is " + number);
        Integer[] arr = number.toArray(new Integer[0] );
        System.out.println("array is: " +       Arrays.toString(arr));

    }
}
