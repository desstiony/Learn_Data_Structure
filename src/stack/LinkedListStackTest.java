package stack;

import org.junit.Test;

/**
 * @description:
 * @author: Mr.gong
 * @Data: 2019/5/5 18:58
 **/
public class LinkedListStackTest {
    LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

    @Test
    public void linkedListStackTest() {
        for (int i = 0; i < 5; i++){
            linkedListStack.push(i);
            System.out.println("push " + linkedListStack);
        }
        linkedListStack.pop();
        System.out.println("pop " + linkedListStack);

        System.out.println("peek:" + linkedListStack.peek());

        int stackSize = linkedListStack.getSize();
        System.out.println("stack size is：" + stackSize);

        System.out.println("stack isEmpty：" + linkedListStack.isEmpty());
    }
}