//通过stack改编的队列
class MyQueue {
    Stack<Integer> s = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    Stack<Integer> s1 = new Stack<Integer>();
        while(!s.isEmpty()){
            s1.push(s.pop());
        }
        s.push(x);
        while(!s1.isEmpty()){
            s.push(s1.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        int pop = s.pop();
        s.push(pop);
        return pop;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty();
    }
}
