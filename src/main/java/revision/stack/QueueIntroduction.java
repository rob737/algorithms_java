package revision.stack;

/*
* Queue can also be implemented using an array.
* */
public class QueueIntroduction {
    private final int[] queue;
    private int front,rear;
    int size;

    public QueueIntroduction(int defaultCapacity) {
        queue = new int[defaultCapacity];
        front=0;
        rear=-1;
        size=defaultCapacity;
    }

    public void add(int val){
        if(rear < size)
            queue[++rear]=val;
        else
            System.out.println("Queue is full, remove some elements!");
    }

    public int remove(){
        if(front <= rear)
            return queue[front++];
        else
            System.out.println("Queue is empty, add some elements!");
        return 0;
    }

    public int peek(){
        if(front <= rear)
            return queue[front];
        else
            System.out.println("Queue is empty, add some elements!");
        return 0;
    }

    public static void main(String[] args) {
        QueueIntroduction queue = new QueueIntroduction(10);
        queue.add(2);
        queue.add(24);
        queue.add(-1);
        queue.add(13);
        System.out.println(queue.remove());//2
        System.out.println(queue.peek());//24
    }
}
