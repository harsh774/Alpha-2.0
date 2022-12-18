package DSA;

public class towersofhanoi {
    public static void towersofHanoi(int n, String src, String help, String dest){
        //base case
        if(n==1){
            System.out.println("Transfer disk " +n+" from "+src+" to "+dest);
            return;
        }

        towersofHanoi(n-1, src, dest, help);
        System.out.println("Transfer disk " +n+" from "+src+" to "+dest);
        towersofHanoi(n-1, help, src, dest);
    }

    public static void main(String[] args) {
        int n=3;
        towersofHanoi(n, "S", "H", "D");
    }
}
