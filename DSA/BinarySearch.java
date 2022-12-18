package DSA;

public class BinarySearch {
    
public static int binarySearch(int num[], int key){
    int start = 0, end = num.length-1;

    while(start<=end){

        int mid = (start+end)/2;

        if(num[mid] == key){ //key = mid
            return mid;
        }
        if(num[mid]<key){ // key in between mid and end START = MID+1
            start = mid+1;
        }else{ //Key is in between start and mid;
            end = mid-1;
        }
    }
    return -1;
}

    public static void main(String[] args) {
        int number[] = {2,4,6,8,10,12,14};
        int key = 10;

        System.out.println(binarySearch(number, key));

    }
}
