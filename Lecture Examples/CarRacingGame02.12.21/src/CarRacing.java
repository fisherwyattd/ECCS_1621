public class CarRacing {

    /**
     * This method contains the racing (comparison) feature of the game.
     * @param p1 The first player racing.
     * @param p2 The second player racing.
     */
    public static void startRacing(Player p1, Player p2) {
        System.out.println("The winner is:...");
        if(p1.getOwnedCar().getType() > p2.getOwnedCar().getType()) {

        }
    }

    public static void main(String[] args) {
        Car car1 = new Car();

        System.out.println("Car1 Details: " + car1);

        Player p1 = new Player();
        Player p2 = new Player();

        p1.setName("Jim");
        p1.setOwnedCar(1990, "Black", 3.6, Car.CarType.sport);

        p1.setName("Tim");
        p1.setOwnedCar(2020, "Black", 3.6, Car.CarType.minivan);

        System.out.println("Player1: " + p1);

        Car car2 = new Car(car1);

        System.out.println("Car2 Details: " + car2);

        System.out.println("Player1 Car Details: " + p1.getOwnedCar());

        startRacing(p1, p2);
    }
}
