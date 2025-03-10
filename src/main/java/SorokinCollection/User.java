package SorokinCollection;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private Long UserId;

    public User(String name, int age, Long userId) {
        this.name = name;
        this.age = age;
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(UserId, user.UserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, UserId);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", UserId=" + UserId +
                '}';
    }
}
