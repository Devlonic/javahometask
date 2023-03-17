package task1;

public class RightTriangle extends Triangle {
    enum RightTriangleState implements ShapeState {
        OK(""),
        INVALID_MEASURES("MEASURES must be in range (0; +ENDLESS");

        private final String description;

        RightTriangleState(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name(), this.description);
        }
    }

    private static double getHypotenuse(double legA, double legB) {
        return Math.sqrt((Math.pow(legA, 2) + Math.pow(legB, 2)));
    }

    public RightTriangle(double legA, double legB) {
        super(legA, legB, getHypotenuse(legA, legB));
        this.throwOnInvalid();
    }

    @Override
    public ShapeState isValid() {
        return this.a > 0 && this.b > 0 ? RightTriangleState.OK : RightTriangleState.INVALID_MEASURES;
    }
    @Override
    public void throwOnInvalid() {
        var state = (RightTriangleState)this.isValid();
        if(state != RightTriangleState.OK)
            throw new ShapeInvalidException(this, state);
    }

    @Override
    public double getArea() {
        if(this.a != 0 && this.b != 0)
            return (0.5d * a * b);
        else
            throw new UnsupportedOperationException();
    }
}

