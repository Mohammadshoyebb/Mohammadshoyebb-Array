import java.util.*;
public class Largest_Element_in_array {
   public static void main(String[] args) {
    int largest = Integer.MIN_VALUE;
    int[] arr = {23,76,89,1,90,7,65};
    
    for(int i = 0;i<arr.length;i++){
        if(arr[i]>=largest){
            largest = arr[i];
        }
    }
    System.out.println(largest);


   } 
}
