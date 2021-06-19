package amazon.circular.queue;
class MyCircularQueue {

    private int[] q;
    private int front, rear, capacity, cnt;
    public MyCircularQueue(int k) {
        capacity = k;
        q = new int[k];
        front = 0;
        cnt = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        q[(front+cnt)%capacity] = value;
        cnt++;
//        rear = (rear+1)%capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        cnt--;
        front = (front+1)%capacity;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[(front+cnt-1)%capacity];
    }

    public boolean isEmpty() {
        return cnt==0;
    }

    public boolean isFull() {
        return cnt == capacity;
//        return (rear+1)%capacity == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class Main {
}
