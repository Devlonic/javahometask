package task1.paralelograms.rectangles;

import task1.paralelograms.Parallelogram;

public class Rectangle extends Parallelogram {
    public Rectangle(double a, double b) {
        super(a, b, 90, 90);
    }

    @Override
    public double getArea() {
        return a * b;
    }
}

