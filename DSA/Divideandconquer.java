package DSA;

public class Divideandconquer {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void merggesort(int arr[]){
        int si = 0;
        int ei = arr.length-1;
        mergesort(arr, si, ei);
    }

    public static void mergesort(int arr[], int si, int ei){

        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergesort(arr, si, mid);
        mergesort(arr, mid+1, ei);
        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i]=temp[k];
        }

    }

    //Quick Sort
    public static void QuickSort(int arr[]){
        int si =0;
        int ei = arr.length-1;
        Quicksort(arr, si, ei);
    }

    public static void Quicksort(int arr[], int si, int ei){

        if(si>=ei){
            return;
        }
        int pivotIdx = partition(arr, si, ei);
        Quicksort(arr, si, pivotIdx-1);
        Quicksort(arr, pivotIdx+1, ei);

    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j=si; j<ei; j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        //swap
        int temp = pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }

    //RotedSerachArrya
    public static int search(int arr[], int tar, int si, int ei){

        if(si>ei){
            return -1;
        }

        int mid = si + (ei-si)/2;

        //caseFound
        if(arr[mid]==tar){
            return mid;
        }

        //mid on L1
        if(arr[si]<=arr[mid]){
            //case: a Left of L1
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr, tar, si, mid);
            }else{
                //case: b Right of L1 (including Full L2)
                return search(arr, tar, mid+1, ei);
            }
        }

        //mid on L2
        else{
            //case: c Right of L2
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr, tar, mid+1, ei);
            }else{
                //case: d Right of L2 (including L1)
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        // mergesort(arr, 0, arr.length-1);
        // QuickSort(arr);
        // printArr(arr);
        System.out.println(search(arr, 0, 0, arr.length-1));
    }
}
