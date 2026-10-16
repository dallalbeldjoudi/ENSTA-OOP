public class Bus extends Vehicle {
    private int numberOfPassengers;

    public Bus(String brand, int speed, int year, String stateOfBrakes) {
        super(brand, year, speed, stateOfBrakes);
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void saveEnergy(String stateOfBrakes) {
        System.out.println("We are saving energy, the state of brakes must be distant!");
        String currentBrakes = getStateOfBrakes();

        if ("distant".equals(currentBrakes)) {
            System.out.println("Good, the brakes are already set!");
        } else {
            setStateOfBrakes("distant");
            System.out.println("Brakes are set to distant.");
        }
    }
}