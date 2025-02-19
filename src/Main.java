import java.util.InputMismatchException;
import java.util.Scanner;

import static Vehicle.Air.*;
import static Vehicle.Car.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chose = -1;

        while (chose != 0) {
            System.out.print("Что вы хотите сделать? \n" +
                    "1 - добавить машину в коллекцию: \n" +
                    "2 - добавить самолет в коллекцию: \n" +
                    "3 - Найти стоимость и пробег определенного автомобиля: \n" +
                    "4 - Подсчитать налог с регистрации всех машин(5% от стоимости): \n" +
                    "5 - Узнать, прошел ли техосмотр владелец самой дорогой машины: \n" +
                    "6 - Найти мощность и максимальную высоту полета для определенного самолета: \n" +
                    "7 - Подсчитать налог с регистрации всех самолетов(3% от стоимости): \n" +
                    "8 - Определить мощность, марку и стоимость самого дорогого самолета: \n" +
                    "9 - Получить полную информацию обо всех автомобилях и самолетах: \n" +
                    "0 - Выйти\n");
            try {
                chose = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер

                switch (chose) {
                    case 1:
                        addCarToCollection(scanner);
                        break;
                    case 2:
                        addAirToCollection(scanner);
                        break;
                    case 3:
                        findPriceAndMileage(scanner);
                        break;
                    case 4:
                        checkCarTax();
                        break;
                    case 5:
                        hasPassedInspectionTheMostExpensiveCar(scanner);
                        break;
                    case 6:
                        findPowerAndMaxHighOfFlying(scanner);
                        break;
                    case 7:
                        checkAirTax();
                        break;
                    case 8:
                        checkPowerAndPriceAndBrandTheMostExpensiveAir(scanner);
                        break;
                    case 9:
                        printAllAirplanes();
                        printAllCars();
                        break;
                    case 0:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Пожалуйста, введите целое число.");
                scanner.nextLine(); // Очищаем буфер
            }
        }
        scanner.close();
    }
}
