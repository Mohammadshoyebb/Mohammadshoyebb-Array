public class Tribonacci_Number {
    
        public static int tribonacci(int n) {
            int first = 0, second = 1, third = 1;
    
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
    
            for (int i = 3; i <= n; i++) {
                int fourth = first + second + third;
                first = second;
                second = third;
                third = fourth;
            }
            return third;
        }
    
        public static void main(String[] args) {
            int n = 4; // Change n to the desired Tribonacci number index
            System.out.println(tribonacci(n));
        }
    } 

