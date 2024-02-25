import java.lang.Math;
public class TrappingRainwater
{
    public static int TrappedWater(int height[]){

        //Left Max array
        int leftMax[] = new int[height.length];

        leftMax[0] = height[0];

        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
         }

         //Right Max ARRAY

         int rightMax[] = new int[height.length];
         rightMax[height.length - 1] = height[height.length -1];

         for(int i = height.length-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
         }

         int trappedWater = 0;
         int width = 1;

         for(int i = 0;i<height.length; i++){
            
            //Minimum of both
           int  waterLevel = Math.min(rightMax[i],leftMax[i]);

           int barLevel = height[i];

           trappedWater = trappedWater + ((waterLevel - barLevel)*width);

         }
         return trappedWater;

    }
    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5};
        System.out.println(TrappedWater(arr));

    }
}