public class ArryaReverseUsingSingleArray {
    public static void main(String[] args) {
        int a[] = {2, 4, 7, 1, 4, 6, 8, 5};
        int temp = 0;
        int start = 0;
        int end = a.length-1;

        while(start<end){
            temp = a[start];
            a[start] = a[end];;
            a[end] = temp;
            
            start++;
            end--;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
