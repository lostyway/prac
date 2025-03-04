package lessons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteObject implements Serializable {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Bob"));
        list.add(new Person(2, "Yuri"));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
            oos.writeObject(list);
            System.out.println("List успешно записан в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
