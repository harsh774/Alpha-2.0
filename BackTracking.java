
public class BackTracking {
    public static void assignanddecreasebytwo(int[] arr, int val){
        changearr(arr,0,val);
    }

    public static void changearr(int arr[],int i, int val){
        //base case
        if(i==arr.length){
            printArr(arr);
            return;
        }

        //recursion
        arr[i]=val;
        changearr(arr, i+1, val+1);
        arr[i]=arr[i]-2;
    }


    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //findsubsetofString
    public static void findSubsets(String str, String ans, int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }

        //recursion Yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //recusion No choice
        findSubsets(str, ans, i+1);
    }

    public static void main(String[] args) {
    //    int[] arr = new int[5];
    //    assignanddecreasebytwo(arr,1); 
        // changearr(arr, 0, 1);
        // printArr(arr);
        String str = "abc";
        findSubsets(str, "", 0);
    }
}