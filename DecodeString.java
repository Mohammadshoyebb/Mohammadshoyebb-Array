import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        // Test cases
        String s1 = "3[a]2[bc]";
        System.out.println("Decoded string of \"" + s1 + "\": " + solution.decodeString(s1)); // Output: "aaabcbc"

        String s2 = "3[a2[c]]";
        System.out.println("Decoded string of \"" + s2 + "\": " + solution.decodeString(s2)); // Output: "accaccacc"

        String s3 = "2[abc]3[cd]ef";
        System.out.println("Decoded string of \"" + s3 + "\": " + solution.decodeString(s3)); // Output: "abcabccdcdcdef"
    }
}
//=====================ANOTYER METHOD USING STACK PAIRS===============================

// import java.util.Stack;

// public class DecodeString {
//     public String decodeString(String s) {
//         Stack<Pair> stack = new Stack<>();
//         StringBuilder currentString = new StringBuilder();
//         int count = 0;

//         for (char ch : s.toCharArray()) {
//             if (Character.isDigit(ch)) {
//                 count = count * 10 + (ch - '0');
//             } else if (ch == '[') {
//                 stack.push(new Pair(currentString.toString(), count));
//                 count = 0;
//                 currentString = new StringBuilder();
//             } else if (ch == ']') {
//                 Pair pair = stack.pop();
//                 StringBuilder decodedString = new StringBuilder(pair.getKey());
//                 for (int i = 0; i < pair.getValue(); i++) {
//                     decodedString.append(currentString);
//                 }
//                 currentString = decodedString;
//             } else {
//                 currentString.append(ch);
//             }
//         }

//         return currentString.toString();
//     }

//     public static void main(String[] args) {
//         DecodeString solution = new DecodeString();

//         // Test cases
//         String s1 = "3[a]2[bc]";
//         System.out.println("Decoded string of \"" + s1 + "\": " + solution.decodeString(s1)); // Output: "aaabcbc"

//         String s2 = "3[a2[c]]";
//         System.out.println("Decoded string of \"" + s2 + "\": " + solution.decodeString(s2)); // Output: "accaccacc"

//         String s3 = "2[abc]3[cd]ef";
//         System.out.println("Decoded string of \"" + s3 + "\": " + solution.decodeString(s3)); // Output: "abcabccdcdcdef"
//     }

//     static class Pair {
//         String key;
//         int value;

//         public Pair(String key, int value) {
//             this.key = key;
//             this.value = value;
//         }

//         public String getKey() {
//             return key;
//         }

//         public int getValue() {
//             return value;
//         }
//     }
// }


//++++++++++++++++++++ANOTHER METHOD USING DOUBLE STACK+++++++++++++++++++++++++++++++++++++


// class Solution {
//     public String decodeString(String s) {
//         Stack<Integer> numberStack = new Stack<>();
//         Stack<String> mainStack = new Stack<>();

//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);

//             if(ch>='0' && ch<='9'){ // identifing it is a number
//                 int num = 0 ;

//                 while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
//                     num = num * 10  + (int)(s.charAt(i)-'0');
//                     i++;
//                 }
//                 i--; // to maintain the loop variable
//                 numberStack.push(num);
//             }else if ( ch != ']'){
//                 mainStack.push(ch + "");
//             }else { // condition for ']'
//                 String str = "";
//                 while(!mainStack.peek().equals("[")){
//                     str = mainStack.pop() + str ;
//                 }
//                 mainStack.pop();
//                 int repetationNumber = numberStack.pop();

//                 StringBuilder sb = new StringBuilder("") ;

//                 while(repetationNumber>0){
//                     sb.append(str);
//                     repetationNumber--;
//                 }

//                  mainStack.push(sb.toString());
//             }
//         }

//         StringBuilder ans = new StringBuilder("");

//         while(mainStack.size()>0){
//             ans.insert(0,mainStack.pop());
//         }
//         return ans.toString();
//     }
// }
