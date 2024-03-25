// 1491. Average Salary Excluding the Minimum and Maximum Salary
// Solved: Easy
// Topics: Math, Sorting
// Companies: Google, Amazon, Facebook
// Hint: You are given an array of unique integers salary where salary[i] is the salary of the ith employee.
// Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.
// Example 1:
// Input: salary = [4000,3000,1000,2000]
// Output: 2500.00000
// Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
// Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
// Example 2:
// Input: salary = [1000,2000,3000]
// Output: 2000.00000
// Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
// Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
// Constraints:
// 3 <= salary.length <= 100
// 1000 <= salary[i] <= 106
// All the integers of salary are unique.






public class AverageSalaryExcludingMinMax_leetcode36 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Find the minimum and maximum salaries
        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum += s;
        }

        // Calculate the sum excluding the minimum and maximum salaries
        sum -= min + max;

        // Calculate the average
        return (double) sum / (salary.length - 2);
    }

    public static void main(String[] args) {
        AverageSalaryExcludingMinMax_leetcode36 solution = new AverageSalaryExcludingMinMax_leetcode36();

        // Example cases
        int[] salary1 = {4000, 3000, 1000, 2000};
        System.out.println("Output for salary1: " + solution.average(salary1)); // Output: 2500.00000

        int[] salary2 = {1000, 2000, 3000};
        System.out.println("Output for salary2: " + solution.average(salary2)); // Output: 2000.00000

        // Additional test cases
        int[] salary3 = {6000, 5000, 4000, 3000, 2000, 1000};
        System.out.println("Output for salary3: " + solution.average(salary3)); // Output: 3500.00000

        int[] salary4 = {2500, 3500, 4500};
        System.out.println("Output for salary4: " + solution.average(salary4)); // Output: 3500.00000
    }
}


//   ANOTHER METHOD FASTER AND TEAKES LESS MEMORY


// class Solution {
//     public double average(int[] salary) {
//         int max = salary[0];
//         int min = salary[0];
//         int sum = salary[0];

//         for(int i=1;i<salary.length;i++){

//             if(max<salary[i]){
//                 max=salary[i];
//             }

//             if(min>salary[i]){
//                 min=salary[i];
//             }

//             sum = sum + salary[i];
//         }

//         sum = sum - min - max ;

//         double ans = (double)sum/(salary.length-2);
//         return ans ;
//     }
// }