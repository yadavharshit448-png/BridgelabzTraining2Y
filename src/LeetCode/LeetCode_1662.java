package LeetCode;

public class LeetCode_1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String S1 ="";
        String S2 = "";
        int index=0;
        while(index<word1.length||index<word2.length){

            if(index<word1.length){
                S1 = S1 + word1[index];
            }
            if(index<word2.length){
                S2 = S2 + word2[index];
            }
            index++;

        }
        if(S2.equals(S1)){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
