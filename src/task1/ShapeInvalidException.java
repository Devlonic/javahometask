package task1;

public class ShapeInvalidException extends RuntimeException {
    protected Shape shape;
    public ShapeInvalidException(Shape shape, Shape.ShapeState state) {
        super(String.format("%s", state));
        this.shape = shape;
    }
}
