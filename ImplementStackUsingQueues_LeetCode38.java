/*
 225. Implement Stack using Queues
Solved
Easy
Topics
Companies
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 

Follow-up: Can you implement the stack using only one queue?




 */



 import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueues_LeetCode38 {
    private Queue<Integer> main;
    private Queue<Integer> helper;

    public ImplementStackUsingQueues_LeetCode38() {
        main = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {
        // Move all elements from main to helper
        while (!main.isEmpty()) {
            helper.add(main.remove());
        }
        // Add x to main queue
        main.add(x);
        // Move all elements from helper back to main
        while (!helper.isEmpty()) {
            main.add(helper.remove());
        }
    }

    public int pop() {
        return main.remove();
    }

    public int top() {
        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues_LeetCode38 stack = new ImplementStackUsingQueues_LeetCode38();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop: " + stack.pop());         // Output: 3
        System.out.println("Is empty: " + stack.empty());  // Output: false
        System.out.println("Top element: " + stack.top()); // Output: 2
    }
}


/*
  ------------------    ANOTHER METHOD USING SINGLE QUEUE------------------------ 

// import java.util.LinkedList;
// import java.util.Queue;

// class MyStack {
//     private Queue<Integer> queue;

//     /** Initialize your data structure here. */
//     public MyStack() {
//         queue = new LinkedList<>();
//     }
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         int size = queue.size();
//         queue.offer(x);
//         for (int i = 0; i < size; i++) {
//             queue.offer(queue.poll());
//         }
//     }
    
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         return queue.poll();
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return queue.peek();
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return queue.isEmpty();
//     }

//     public static void main(String[] args) {
//         MyStack stack = new MyStack();
//         stack.push(1);
//         stack.push(2);
//         stack.push(3);

//         System.out.println("Top element: " + stack.top()); // Output: 3
//         System.out.println("Pop: " + stack.pop());         // Output: 3
//         System.out.println("Is empty: " + stack.empty());  // Output: false
//         System.out.println("Top element: " + stack.top()); // Output: 2
//     }
// }




// ---------------------  Explanation  ---------------------

/*
 * We use a single queue to simulate the stack operations.
For push operation, we add the new element to the queue and then rotate the queue such that the newly added element becomes the front element.
For pop operation, we simply remove the front element of the queue.
For top operation, we return the front element of the queue without removing it.
For empty operation, we check if the queue is empty.
This implementation simplifies the logic while still maintaining the required stack functionality. Let me know if you need further assistance!



In Java, offer() and poll() are methods provided by the Queue interface, which is implemented by classes such as LinkedList and PriorityQueue. Here's what they do:

offer(): This method is used to add an element to the end of the queue. It returns true if the element was successfully added to the queue, and false if the queue is full and the element could not be added. In the context of a stack implemented using a queue, offer() is used to add elements to the end of the queue.

poll(): This method is used to retrieve and remove the head of the queue (the element at the front of the queue). If the queue is empty, null is returned. In the context of a stack implemented using a queue, poll() is used to remove and return elements from the front of the queue.

In the simplified stack implementation provided earlier, offer() is used to add elements to the end of the queue, and poll() is used to remove and return elements from the front of the queue.
 */



 // ------------------------------  ANOTHER METHOD  -------------------------------


//  import java.util.LinkedList;
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


//-----------------Explanation of logic 3  same as first logic -----------------------


// We maintain two queues (queue1 and queue2) to simulate the stack operations.
// For push operation, we add the new element to queue2 and then move all elements from queue1 to queue2. Finally, we swap the references of queue1 and queue2.
// For pop operation, we simply remove the front element from queue1.
// For top operation, we return the front element of queue1.
// For empty operation, we check if queue1 is empty.