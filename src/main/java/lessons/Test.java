package lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            if (idx == 1) {
                iterator.remove();
            }
            iterator.next();
            idx++;
        }

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);

        startTime = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        Iterator<Integer> iteratorLinked = linkedList.iterator();
        int index = 0;
        while (iteratorLinked.hasNext()) {
            if (index == 1) {
                iteratorLinked.remove();
            }
            iteratorLinked.next();
            index++;
        }

        finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}