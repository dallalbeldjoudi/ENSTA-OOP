## Notes on abstracting a class:
when we abstract a class we cannot create a new onbject from that type for example: 
>Vehicle v = new Vehicle(...);  because vehicl is theorical

- the abstract keyword makes the other classes like bus and truck depending on vehicle

## When do we use fleet?
- when we have few classes to make :
>Vehicle v1 = new Bus("Volvo", 2022, 50, "close", 40);
>Vehicle v2 = new Truck("Volvo", 2021, 80, "good", 15000);

> v1.saveEnergy(); // Runs Bus version
> v2.saveEnergy(); // Runs Truck version

- when we have too many classes to make:
we use fleet:
fleet is just a container (like a box) used when you have many vehicles and want to process them all together in a single loop instead of managing separate variables (bus1, bus2, truck1, truck2, etc.).

creating new classes:
> fleet.add(new Bus("Volvo", 2022, 50, "close", 40));
> fleet.add(new Truck("Volvo", 2021, 80, "good", 15000));
this loop iterates through the alr created classes:
>for (Vehicle v : fleet) {
>           System.out.println("Vehicle Brand: " + v.getBrand() + " (" + v.getYear() + ")");
>            System.out.println("Initial Speed: " + v.getSpeed() + " km/h");  }