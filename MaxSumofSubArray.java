import java.lang.Math;
public class MaxSumofSubArray {
            public static void main(String[] args) {
            int arr[] = {22, -8, 7, -9, 6, 2, 5};
            int len = arr.length;
            int maximum = Integer.MIN_VALUE;
    
            for(int i = 0;i<len;i++)
            {    int count = 0;
                int start = i;
                for(int j = i;j<len;j++){

                    count = 0;
                    int end = j;
                    
                    for(int k = start; k<=end; k++){
                       count += arr[k];
                    }
                    if(maximum<=count){
                        maximum = count;  
                }
                                            
            }
        }
            System.out.println("Maximum sum of subarray is :"+ maximum);
    
    
        }
    }
    
