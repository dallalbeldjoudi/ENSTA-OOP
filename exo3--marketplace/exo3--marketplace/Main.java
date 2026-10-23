import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Marketplace!");

        // Create target account
        Marketplace targetUser = new Send(0, "Target User", "USER_99", 500.0f);

        List<Marketplace> fleet = new ArrayList<>();
        fleet.add(new Send(100.0f, "Send Service", "ACC_01", 150.0f));
        fleet.add(new Receive(200.0f, "Receive Service", "ACC_02", 75.0f));

        for (Marketplace m : fleet) {
            System.out.println("Service: " + m.getName() + ", ID: " + m.getId() + ", Current Balance: " + m.getCurrentBalance());
            m.transaction(targetUser);
            System.out.println("New Balance: " + m.getCurrentBalance());
            System.out.println("-----------------------------------");
        }
    }
}
