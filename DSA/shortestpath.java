package DSA;

import java.security.PublicKey;

public class shortestpath {

    public static float getShortestPath(String path){
        int x=0, y=0;

        for(int i = 0; i<path.length(); i++){
            char dir=path.charAt(i);
            //south
            if(dir=='S'){
                y--;
            }
            else if(dir=='W') x--;
            else if(dir=='E')x++;
            else y++;

        }
        int x2 = x*x;
        int y2 = y*y;
        return (float)Math.sqrt(x2+y2);
    }

    //Largest String
    public static String largestString(String[] str){
        String largest = str[0];
        for(int i=1; i<str.length; i++){
            if(largest.compareToIgnoreCase(str[i])<0){
                largest = str[i];
            }
        }
        return largest;
    }
    
    
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));

        String[] fruits = {"Apple","Mango","Banana"};
        System.out.println(largestString(fruits));

    }
}
