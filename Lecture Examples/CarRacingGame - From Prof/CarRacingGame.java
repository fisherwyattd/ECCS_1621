public class CarRacingGame {

    public static void startRacing(Player p1, Player p2){
        // write the code here
        if(p1.getOwnedCar().getType() == Car.CarType.sport && p2.getOwnedCar().getType() != Car.CarType.sport)
            System.out.println("The winner is: " + p1.getName());
        else if(p1.getOwnedCar().getType() == Car.CarType.suv && p2.getOwnedCar().getType() != Car.CarType.sport &&
                p2.getOwnedCar().getType() != Car.CarType.suv)
            System.out.println("The winner is: " + p1.getName());
        else if(p1.getOwnedCar().getType() == Car.CarType.minivan && p2.getOwnedCar().getType() == Car.CarType.compact)
            System.out.println("The winner is: " + p1.getName());
        else if(p1.getOwnedCar().getType() == p2.getOwnedCar().getType()) {
            if(p1.getOwnedCar().getEngineSize() > p2.getOwnedCar().getEngineSize())
                System.out.println("The winner is: " + p1.getName());
            else if(p1.getOwnedCar().getEngineSize() < p2.getOwnedCar().getEngineSize())
                System.out.println("The winner is: " + p2.getName());
            else if(p1.getOwnedCar().getEngineSize() == p2.getOwnedCar().getEngineSize())
                System.out.println("The cars are the same type and have the same engine size!\n" +
                        "The winner is: " + p1.getName());
        }
        else
            System.out.println("The winner is: " + p2.getName());
    }


    public static void main(String[] args) {

        Car car1 = new Car();

        //System.out.println("Car1 Details:" + car1);

        Player p1 = new Player();
        Player p2 = new Player();


        p1.setName("Jim");
        p1.setOwnedCar(1990, "Black", 3.6, Car.CarType.suv);

        p2.setName("Tim");
        p2.setOwnedCar(2020, "Black", 3.6, Car.CarType.compact);

        System.out.println("Player1:" + p1);
        System.out.println("Player2:" + p2);

        Car car2 = new Car( car1 );
        //System.out.println("Car2: " + car2);

        //System.out.println("Player1 car is:" + p1.getOwnedCar());
        //System.out.println("Player1 car (year only) is:" + p1.getOwnedCar().getYear());

        startRacing(p1, p2);

    }
}
