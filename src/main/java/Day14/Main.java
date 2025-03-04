package Day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day14");
        printSumDigits(file);
    }

    public static void printSumDigits(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            if (array.length != 10) {
                throw new IllegalArgumentException("Неверный формат файла");
            }

            int sum = 0;
            for (String i : array) {
                sum += Integer.parseInt(i); // Может выбросить NumberFormatException
            }

            System.out.println("Сумма чисел: " + sum);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не был найден");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Файл содержит некорректные данные");
        }
    }
}
