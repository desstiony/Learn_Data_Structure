package stack;

import org.junit.Test;

/**
 * @description:
 * @author: Mr.gong
 * @Data: 2019/4/9 15:04
 **/
public class ArrayStackTest {
    ArrayStack<Integer> stack = new ArrayStack<>();

    @Test
    public void arrayStackTest() {
        for (int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println("push " + stack);
        }
        stack.pop();
        System.out.println("pop " + stack);

        System.out.println("peek:" + stack.peek());

        int stackSize = stack.getSize();
        System.out.println("stack size is：" + stackSize);

        System.out.println("stack isEmpty：" + stack.isEmpty());
    }

}