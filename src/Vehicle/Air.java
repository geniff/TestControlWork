package Vehicle;

import IVehicle.IAir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Air extends Characteristics implements IAir {
    private int maxHighOfFlying;
    private static List<Characteristics> airCharacteristicsList = new ArrayList<>();
    public Air(int powerInHorseStrength, int price, String numberOfVehicle, String brand, int maxHighOfFlying) {
        super(powerInHorseStrength, price, numberOfVehicle, brand);
        this.maxHighOfFlying = maxHighOfFlying;
    }

    public static void addAirToCollection(Scanner scanner) {
        System.out.print("Введите мощность в л.с.: ");
        int power = scanner.nextInt();
        System.out.print("Введите цену: ");
        int price = scanner.nextInt();
        System.out.print("Введите номер самолета: ");
        String number = scanner.next();
        System.out.print("Введите марку самолета: ");
        String brand = scanner.next();
        System.out.print("Введите максимальную высоту полета: ");
        int mileage = scanner.nextInt();
        Air air = new Air(power, price, number, brand, mileage);
        air.addAirToList();
        System.out.println("Самолет добавлен в коллекцию.");
    }

    @Override
    public void addAirToList()
    {
        airCharacteristicsList.add(this);
    }

    @Override
    public int getMaxHighOfFlying() {
        return maxHighOfFlying;
    }

    public static void findPowerAndMaxHighOfFlying(Scanner scanner) {
        System.out.println("Введите номер самолета: ");
        String number = scanner.nextLine();
        boolean found = false;
        for(Characteristics vehicle : airCharacteristicsList) {
            if(vehicle instanceof Air) { //Проверяем, является ли объект автомобилем
                Air air = (Air) vehicle; //Приводим к типу Car
                if(air.getNumberOfVehicle().equals(number))
                {
                    System.out.println("Номер: " + air.getNumberOfVehicle());
                    System.out.println("Цена: " + air.getPrice());
                    System.out.println("Пробег: " + air.maxHighOfFlying);
                    found = true;
                    break;
                }
            }
        }
    }
}
