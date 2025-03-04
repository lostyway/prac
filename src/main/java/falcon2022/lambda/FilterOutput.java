package falcon2022.lambda;

import java.util.Scanner;
import java.util.List;

public class FilterOutput {
    private final CarService carService;
    private final Scanner scanner;

    public FilterOutput(CarService carService, Scanner scanner) {
        this.carService = carService;
        this.scanner = scanner;
    }

    public void showFilerMenu() {
        boolean isRunningFilter = true;
        while (isRunningFilter) {
            displayFilters();
            System.out.print("Ввод:");
            String choice = scanner.nextLine();
            int filterIndex;
            try {
                filterIndex = Integer.parseInt(choice) - 1;
                if (filterIndex >= 0 && filterIndex < Filters.values().length) {
                    Filters filter = Filters.values()[filterIndex];
                    CarIdentifier carIdentifier = createCar(filter);
                    if (carIdentifier != null) {
                        List<Car> result = carService.findCars(carIdentifier, filter);
                        System.out.println("Результаты по поиску: " + filter.getDescription() + " : ");
                        if (result.isEmpty()) {
                            System.out.println("Машины не найдены");
                        } else {
                            result.forEach(System.out::println);
                        }
                     }
                } else if (filterIndex == Filters.values().length) {
                    System.out.println("Выход в главное меню..");
                    isRunningFilter = false;
                } else {
                    System.out.println("Введите корректный номер фильтра");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный номер фильтра");
            }
        }
    }

    private void displayFilters() {
        System.out.println("Выберите фильтр:");
        Filters[] filters = Filters.values();
        for (int i = 0; i < filters.length; i++) {
            System.out.println((i + 1) + ". " + filters[i].getDescription());
        }
        System.out.println((filters.length + 1) + ". Назад");
    }

    private CarIdentifier createCar(Filters filter) {
        try {
            String number = null;
            int yearStart = -1;
            int yearFinish = -1;
            String color = null;

            switch (filter) {
                case NUMBER_FINDER -> {
                    System.out.print("Введите номер машины:");
                    number = scanner.nextLine();
                }
                case SUBNUMBER_FINDER -> {
                    System.out.print("Введите номер или часть номера машины:");
                    number = scanner.nextLine();
                }
                case COLOR_FINDER -> {
                    System.out.print("Введите цвет автомобиля:");
                    color = scanner.nextLine();
                }
                case YEAR_DIAPASON_FINDER -> {
                    System.out.print("Введите год выпуска авто с которого нужно искать:");
                    yearStart = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите год выпуска авто до которого нужно искать:");
                    yearFinish = Integer.parseInt(scanner.nextLine());
                }
            }
            return new CarIdentifier(number, yearStart, yearFinish, color);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при ввода данных для поиска автомобиля: " + e.getMessage());
            return null;
        }
    }
}
