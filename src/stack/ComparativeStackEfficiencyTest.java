package stack;

import org.junit.Test;

import java.util.Random;

/**
 * @description: 比较数组栈与链表栈入栈出栈效率
 * @author: Mr.gong
 * @Data: 2019/5/6 20:34
 **/
public class ComparativeStackEfficiencyTest {
    /** 操作数量. */
    int opCount = 1000000;

    public double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;

    }
    @Test
    public void comparativeQueueEfficiency(){
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack time is：" + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack time is：" + time2 + "s");

        // ArrayStack time is：0.103198632s
        // LinkedListStack time is：0.328848217s
    }


}
