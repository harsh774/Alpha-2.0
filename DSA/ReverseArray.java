package DSA;

public class ReverseArray {

    public static void reverse(int[] array){
        int i = 0;
        int j = array.length-1;

        while(i<j){
            int temp = array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] array = {2,4,6,8,10}; 
        reverse(array); 
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }      
    }
}
