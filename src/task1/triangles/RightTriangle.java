package task1.triangles;

public final class RightTriangle extends Triangle {
    private static double getHypotenuse(double legA, double legB) {
        return Math.sqrt((Math.pow(legA, 2) + Math.pow(legB, 2)));
    }

    public RightTriangle(double legA, double legB) {
        super(legA, legB, getHypotenuse(legA, legB));
        this.throwOnInvalid();
    }

    @Override
    public double getArea() {
        if(this.a != 0 && this.b != 0)
            return (0.5d * a * b);
        else
            throw new UnsupportedOperationException();
    }
}

