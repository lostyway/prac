package falcon2022.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;

public class Main {
    public static void main(String[] args) {
        boolean isRunningMain = true;
        CarService carService = new CarService(initCars());
        try (Scanner input = new Scanner(System.in)) {
            FilterOutput filterOutput = new FilterOutput(carService, input);
            while (isRunningMain) {
                showMainMenu();
                System.out.print("Ввод:");
                Integer value = Integer.parseInt(input.nextLine());
                switch (value) {
                    case 1 -> filterOutput.showFilerMenu();
                    case 2 -> {
                        System.out.println("Выход...");
                        isRunningMain = false;
                    }
                    default -> System.out.println("Пожалуйста, введите корректный номер фильтра");
                }
                ;
            }
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка в Main при вводе: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла глобальная ошибка в Main: " + e.getMessage());
        }
    }

    private static void showMainMenu() {
        System.out.println("\t\tМеню");
        List.of("1. Поиск по гибкому меню", "2. Выход").forEach(System.out::println);
    }

    private static List<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car13 = new Car("RR-333-RR", 2012, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "red", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car13));
    }
}
