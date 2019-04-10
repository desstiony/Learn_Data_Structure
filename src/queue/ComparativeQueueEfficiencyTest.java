package queue;

import org.junit.Test;

import java.util.Random;

/**
 * @description: 比较数组队列与循环队列出队效率
 * @author: Mr.gong
 * @Data: 2019/4/10 16:05
 **/
public class ComparativeQueueEfficiencyTest {

    /** 操作数量. */
    int opCount = 1000000;

    public double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }
    @Test
    public void comparativeQueueEfficiency(){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time is：" + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time is：" + time2 + "s");
        // ArrayQueue time is：4.02906685s
        // LoopQueue time is：0.013552659s
    }
}
