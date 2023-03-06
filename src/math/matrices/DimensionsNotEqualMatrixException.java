package math.matrices;

public class DimensionsNotEqualMatrixException extends MatrixException {
    public DimensionsNotEqualMatrixException(MyMatrix matrix1, MyMatrix matrix2) {
        super(matrix1, "Dimensions of matrix1 and matrix2 must be equal");
    }
}

