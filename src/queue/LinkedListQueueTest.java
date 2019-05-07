package queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: Mr.gong
 * @Data: 2019/5/7 9:04
 **/
public class LinkedListQueueTest {
    LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
    @Test
    public void linkedListQueueTest(){
        for (int i = 0; i < 10; i++){
            linkedListQueue.enqueue(i);
            System.out.println("enqueue " + linkedListQueue);
            if (i % 3 == 2){
                linkedListQueue.dequeue();
                System.out.println("dequeue " + linkedListQueue);
            }
        }
        System.out.println("getFront:" + linkedListQueue.getFront());

        int queueSize = linkedListQueue.getSize();
        System.out.println("queue size is：" + queueSize);

        System.out.println("queue isEmpty：" + linkedListQueue.isEmpty());
    }
}