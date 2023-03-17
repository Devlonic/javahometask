package task1;

public abstract class Triangle implements Shape {
    protected final double a;
    protected final double b;
    protected final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}