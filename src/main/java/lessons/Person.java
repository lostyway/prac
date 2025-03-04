package lessons;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 8384267233206899259L;
    private int id;
    private String personName;
    private int age;
    private byte type;

    public Person(int id, String personName) {
        this.id = id;
        this.personName = personName;
    }

    public int getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return id + " : " + personName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return id == person.id && age == person.age && type == person.type && Objects.equals(personName, person.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personName, age, type);
    }

    public static void main(String[] args) {

    }
}
