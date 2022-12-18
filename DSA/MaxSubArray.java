package DSA;

public class MaxSubArray {
    //Optimised approach
    //Prefix Sum
    public static void maxsubarraysum(int[] array){
        int MaxSum = Integer.MIN_VALUE;
        int prefix[] = new int[array.length];

        prefix[0]=array[0];
        for(int i =1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+array[i];
        }

        for(int i = 0; i<array.length; i++){
            int start = i;
            for(int j=i; j<array.length; j++){
                int end = j;
                int sum = start == 0? prefix[end]: prefix[end]-prefix[start-1];

                if(MaxSum<sum){
                    MaxSum=sum;
                }
            }
        }
        System.out.println("MaxSum: "+MaxSum);
    }

    public static void kadane(int[] array){
        int sum = 0;
        int MaxSum = Integer.MIN_VALUE;

        for(int i = 0; i<array.length; i++){
            sum += array[i];
            if(sum<0){
                sum = 0;
            }
            MaxSum = Math.max(MaxSum, sum);
        }
        System.out.println("MaxSum: "+MaxSum);
    }


    public static void main(String[] args) {
        int[] array1 = {1,-2,6,-1,3};
        int[] array2 = {-2,-3,4,-1,-2,1,5,-3};
        kadane(array1);
        kadane(array2);
    }
}
