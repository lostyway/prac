package Day9;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Vasya");
        Student student = new Student("Yura", "IS-41");
        Teacher teacher = new Teacher("Ilya", "Java");
        student.printInfo();
        teacher.printInfo();
        human.printInfo();
    }


}
