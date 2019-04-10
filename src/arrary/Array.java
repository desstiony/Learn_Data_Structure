package arrary;

/**
 * @description: override array
 * @author: Mr.gong
 * @Data: 2019/3/30 11:43
 **/
public class Array<E> {
    /** 数组内容. */
    private E[] data;

    /** 数组元素个数. */
    private int size;

    /**
     * 构造array
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造函数 capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEnpty(){
        return size == 0;
    }

    /**
     * 获取index索引处的元素
     * @param index
     * @return
     */
    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    /**
     * 获取数组第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取数组最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改index索引处的元素
     * @param index
     * @param e
     */
    public void set(int index, E e){
        checkIndex(index);
        data[index] = e;
    }

    /**
     * 查询数组中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        checkIndex(index);
        //数组容量满了
        if (size == data.length){
            resize(data.length * 2);
        }
        for (int i = size -1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 数组扩容
     * @param capacity
     */
    private void resize(int capacity){
        //扩容,为原来的两倍
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 检查是否越界
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    /**
     * 向所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 查找数组中元素e所在的索引，不存在返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        checkIndexForRemove(index);
        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //缩容
        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 检查删除是否越界
     * @param index
     */
    private void checkIndexForRemove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }
    /**
     * 删除第一个元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e,有重复的e只删除一个e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('【');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append('】');
        return builder.toString();
    }
}
