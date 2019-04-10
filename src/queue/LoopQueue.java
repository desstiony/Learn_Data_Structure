package queue;

/**
 * @description: 循环队列
 * @author: Mr.gong
 * @Data: 2019/4/10 14:39
 **/
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 队列大小
     * @return
     */
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        // 判断队列是否已满
        if ((tail + 1) % data.length == front){
            // 扩容z
            resize(getCapacity() * 2);
        }

        // 入队
        data[tail] = e;
        // 后移一位tail
        tail = (tail + 1) % data.length;
        // 队列元素数量加一
        size ++;
    }


    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        // 判断队列是否为空
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        // 出队
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0 ){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue size = %d, capacity = %d \n", size, getCapacity()));
        builder.append("front【");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            builder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("】 tail");
        return builder.toString();
    }
}
