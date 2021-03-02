

public class Car {

    enum CarType{
        compact, minivan, suv, sport
    }

    private int year;
    private String color;
    private double engineSize;
    private CarType type;

    public Car(){
        year = 2020;
        color = "Red";
        engineSize = 1.8;
        type = CarType.compact;
    }
    public Car(int year, String clr, double engSize, CarType typ){
        this.year = year;
        color = clr;
        engineSize = engSize;
        type = typ;
    }
    // copy constructor
    public Car( Car cpCar){
        this.year = cpCar.year;
        this.color = cpCar.color;
        this.type = cpCar.type;
        this.engineSize = cpCar.getEngineSize();
    }

    public CarType getType() {
        return type;
    }
    public void setType(CarType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString(){
        return year + " : " + color + " : " + engineSize + " : " + type;
    }
}
