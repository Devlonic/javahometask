package math.matrices;

public class CanNotBeDividedMatrixException extends MatrixException {
    public CanNotBeDividedMatrixException(MyMatrix numerator, MyMatrix denominator) {
        super(numerator, "matrix1 cannot be divided into matrix2");
    }
}
