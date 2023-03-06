package math.matrices;

public abstract class MatrixException extends RuntimeException {
    private MyMatrix matrix;
    public MatrixException(MyMatrix matrix, String message) {
        super(message);
        this.matrix = matrix;
    }
}

