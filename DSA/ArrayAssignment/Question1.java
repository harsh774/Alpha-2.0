package DSA.ArrayAssignment;
import java.util.*;

public class Question1 {

    public static boolean twiceappear(int[] nums){
        boolean ans = false;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    ans = true;
                    break;
                }
            }
        }
        return ans;
    }

    public static int index(int[] nums){
        
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int nums[] = new int[len];
        for(int i = 0; i<len; i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(twiceappear(nums));
    }
    
}