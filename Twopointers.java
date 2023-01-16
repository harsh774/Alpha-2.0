public class Twopointers {
    //monotonic array
    public static boolean monotonicArray(int[] arr){
        int i = 0;
        int j = i+1;
        while(i<arr.length-1){
            if(arr[i]+1==arr[j] || arr[i]+1==arr[j]+1){
                i++;
                j++;
            }else if(arr[i]-1==arr[j]){
                j++;
                i++;
            }else{
                return false;
            }
        }
        return true;
    }

    //Lonely Numbers in Array
    

    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        System.out.println(monotonicArray(arr));
        
    }
}
