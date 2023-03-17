package task1.paralelograms;

import task1.Shape;

public abstract class Parallelogram extends Shape {
    enum ParallelogramState implements ShapeState {
        INVALID_ANGLES("ANGLES sum must be equal 360");

        private final String description;

        ParallelogramState(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name(), this.description);
        }
    }

    protected final double a;
    protected final double b;

    protected final double angleDegreeAlpha;
    protected final double angleDegreeBeta;

    public Parallelogram(double a, double b, double angleDegreeAlpha, double angleDegreeBeta) {
        this.a = a;
        this.b = b;
        this.angleDegreeAlpha = angleDegreeAlpha;
        this.angleDegreeBeta = angleDegreeBeta;

        throwOnInvalid();
    }

    @Override
    public ShapeState isValid() {
        if((this.angleDegreeAlpha + this.angleDegreeBeta) * 2 != 360)
            return ParallelogramState.INVALID_ANGLES;

        if(this.a <= 0 || this.b <= 0)
            return ShapeState.State.INVALID_MEASURES;

        return ShapeState.State.OK;
    }
}
