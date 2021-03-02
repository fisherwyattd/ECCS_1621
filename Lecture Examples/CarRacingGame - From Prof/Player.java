

public class Player {
    private String name;
    private Car ownedCar;

    public Player(){
        ownedCar = new Car();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setOwnedCar(Car ownedCar) {
        this.ownedCar = ownedCar;
    }
    public void setOwnedCar(int yr, String clr, double engSize, Car.CarType typ){
        ownedCar.setYear(yr);
        ownedCar.setColor(clr);
        ownedCar.setEngineSize(engSize);
        ownedCar.setType(typ);
    }
    public Car getOwnedCar() {
        return ownedCar;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name: " + name + ", ownedCar: " + ownedCar + "}";
    }
}
