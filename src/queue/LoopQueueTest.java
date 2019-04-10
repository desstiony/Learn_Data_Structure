package queue;

import org.junit.Test;

/**
 * @description:
 * @author: Mr.gong
 * @Data: 2019/4/10 16:00
 **/
public class LoopQueueTest {
    LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
    @Test
    public void loopQueueTest() {
        for (int i = 0; i < 10; i++){
            loopQueue.enqueue(i);
            System.out.println("enqueue " + loopQueue);
            if (i % 3 == 2){
                loopQueue.dequeue();
                System.out.println("dequeue " + loopQueue);
            }
        }
        System.out.println("getFront:" + loopQueue.getFront());

        int queueSize = loopQueue.getSize();
        System.out.println("queue size is：" + queueSize);

        System.out.println("queue isEmpty：" + loopQueue.isEmpty());
    }
}