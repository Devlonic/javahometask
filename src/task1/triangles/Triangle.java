package task1.triangles;

import task1.Shape;

public abstract class Triangle extends Shape {
    protected final double a;
    protected final double b;
    protected final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public ShapeState isValid() {
        if(this.a <= 0 || this.b <= 0)
            return ShapeState.State.INVALID_MEASURES;

        return ShapeState.State.OK;
    }
}