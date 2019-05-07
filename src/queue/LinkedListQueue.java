package queue;

/**
 * @description: 基于链表实现的队列(包含头节点 ， 尾节点 ）
 * @author: Mr.gong
 * @Data: 2019/5/6 20:59
 **/
public class LinkedListQueue<E> implements Queue<E>{
    private class Node<E>{
        private E e;
        private Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * 由于队列尾结点出队不容易，入队容易
     * 所以让尾结点作为队列的首部 入队，头结点
     * 作为队列的尾部 出队
     */

    /** 头结点. **/
    private Node head;
    /** 尾结点. **/
    private Node tail;
    /** 队列大小. **/
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        // 队列尾部出队，要出队的元素即队列的尾部 = head
        Node retNode = head;
        // 出队以后，此时的head就变为了要出队元素的下一个结点
        head = retNode.next;
        retNode.next = null;
        // 如果只有一个元素 head出队以后要将tail也置空
        if (head == null) {
            tail = null;
        }
        size --;
        return (E) retNode.e;
    }

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return (E) head.e;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail ");
        return res.toString();
    }
}
