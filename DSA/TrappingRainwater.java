package DSA;

public class TrappingRainwater {

    public static int trappedWater(int height[]){
        int len = height.length;

        //Step-1 Calculate left max boundries - auxiliary array
        int leftmax[] = new int[len];
        leftmax[0]=height[0];

        for(int i = 1; i<len; i++){
            leftmax[i]=Math.max(height[i], leftmax[i-1]);
        }

        //Step-2 Calculate right max boundries - auxiliary array
        int Rightmax[] = new int[len];
        Rightmax[len-1]=height[len-1];

        for(int i = len-2; i>=0; i--){
            Rightmax[i]=Math.max(height[i], Rightmax[i+1]);
        }

        int TotalTrappedWater = 0;
        //loop
        for(int i=0; i<len; i++){

            //WaterLevel = min(leftmax, rightmax)
            int waterLevel = Math.min(leftmax[i],Rightmax[i]);

            //Trapped Water value = WaterLevel-Height[current bar]
            TotalTrappedWater += waterLevel - height[i];
        }
        return TotalTrappedWater;

    }
    



    public static void main(String[] args) {
        int height[] = {4,2,0,3,2,5};
        System.out.println(trappedWater(height));
    }
}
