### 学习数据结构
动手自己实现一遍基本的数据结构
完成数组，链表，栈(链表和数组实现)，队列(两边和数组实现，包括循环队列),并比较效率.
## Stack
```
interface Stack<E>
void push<E>
E pop()
E peek()
int getSize()
boolean isEmpty()
void enqueue(E e);
```
## Queue
```
interface Queue<E>
void enqueue(E e);
E dequeue();
E getFront();
int getSize();
boolean isEmpty();
```
