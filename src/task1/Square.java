package task1;

public class Square extends Rectangle {
    enum SquareState implements ShapeState {
        OK(""),
        WRONG_SQUARE_MEASURES("Square sides must be equal");

        private final String description;

        SquareState(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name(), this.description);
        }
    }

    public Square(double a, double b) {
        super(a, b);
        throwOnInvalid();
    }

    @Override
    public void throwOnInvalid() {
        var state = (ShapeState) this.isValid();
        if (state != SquareState.OK)
            throw new ShapeInvalidException(this, state);
    }

    @Override
    public ShapeState isValid() {
        return this.a == this.b ? SquareState.OK : SquareState.WRONG_SQUARE_MEASURES;
    }
}
