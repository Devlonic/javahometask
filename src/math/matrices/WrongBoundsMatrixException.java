package math.matrices;

public class WrongBoundsMatrixException extends MatrixException {
    public WrongBoundsMatrixException(MyMatrix matrix) {
        super(matrix, "Bounds of matrix must be more than 0");
    }
}

