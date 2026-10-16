public class Vehicle {
    private String brand;
    private int year;
    private int speed;
    private String stateOfBrakes;

    public Vehicle(String brand, int year, int speed, String stateOfBrakes) {
        this.brand = brand;
        this.year = year;
        this.speed = speed;
        this.stateOfBrakes = stateOfBrakes;
    }

    // Getters and Setters using standard camelCase
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getStateOfBrakes() {
        return stateOfBrakes;
    }

    public void setStateOfBrakes(String stateOfBrakes) {
        this.stateOfBrakes = stateOfBrakes;
    }

    public int accelerate(int increment) {
        this.speed += increment;
        return this.speed;
    }
}