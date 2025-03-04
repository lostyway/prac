package falcon2022.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        try (Scanner input = new Scanner(System.in)){
            while (isRunning) {
                System.out.println("\t\tМеню:\n" +
                        "1. Поиск по гибкому фильтру.\n" +
                        "2. Выход");
                System.out.print("Ввод:");
                String value = input.nextLine();
                switch (value) {
                    case "1" -> viewOutput(createCar(input));
                    case "2" -> {
                        System.out.println("Выход...");
                        isRunning = false;
                    }
                    default -> System.out.println("Пожалуйста, введите корректное число.");
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static CarIdentifier createCar(Scanner input) {
        try {
            System.out.print("Введите номер машины:");
            String number = input.nextLine();
            System.out.print("Введите год выпуска авто с которого нужно искать:");
            int yearStart = Integer.parseInt(input.nextLine());
            System.out.print("Введите год выпуска авто до которого нужно искать:");
            int yearFinish = Integer.parseInt(input.nextLine());
            System.out.print("Введите цвет автомобиля:");
            String color = input.nextLine();
            return new CarIdentifier(number, yearStart, yearFinish, color);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при создании автомобиля: " + e.getMessage());
        }
        return null;
    }

    private static void viewOutput(CarIdentifier carIdentifier) {
        CarService carService = new CarService(initCars());
        System.out.println("Машина создана");
    }

    private static List<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10));
    }
}
