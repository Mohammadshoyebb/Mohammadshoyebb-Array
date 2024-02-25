import java.lang.Math;
public class BuyANDSell_Stocks {
    public static int buySell(int arr[]){
        int maxProfit = 0;
        int buyStock = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(buyStock < arr[i]){
                int profit  = arr[i] - buyStock;
                maxProfit = Math.max(maxProfit,profit);
            }
            else{
                buyStock = arr[i];
            }
        }
        return maxProfit;
    
    }
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        System.out.println(buySell(arr));
    }
    
}
