import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a polymorphic list that holds Vehicle objects
        List<Vehicle> fleet = new ArrayList<>();

        // Add specific subclass instances to the generic Vehicle list
        fleet.add(new Bus("Volvo", 2022, 50, "close", 40));
        fleet.add(new Truck("Volvo", 2021, 80, "good", 15000));

        System.out.println("=== Transport Company Vehicle ===");
        System.out.println();

        // Loop through all vehicles using the common Vehicle interface
        for (Vehicle v : fleet) {
            System.out.println("Vehicle Brand: " + v.getBrand() + " (" + v.getYear() + ")");
            System.out.println("Initial Speed: " + v.getSpeed() + " km/h");
            
            // Polymorphic call: Java automatically calls the correct version 
            // of saveEnergy() depending on whether 'v' is a Bus or a Truck!
            v.saveEnergy();
            
            System.out.println("----------------------------------------");
        }
    }
}