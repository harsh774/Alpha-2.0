public class pairsum {
    public static boolean pairSum2(int[] ar, int target){
        int pivot = -1;
        for(int i=0; i<ar.length; i++){
            if(ar[i]>ar[i+1]){
                pivot = i;
                break;
            }
        }

        int startPointer = pivot+1;
        int endPointer = pivot;
        while(startPointer!=endPointer){
            //case1
            if(ar[startPointer]+ar[endPointer]==target){
                return true;
            }

            //case2
            if(ar[startPointer]+ar[endPointer]<target){
                startPointer = (startPointer+1)%ar.length;
            }else{
                endPointer = (ar.length+endPointer-1)%ar.length;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] ar = {11,15,6,8,9,10};
        int target = 16;
        System.out.println(pairSum2(ar, target));

    }
}
