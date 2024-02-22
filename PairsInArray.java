public class PairsInArray {
    public static void main(String[] args) {
        int arr[] = {2, 4, 7, 1, 6, 8, 5};
        int len = arr.length;

        for(int i = 0;i<len;i++)
        {
            int start = i;
            for(int j = i;j<len;j++){
                int end = j;
                
                for(int k = start; k<=end; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
        }


    }
}
