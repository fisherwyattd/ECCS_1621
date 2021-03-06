import java.util.Objects;

public class ComplexNumbers {
    private double real;
    private double imaginary;

    public ComplexNumbers() {}

    public ComplexNumbers(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return "(" + getReal() + "," + getImaginary() + "i)";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof ComplexNumbers) {
            if(((ComplexNumbers) obj).getReal() == this.getReal() &&
            ((ComplexNumbers) obj).getImaginary() == this.getImaginary())
                return true;
            else
                return false;
        }
        else
            return false;

    }

    public static void main(String[] args) {

        ComplexNumbers c1 = new ComplexNumbers(4, 4);
        ComplexNumbers c2 = new ComplexNumbers();

        c2.setImaginary(4);
        c2.setReal(4);

        String complexStr = c1.toString();
        System.out.println("c1 = " + complexStr);

        complexStr = c2.toString();
        System.out.println("c2 = " + complexStr);

        if(c1.equals(c2))
            System.out.println("c1 and c2 are equal");
        else
            System.out.println("c1 and c2 are NOT equal");

        c2.setImaginary(7);
        c2.setReal(3);

        complexStr = c1.toString();
        System.out.println("c1 = " + complexStr);

        complexStr = c2.toString();
        System.out.println("c2 = " + complexStr);

        if(c1.equals(c2))
            System.out.println("c1 and c2 are equal");
        else
            System.out.println("c1 and c2 are NOT equal");
    }
}
