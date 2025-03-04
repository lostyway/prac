package lessons;

import java.util.*;

public class HashSets {
    public static void main(String[] args) {

        Map<String, Double> grades = new HashMap<>();
        addStudents(grades);
        printStudent(grades);
        getAverageMark(grades);
    }

    public static void addStudents(Map<String, Double> map) {
        Map<String, Double> result = new HashMap<>(map);
        map.put("Юрий Леонтьев", 4.5);
        map.put("Тимур Баймуха", 3.8);
        map.put("Сергей Какашка", 5.0);
        map.put("Влад Калашников", 4.2);
        map.put("Владимир Небратенко", 2.6);
    }

    public static void printStudent(Map<String, Double> map) {
        for (var key : map.keySet()) {
            System.out.println(key);
        }
    }

    public static void getAverageMark(Map<String, Double> map) {
        for (var avg : map.values()) {
            System.out.println(avg);
        }
    }
}
