package task1;

public abstract class Shape {
    public interface ShapeState {
        enum State implements ShapeState {
            OK("Shape is valid"),
            INVALID_MEASURES("MEASURES must be in range (0; +ENDLESS");

            private final String description;

            State(String description) {
                this.description = description;
            }

            @Override
            public String toString() {
                return String.format("%s %s", this.name(), this.description);
            }
        }
    }

    protected void throwOnInvalid() {
        var state = this.isValid();
        if(state != ShapeState.State.OK)
            throw new ShapeInvalidException(this, state);
    }
    protected abstract ShapeState isValid();

    public abstract double getArea();
}

