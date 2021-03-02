public class Car {

    enum CarType { // don't need to use "" (doesn't need to be a string) because these are our own keywords
        compact, minivan, SUV, sport
    }

    private int year;
    private String color;
    private double engineSize;
    private CarType type;

    public Car() {
        year = 2020;
        color = "Red";
        engineSize = 1.8;
        type = CarType.compact;
    }

    public Car(int yr, String clr, double engSize, CarType typ) {
        year = yr;
        color = clr;
        engineSize = engSize;
        type = typ;
    }

    public Car(Car cpCar) { // copy constructor
        this.year = cpCar.year; // could also use the getter for these fields
        this.color = cpCar.color;
        this.type = cpCar.type;
        this.engineSize = cpCar.engineSize;
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
    public String toString() {
        return year + " : " + color + " : " + engineSize + " : " + type;
    }


}
