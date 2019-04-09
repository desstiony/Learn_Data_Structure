package arrary;
/**
 * @description: 测试array
 * @author: Mr.gong
 * @Data: 2019/3/30 11:43
 **/
public class TestArray {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, -11);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.remove(5);
        System.out.println(arr);

        Array<Student> array = new Array<>();
        array.addLast(new Student("小明", 100));
        array.addLast(new Student("小红", 98));
        array.addLast(new Student("小白", 59));
        array.addLast(new Student("小黄", 78));
        System.out.println(array);
    }
}
