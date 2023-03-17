package task1.paralelograms.rectangles;

public final class Square extends Rectangle {
    enum SquareState implements ShapeState {
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
    public ShapeState isValid() {
        return this.a == this.b ? ShapeState.State.OK : SquareState.WRONG_SQUARE_MEASURES;
    }
}
