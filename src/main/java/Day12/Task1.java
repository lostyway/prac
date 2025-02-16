package Day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("BMW");
        list.add("Audi");
        list.add("Toyota");
        list.add("Lada");
        list.add("Granta");
        list.add(list.size() / 2, "middlecar");
        list.remove(0);
        System.out.println(list);
    }
}
