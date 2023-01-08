public class ContainerMostWater {
    public static int storeWater(int[] height){
        int maxWater = 0;
        //brute Force -O(n^2)
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int h = Math.min(height[i],height[j]);
                int w = j-i;
                int currWater = h*w;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(storeWater(height));      
    }
}
