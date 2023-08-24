package revision.stack;

public class CircularQueue {

    private final int[] queue;
    private int size;
    private int front,rear;

    public CircularQueue(int defaultCapacity) {
        this.size = defaultCapacity;
        queue = new int[defaultCapacity];
        front=-1;
        rear=-1;
    }

    // Need to think on initial values of front and rear, current values will incorrectly leave last index empty.
    public void add(int val){
        if(((rear+1) % size) == front)
            System.out.println("Queue is full");
        else{
            if(front == -1)
                front = 0;
            rear = (rear+1) % size;
            queue[rear] = val;
        }
    }

    public int remove(){
        if(front == rear){
            System.out.println("Queue is empty!");
            return 0;
        }

        int val = queue[(front)];
        front = (front + 1) % size;
        return val;
    }

    public int peek(){
        if(front == rear){
            System.out.println("Queue is empty!");
            return 0;
        }
        return queue[front];
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);

        System.out.println(queue.peek());

        System.out.println(queue.remove());

        System.out.println(queue.peek());
    }
}
