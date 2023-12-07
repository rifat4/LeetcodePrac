package medium;

public class LargestOddNumberInString {

    String largestOddNumber(String num){
        char[] nums = num.toCharArray();
        for(int i = num.length() - 1; i >= 0; i--){
            if((((int)nums[i]-48) % 2) == 1){
                return(num.substring(0, i+1));
            }
        }
        return "";
    }
    
    LargestOddNumberInString(String num){
        System.out.println(largestOddNumber(num));
    }

    public static void main(String args[]){
        new LargestOddNumberInString("52");
    }
}
