/*
 * 232. Implement Queue using Stacks
Solved
Easy
Topics
Companies
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.
 

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */



import java.util.LinkedList;
import java.util.Queue;

class  QueueUsingStack__leet39 {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public QueueUsingStack__leet39() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack__leet39 stack = new QueueUsingStack__leet39();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop: " + stack.pop());         // Output: 3
        System.out.println("Is empty: " + stack.empty());  // Output: false
        System.out.println("Top element: " + stack.top()); // Output: 2
    }
}

//-----------------ANOTHER METHOD========================

// /*
//  * import java.util.LinkedList;
// import java.util.Queue;

// class MyStack {
//     private Queue<Integer> queue1;
//     private Queue<Integer> queue2;
//     private int top;

//     /** Initialize your data structure here. */
//     public MyStack() {
//         queue1 = new LinkedList<>();
//         queue2 = new LinkedList<>();
//     }
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         queue2.offer(x);
//         top = x;
//         while (!queue1.isEmpty()) {
//             queue2.offer(queue1.poll());
//         }
//         Queue<Integer> temp = queue1;
//         queue1 = queue2;
//         queue2 = temp;
//     }
    
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         int element = queue1.poll();
//         if (!queue1.isEmpty()) {
//             top = queue1.peek();
//         }
//         return element;
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return top;
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }

//  */



//===============  ANOTHER METHOD==========================================


// class MyQueue {
//     private Stack<Integer> main;
//     private Stack<Integer> helper;

//    public MyQueue() {
//        main = new Stack<>();
//        helper = new Stack<>();
//    }

//    public void push(int x) {
//        // add all elements of main to helper -- main --> helper

//        while(main.size()>0){
//            helper.push(main.pop());
//        }

//        // add x to main

//        main.push(x);

//        // add all elemets from helper to main -- helper ---> main

//        while(helper.size()>0){
//            main.push(helper.pop());
//        }
//    }

//    public int pop() {
//        return main.pop();
//    }

//    public int peek() {
//        return main.peek();
//    }

//    public boolean empty() {
//        return main.size()==0;
//    }
// }
// /**
// * Your MyQueue object will be instantiated and called as such:
// * MyQueue obj = new MyQueue();
// * obj.push(x);
// * int param_2 = obj.pop();
// * int param_3 = obj.peek();
// * boolean param_4 = obj.empty();
// */
