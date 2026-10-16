public class Truck extends Vehicle {
    private int weightOfLoad;

    public Truck(String brand, int year, int speed, String stateOfBrakes, int weightOfLoad) {
        super(brand, year, speed, stateOfBrakes);
        this.weightOfLoad = weightOfLoad;
    }

    // Decides how to save energy using its own characteristics (Req 3)
    @Override
    public void saveEnergy() {
        System.out.println("Truck carrying " + weightOfLoad + " kg load is saving energy!");
        int newSpeed = getSpeed() - 20;
        setSpeed(newSpeed);
        System.out.println("Speed reduced to maintain steady momentum: " + getSpeed() + " km/h");
    }

    public int getWeightOfLoad() { return weightOfLoad; }
    public void setWeightOfLoad(int weightOfLoad) { this.weightOfLoad = weightOfLoad; }
}