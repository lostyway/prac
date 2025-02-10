package lessons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(10);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(2));
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
    }
}
