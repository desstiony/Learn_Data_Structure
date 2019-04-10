package queue;

import org.junit.Test;

/**
 * @description:
 * @author: Mr.gong
 * @Data: 2019/4/10 14:10
 **/
public class ArrayQueueTest {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    @Test
    public void arrayQueueTest() {
        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println("enqueue " + queue);
            if (i % 3 == 2){
                queue.dequeue();
                System.out.println("dequeue " + queue);
            }
        }
        System.out.println("getFront:" + queue.getFront());

        int queueSize = queue.getSize();
        System.out.println("queue size is：" + queueSize);

        System.out.println("queue isEmpty：" + queue.isEmpty());
    }
}