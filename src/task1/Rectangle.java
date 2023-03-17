package task1;

public class Rectangle implements Shape {
    enum RectangleState implements ShapeState {
        OK(""),
        INVALID_MEASURES("MEASURES must be in range (0; +ENDLESS");

        private final String description;

        RectangleState(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name(), this.description);
        }
    }

    protected final double a;
    protected final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;

        throwOnInvalid();
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public void throwOnInvalid() {
        var state = (RectangleState)this.isValid();
        if(state != RectangleState.OK)
            throw new ShapeInvalidException(this, state);
    }

    @Override
    public ShapeState isValid() {
        return this.a > 0 && this.b > 0 ? RectangleState.OK : RectangleState.INVALID_MEASURES;
    }
}

