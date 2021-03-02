public class Player {
    private String name;
    private Car ownedCar; // aggregation (i.e. a player "has a" car)

    public Player() {
        ownedCar = new Car();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getOwnedCar() {
        return ownedCar;
    }

    public void setOwnedCar(Car ownedCar) { // receives an existing car
        this.ownedCar = ownedCar;
    }

    public void setOwnedCar(int yr, String clr, double engSize, Car.CarType typ) { // creates new car with given specs
        ownedCar.setYear(yr);
        ownedCar.setColor(clr);
        ownedCar.setEngineSize(engSize);
        ownedCar.setType(typ);
    }

    @Override
    public String toString() {
        return "Player {" + "name: " + name + ", ownedCar: " + ownedCar + "}";
    }
}
