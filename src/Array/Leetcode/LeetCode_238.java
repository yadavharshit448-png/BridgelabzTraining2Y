package Array.Leetcode;

public class LeetCode_238 {

    public static int[] productExceptSelf(int[] nums) {

        int product = 1;
        int[] answer =new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            answer[i] = product;
            product = product*nums[i];


        }
        product=1;
        for(int i = nums.length-1;i>=0;i--){
            answer[i]=answer[i]*product;
            product = product *nums[i];
        }
        return answer;


    }
    public static void main(String[]args){
        int[] nums = {1,2,3,4};

        for(int i:productExceptSelf(nums)){
            System.out.println(i);
        }


    }
}
