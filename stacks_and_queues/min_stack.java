/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/

public class MinStack {
    Stack<Integer> s;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int x) {
        if (s.isEmpty()) {
            min = x;
        }
        
        //push min before the actual value in case you pop the min later,
        //  this way you have 2nd min
        if (min >= x){
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if (s.isEmpty())
            return;
            
        int p = s.pop();
        
        //2nd pop is the 2nd min
        if (p == min) {
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;   
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

