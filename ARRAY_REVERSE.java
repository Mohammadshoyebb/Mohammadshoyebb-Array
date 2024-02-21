public class ARRAY_REVERSE {
    public static void main(String[] args) {
        int a[] = {2, 4, 7, 1, 4, 6, 8, 5};
        int len = a.length, j = 0;
        int b[] = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            b[j] = a[i];
            j++;
        }

        for (int i = 0; i < len; i++) {
            System.out.println(b[i]);
        }
    }
}
