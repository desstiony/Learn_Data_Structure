package queue;

/**
 * @description: queue
 * @author: Mr.gong
 * @Data: 2019/4/10 13:57
 **/
public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 得到队首的元素
     * @return
     */
    E getFront();

    /**
     * 队列中元素的个数
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

}
