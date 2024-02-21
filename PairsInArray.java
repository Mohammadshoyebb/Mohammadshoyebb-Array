public class PairsInArray {
    public static void main(String[] args) {
        int arr[] = {2, 4, 7, 1, 6, 8, 5};
        int len = arr.length;

        for(int i = 0;i<len-1;i++)
        {
            for(int j = i;j<len-1;j++){
            System.out.print("("+arr[i]+", "+arr[j+1]+")  ");
            }
            System.out.println();
        }


    }
}
