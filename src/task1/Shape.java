package task1;

public interface Shape {
    interface ShapeState {}

    double getArea();
    void throwOnInvalid();
    ShapeState isValid();
}

