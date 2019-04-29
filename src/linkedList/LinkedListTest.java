package linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @description: 时间复杂度 增删改查 O(n)
 * @author: Mr.gong
 * @Data: 2019/4/29 19:58
 **/
public class LinkedListTest {
    @Test
    public void linkedListTest(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.addLast(5);
        System.out.println("链表最后添加:" + linkedList);

        System.out.println("链表最后一个元素:" + linkedList.getLast());

        System.out.println("链表第一个元素:" + linkedList.getFirst());

        linkedList.add(2,666);
        System.out.println(linkedList);

        System.out.println("索引为3的元素:" + linkedList.get(3));

        linkedList.remove(2);
        System.out.println("移除索引为2的元素:" + linkedList);

        linkedList.removeFirst();
        System.out.println("移除第一个元素:" + linkedList);

        linkedList.removeLast();
        System.out.println("移除最后一个元素:" + linkedList);


    }
}