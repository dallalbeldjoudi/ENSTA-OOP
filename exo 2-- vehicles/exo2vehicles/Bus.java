public class Bus extends Vehicle {
    private int numberOfPassengers;

    public Bus(String brand, int year, int speed, String stateOfBrakes, int numberOfPassengers) {
        super(brand, year, speed, stateOfBrakes);
        this.numberOfPassengers = numberOfPassengers;
    }

    // Decides how to save energy using its own characteristics (Req 3)
    @Override
    public void saveEnergy() {
        System.out.println("Bus transporting " + numberOfPassengers + " passengers is saving energy!");
        if ("distant".equals(getStateOfBrakes())) {
            System.out.println("Brakes are already set to distant.");
        } else {
            setStateOfBrakes("distant");
            System.out.println("Brakes set to distant for regenerative braking.");
        }
    }

    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }
}