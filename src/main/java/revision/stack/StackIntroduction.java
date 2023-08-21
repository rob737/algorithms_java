package revision.stack;

/*
* Implement Stack without using inbuilt collections.
* Note: Stack internally uses array.
* */
public class StackIntroduction {
    final int[] stack;
    final int size;
    private int top;

     StackIntroduction(int defaultCapacity) {
        this.size = defaultCapacity;
        this.stack = new int[this.size];
        this.top = -1;
    }

    public void push(int val){
        if(top<size)
            stack[++top] = val;
        else
            System.out.println("Stack is full, please pop out some elements!");
    }

    public int pop(){
        if(top>0)
            return stack[top--];
        else
            System.out.println("Stack is empty, nothing to pop!!");
        return 0;
    }

    public int peek(){
        if(top >= 0)
            return stack[top];
        else
            System.out.println("Stack is empty!");
        return 0;
    }

    public static void main(String[] args) {
        StackIntroduction stack = new StackIntroduction(10);
        stack.push(34);
        stack.push(12);
        stack.push(-12);
        stack.push(17);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
