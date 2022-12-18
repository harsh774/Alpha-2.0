package DSA;

public class stocksprofit {
    public static int buyAndsellStock(int price[]){
        int maxprofit = 0;
        int buyprice = Integer.MAX_VALUE;

        for(int i = 0; i<price.length; i++){

            if(buyprice<price[i]){
                int profit = price[i]-buyprice;
                maxprofit = Math.max(maxprofit, profit);
            }
            else{
                buyprice = price[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        System.out.println(buyAndsellStock(price));
    }
}
