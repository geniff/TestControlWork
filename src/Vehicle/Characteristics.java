package Vehicle;

public class Characteristics {
    private int powerInHorseStrength;
    private int price;
    private String numberOfVehicle;
    private String brand;
    public Characteristics(int powerInHorseStrength, int price, String numberOfVehicle, String brand) {
        this.powerInHorseStrength = powerInHorseStrength;
        this.brand = brand;
        this.price = price;
        this.numberOfVehicle = numberOfVehicle;
    }

    public int getPowerInHorseStrength() {
        return powerInHorseStrength;
    }

    public int getPrice() {
        return price;
    }

    public String getNumberOfVehicle() {
        return numberOfVehicle;
    }

    public String getBrand() {
        return brand;
    }
}
