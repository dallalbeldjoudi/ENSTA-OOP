public class Main {
    public static void main(String[] args) {
        // Instantiate a Bus
        Bus cityBus = new Bus("Volvo", 50, 2022, "close");
        cityBus.setNumberOfPassengers(40);

        System.out.println("--- Bus Operations ---");
        System.out.println("Brand: " + cityBus.getBrand() + " | Passengers: " + cityBus.getNumberOfPassengers());
        cityBus.saveEnergy(cityBus.getStateOfBrakes());

        System.out.println();

        // Instantiate a Truck
        Truck cargoTruck = new Truck("Volvo", 80, 2021, "good", 15000);

        System.out.println("--- Truck Operations ---");
        System.out.println("Brand: " + cargoTruck.getBrand() + " | Load Weight: " + cargoTruck.getWeightOfLoad() + " kg");
        System.out.println("Original Speed: " + cargoTruck.getSpeed() + " km/h");

        int newSpeed = cargoTruck.saveEnergy(cargoTruck.getSpeed());
        System.out.println("Speed after saving energy: " + newSpeed + " km/h");
    }
}