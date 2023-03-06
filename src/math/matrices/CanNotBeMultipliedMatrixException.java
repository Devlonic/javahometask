package math.matrices;

public class CanNotBeMultipliedMatrixException extends MatrixException {
    public CanNotBeMultipliedMatrixException(MyMatrix matrix1, MyMatrix matrix2) {
        super(matrix1, "matrix1 cannot be multiplied to matrix2");
    }
}