import java.lang.Math;
public class MaxSumSubArrayUsingPrefixArray {
    
            public static void main(String[] args) {
            int arr[] = {22, -8, 7, -9, 6, 2, 5};
            int maximum = Integer.MIN_VALUE;
            int prefix[] = new int[arr.length];

            prefix[0] = arr[0];

            for(int i = 1;i<arr.length;i++){
                prefix[i] = prefix[i-1]+arr[i];
            }

            int len = prefix.length;
    
            for(int i = 0;i<len;i++)
            { 
                int start = i;
                for(int j = i;j<len;j++){ 
                    int currSum = 0;
                    int end = j;
                        currSum = (start == 0) ? prefix[end] : prefix[end] - prefix[start - 1];

                        if(maximum<=currSum){
                            maximum = currSum;
                        }
                    }                                   
                 }
     System.out.println("Maximum sum of subarray is :"+ maximum);
    }
}
    