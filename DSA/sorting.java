package DSA;

import java.util.Arrays;
//import java.util.Arrays;
import java.util.Collections;

public class sorting {
    
    public static void bubblesort(int arr[]){
        for(int turn = 0; turn<arr.length-2; turn++){
            for(int j = 0; j<arr.length-2-turn; j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        
    }

    public static void selectionsort(int arr[]){
        for(int i = 0; i<arr.length-1; i++){
            int minPos = i;
            for(int j =i+1; j<arr.length; j++){
                //minPos = Math.min(arr[minPos], arr[j]);
                if(arr[minPos]>arr[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos]= arr[i];
            arr[i]=temp;

        }

    }

    public static void insertionsort(Integer arr[]){
        for(int i = 1; i<arr.length; i++){
            int current = arr[i];
            int previous = i-1;
            while(previous>=0 && arr[previous]>current){
                arr[previous+1]= arr[previous];
                previous--;
            }

            //insertion
            arr[previous+1]=current;
        }
    }

    public static void countingsort(int arr[]){
        int largest = Integer.MIN_VALUE;

        //Finding max/largest in original array
        for(int i = 0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        //creating counting array of frequency
        int count[] = new int[largest+1];
        for(int i = 0; i<arr.length; i++){
            count[arr[i]]++;
        }

        //sorting
        int j = 0;
        for(int i = 0; i<count.length; i++){
            while(count[i]>0){
                arr[j]=i;
                count[i]--;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        //int arr[] = {1,2,3,4,5,6,7,8,9};
        //Integer arr[] = {5,4,1,3,2};
        int arr1[] = {1,4,1,3,2,4,3,7};
        //Arrays.sort(arr,0,3);
        //Arrays.sort(arr,Collections.reverseOrder());
        //insertionsort(arr);
        countingsort(arr1);
        for(int i = 0; i<arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }

    }
}
