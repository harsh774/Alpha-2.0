package DSA;

public class Subarrays {
    public static void SubArrays(int[] array){
        int total = 0;
        int MaxSum = Integer.MIN_VALUE;
        int MinSum = Integer.MAX_VALUE;

        for(int i= 0; i<array.length; i++){
            int start = i;
            for(int j = i; j<array.length; j++){
                int end = j;
                int msum = 0;

                for(int k = start; k<=end; k++){
                    System.out.print(array[k]+",");
                    msum+= array[k];

                    if(msum>MaxSum){
                        MaxSum=msum;
                    }
                    if(msum<MinSum){
                        MinSum = msum;
                    }

                }
                total++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays: "+total);
        System.out.println("MaxSum :-"+MaxSum);
        System.out.println("MinSum :-"+MinSum);
    }

    public static void main(String[] args) {
        int[] array = {1,-2,6,-1,3};
        SubArrays(array);

    }
}
