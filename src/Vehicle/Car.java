package Vehicle;

import IVehicle.ICar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car extends Characteristics implements ICar {
    private int mileage;
    private boolean hasTechnicalInspectionPassed;
    private static List<Characteristics> vehicleCharacteristics = new ArrayList<>();

    public Car(int powerInHorseStrength, int price, String numberOfVehicle, String brand, int mileage, boolean hasTechnicalInspectionPassed) {
        super(powerInHorseStrength, price, numberOfVehicle, brand);
        this.mileage = mileage;
        this.hasTechnicalInspectionPassed = hasTechnicalInspectionPassed;
    }

    @Override
    public void addCarToArray()
    {
        vehicleCharacteristics.add(this);
    }

    @Override
    public int getMileage()
    {
        return mileage;
    }

    public static void addCarToCollection(Scanner scanner) {
        System.out.print("Введите мощность в л.с.: ");
        int power = scanner.nextInt();
        System.out.print("Введите цену: ");
        int price = scanner.nextInt();
        System.out.print("Введите номер автомобиля: ");
        String number = scanner.next();
        System.out.print("Введите марку автомобиля: ");
        // Проверка на уникальность номера
        for (Characteristics vehicle : vehicleCharacteristics) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                if (car.getNumberOfVehicle().equals(number)) {
                    System.out.println("Ошибка: Автомобиль с таким номером уже существует.");
                    return; // Завершаем метод, если номер уже есть
                }
            }
        }
        String brand = scanner.next();
        System.out.print("Введите пробег: ");
        int mileage = scanner.nextInt();
        System.out.print("Прошел ли техосмотр? (true/false): ");
        boolean hasPassedInspection = scanner.nextBoolean();
        Car car = new Car(power, price, number, brand, mileage, hasPassedInspection);
        car.addCarToArray();
        System.out.println("Машина добавлена в коллекцию.");
    }

    public static void checkCarTax(){
        double totalTax = 0;
        for(Characteristics vehicle : vehicleCharacteristics) {
            if(vehicle instanceof Car) {
                Car car = (Car) vehicle;
                double tax = car.getPrice() * 0.05;
                totalTax += tax;
                String number = car.getNumberOfVehicle();
                System.out.println("Автомобиль: " + number + " , налог " + tax);
            }
        }
        System.out.println("Общий налог: " + totalTax);
    }

    public String getNumberOfVehicle() {
        return super.getNumberOfVehicle();
    }

    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public boolean isHasTechnicalInspectionPassed() {
        return hasTechnicalInspectionPassed;
    }

    public static void hasPassedInspectionTheMostExpensiveCar(Scanner scanner) {
        boolean hasPassedInspection = false;
        int theBiggestPrice = 0;
        String number = null;
        for(Characteristics vehicle : vehicleCharacteristics) {
            if(vehicle instanceof Car)
            {
                Car car = (Car) vehicle;
                if(car.getPrice() > theBiggestPrice) {
                    theBiggestPrice = car.getPrice();
                    number = car.getNumberOfVehicle();
                    hasPassedInspection = car.isHasTechnicalInspectionPassed();
                }
            }
        }
        System.out.println("Владелец " + number + " с самой дорогой стоимостью " + theBiggestPrice
                + " прошел тех.осмотр: " + hasPassedInspection);
    }

    public static void findPriceAndMileage(Scanner scanner) {
        System.out.println("Введите номер машины: ");
        String number = scanner.nextLine();
        boolean found = false;
        for(Characteristics vehicle : vehicleCharacteristics) {
            if(vehicle instanceof Car) { //Проверяем, является ли объект автомобилем
                Car car = (Car) vehicle; //Приводим к типу Car
                if(car.getNumberOfVehicle().equals(number))
                {
                    System.out.println("Номер: " + car.getNumberOfVehicle());
                    System.out.println("Цена: " + car.getPrice());
                    System.out.println("Пробег: " + car.getMileage());
                    found = true;
                    break;
                }
            }
        }
        if(!found) {
            System.out.println("Машины не найдено.");
        }
    }

    public static void printAllCars() {
        if (vehicleCharacteristics.isEmpty()) {
            System.out.println("Нет доступных автомобилей.");
            return;
        }

        for (Characteristics vehicle : vehicleCharacteristics) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle; // Приводим к типу Car
                System.out.println("Номер: " + car.getNumberOfVehicle() +
                        ", Марка: " + car.getBrand() +
                        ", Цена: " + car.getPrice() +
                        ", Мощность: " + car.getPowerInHorseStrength() +
                        ", Пробег: " + car.getMileage() +
                        ", Прошел техосмотр: " + car.isHasTechnicalInspectionPassed());
            }
        }
    }
}
