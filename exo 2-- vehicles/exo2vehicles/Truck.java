public class Truck extends Vehicle {
    private int weightOfLoad;

    public Truck(String brand, int speed, int year, String stateOfBrakes, int weightOfLoad) {
        super(brand, year, speed, stateOfBrakes);
        this.weightOfLoad = weightOfLoad;
    }

    public int getWeightOfLoad() {
        return weightOfLoad;
    }

    public void setWeightOfLoad(int weightOfLoad) {
        this.weightOfLoad = weightOfLoad;
    }

    public int saveEnergy(int speed) {
        System.out.println("The truck is saving energy, we need to slow down!");
        int newSpeed = getSpeed() - 20;
        setSpeed(newSpeed);
        return newSpeed;
    }
}