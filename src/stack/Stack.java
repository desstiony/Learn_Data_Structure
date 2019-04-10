package stack;

/**
 * @description: Interface methods for the stack
 * @author: Mr.gong
 * @Data: 2019/4/9 14:33
 **/
public interface Stack<E> {
    /**
     * 入栈
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

    /**
     * 栈中元素的个数
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
