package linkedList;

/**
 * @description: override linkedList
 * @author: Mr.gong
 * @Data: 2019/4/9 10:33
 **/
public class LinkedList<E> {
    private class Node<E> {
        private E e;
        private Node next;

        public Node(E e, Node next) {
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
        public String toString() {
            return e.toString();
        }
    }

    /** 虚拟头节点. */
    private Node dummyHead;
    private int size;
    // private Node head;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
        // head = null;
    }

    /**
     * 获取链表中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加新元素e
     * @param e
     */
    public void addFirst(E e){
        // Node node = new Node(e);
        // node.next = head;
        // head = node;

        // head = new Node(e,head);
        // size++;

        add(0, e);
    }

    /**
     * 在链表尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在链表的index(0-based)位置添加e(不常用操作,学习使用)
     * @param index
     * @param e
     */
    // public void add(int index, E e){
    //     if(index < 0 || index > size) {
    //         throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
    //     }
    //
    //     if (index == 0 ){
    //         addFirst(e);
    //     }else {
    //         // 查找当前索引index的前一个节点, 因为头结点0,特殊处理了 少遍历了0 所以减1
    //         Node prev = new Node();
    //         for (int i = 0; i < index - 1; i++){
    //             prev = prev.next;
    //         }
    //         // 顺序很重要
    //         // Node node = new Node(e);
    //         // node.next = prev.next;
    //         // prev.next = node;
    //         prev.next = new Node(e,prev.next);
    //         size ++;
    //     }
    // }

    /**
     * 添加元素e, 基于虚拟头节点实现
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        // 虚拟头结点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        // 顺序很重要
        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 根据索引获取元素(练习使用)
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return (E) cur.e;
    }

    /**
     * 获取第一个元素
     * @param
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @param
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 在index处插入元素e(练习使用)
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 链表中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除index处的元素(练习使用)
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        // 当前要删除的节点 (即 找到的要删除节点的前一个节点的 下一个节点)
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return (E) delNode.e;
    }

    /**
     * 删除第一个元素
     * @param
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @param
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
