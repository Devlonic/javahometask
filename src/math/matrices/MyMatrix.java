package math.matrices;

import collections.MyArrayBase;
import jdk.jshell.spi.ExecutionControl;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public class MyMatrix<T extends Number> extends MyArrayBase<T> {
    private T[][] matrix;

    public MyMatrix(T[][] matrix) {
        throwOnBoundsInvalid(matrix.length, matrix[0].length, this);
        this.matrix = matrix;
    }
    public MyMatrix() {
        this.matrix = null;
    }

    @Override
    public void print() {
        for (int i = 0; i < this.matrix.length; i++) {
            super.printArray(this.matrix[i]);
        }
        System.out.println();
    }
    @Override
    public T getMin(Comparator<T> comparator) {
        // TODO replace with JAVA-style methods
        T currentMin = this.matrix[0][0];
        for (T[] a: matrix) {
            for (T n: a) {
                if(n.doubleValue() < currentMin.doubleValue())
                    currentMin = n;
            }
        }
        return currentMin;
    }
    @Override
    public T getMax(Comparator<T> comparator) {
        // TODO replace with JAVA-style methods
        T currentMin = this.matrix[0][0];
        for (T[] a: matrix) {
            for (T n: a) {
                if(n.doubleValue() > currentMin.doubleValue())
                    currentMin = n;
            }
        }
        return currentMin;
    }
    @Override
    public double getAverage() {
        return getAverageArray(this.matrix);
    }
    @Override
    public void sortAsc() {
        throw new RuntimeException("Not implemented");
    }
    @Override
    public void sortDesc() {
        throw new RuntimeException("Not implemented");
    }
    @Override
    public int findIndex(T key) {
        throw new RuntimeException("Not implemented");
    }
    @Override
    public void replace(T oldValue, T newValue) {
        throw new RuntimeException("Not implemented");
    }

    // filling
    private static boolean isBoundsValid(int width, int height) {
        return width > 0 & height > 0;
    }
    private static void throwOnBoundsInvalid(int width, int height, MyMatrix matrix) throws WrongBoundsMatrixException {
        if(!isBoundsValid(width, height))
            throw new WrongBoundsMatrixException(matrix);
    }
    public void fill(int width, int height, Function<Object, T> generator) throws WrongBoundsMatrixException {
        throwOnBoundsInvalid(width, height, this);

        this.matrix = (T[][]) new Number[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.matrix[i][j] = generator.apply(null);
            }
        }
    }

    // addition
    private static boolean isMatrixDimensionsEquals(MyMatrix m1, MyMatrix m2) {
        return
                (m1.matrix.length == m2.matrix.length) &&
                (m1.matrix[0].length == m2.matrix[0].length);
    }
    private static void throwOnMatrixDimensionsNotEqual(MyMatrix m1, MyMatrix m2) throws DimensionsNotEqualMatrixException {
        if(!isMatrixDimensionsEquals(m1, m2))
            throw new DimensionsNotEqualMatrixException(m1, m2);
    }
    public MyMatrix<T> add(MyMatrix<T> second) {
        this.throwOnMatrixDimensionsNotEqual(this, second);

        T[][] m = (T[][]) new Number[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                Number x;

                // FIXME bad code, should be replaced
                if(
                        this.matrix[i][j] instanceof Double ||
                        this.matrix[i][j] instanceof Double)
                    x = (Number)(this.matrix[i][j].doubleValue() + second.matrix[i][j].doubleValue());
                else if(
                        this.matrix[i][j] instanceof Long ||
                        this.matrix[i][j] instanceof Integer ||
                        this.matrix[i][j] instanceof Short ||
                        this.matrix[i][j] instanceof Byte)
                    x = (Number)(this.matrix[i][j].intValue() + second.matrix[i][j].intValue());
                else throw new UnsupportedOperationException();

                m[i][j] = (T)x;
            }
        }

        return new MyMatrix(m);
    }

    // subtraction
    public MyMatrix<T> subtract(MyMatrix<T> second) {
        this.throwOnMatrixDimensionsNotEqual(this, second);

        T[][] m = (T[][]) new Number[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                Number x;

                // FIXME bad code, should be replaced
                if(
                        this.matrix[i][j] instanceof Double ||
                                this.matrix[i][j] instanceof Double)
                    x = (Number)(this.matrix[i][j].doubleValue() - second.matrix[i][j].doubleValue());
                else if(
                        this.matrix[i][j] instanceof Long ||
                                this.matrix[i][j] instanceof Integer ||
                                this.matrix[i][j] instanceof Short ||
                                this.matrix[i][j] instanceof Byte)
                    x = (Number)(this.matrix[i][j].intValue() - second.matrix[i][j].intValue());
                else throw new UnsupportedOperationException();

                m[i][j] = (T)x;
            }
        }

        return new MyMatrix(m);
    }

    // multiplication
    public MyMatrix<T> multiple(T scalar) {
        T[][] m = (T[][]) new Number[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                Number x;

                // FIXME bad code, should be replaced
                if(
                        this.matrix[i][j] instanceof Double ||
                                this.matrix[i][j] instanceof Double)
                    x = (Number)(this.matrix[i][j].doubleValue() * scalar.doubleValue());
                else if(
                        this.matrix[i][j] instanceof Long ||
                                this.matrix[i][j] instanceof Integer ||
                                this.matrix[i][j] instanceof Short ||
                                this.matrix[i][j] instanceof Byte)
                    x = (Number)(this.matrix[i][j].intValue() * scalar.intValue());
                else throw new UnsupportedOperationException();

                m[i][j] = (T)x;
            }
        }

        return new MyMatrix(m);
    }
    private static boolean isMatricesCanBeMultiplied(MyMatrix m1, MyMatrix m2) {
        return m1.matrix[0].length == m2.matrix.length;
    }
    private static void throwOnMatricesCanNotBeMultiplied(MyMatrix m1, MyMatrix m2) throws CanNotBeMultipliedMatrixException {
        if(!isMatricesCanBeMultiplied(m1, m2))
            throw new CanNotBeMultipliedMatrixException(m1, m2);
    }
    public MyMatrix<T> multiple(MyMatrix<T> second) {
        throwOnMatricesCanNotBeMultiplied(this, second);

        T[][] m = (T[][]) new Number[this.matrix.length][second.matrix[0].length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < second.matrix[0].length; j++) {
                int curval = 0;
                for (int k = 0; k < this.matrix[0].length; k++) {
                    curval += this.matrix[i][k].intValue() * second.matrix[k][j].intValue();
                }
                m[i][j] = (T)(Number)curval;
            }
        }

        return new MyMatrix(m);
    }

    // division
    private static MyMatrix swap(MyMatrix matrix)  {
        // matrix is 2x2
        if(matrix.matrix.length == 2 && matrix.matrix.length == matrix.matrix[0].length) {
            var res = new MyMatrix<>(matrix.matrix.clone());

            Number buf = res.matrix[0][0];
            res.matrix[0][0] = res.matrix[1][1];
            res.matrix[1][1] = buf;

            res.matrix[1][0] = res.matrix[1][0].intValue() * -1;
            res.matrix[0][1] = res.matrix[0][1].intValue() * -1;

            return res;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    private static int getDeterminator(MyMatrix matrix) throws UnsupportedOperationException {
        // matrix is 2x2
        if(matrix.matrix.length == 2 && matrix.matrix.length == matrix.matrix[0].length) {
            return (matrix.matrix[0][0].intValue() * matrix.matrix[1][1].intValue() - matrix.matrix[0][1].intValue() * matrix.matrix[1][0].intValue());
        } else {
            throw new UnsupportedOperationException();
        }
    }
    private static boolean isMatrixSquare(MyMatrix m) {
        return m.matrix.length == m.matrix[0].length;
    }
    private static boolean isMatricesCanBeDivided(MyMatrix dividend, MyMatrix divisor) {
        return isMatrixSquare(divisor) && getDeterminator(divisor) != 0;
    }
    private static void throwOnMatricesCanNotBeDivided(MyMatrix dividend, MyMatrix divisor) throws CanNotBeDividedMatrixException {
        if(!isMatricesCanBeDivided(dividend, divisor))
            throw new CanNotBeDividedMatrixException(dividend, divisor);
    }

    public MyMatrix<T> divide(MyMatrix<T> divisor) throws OperationNotSupportedException {
        // TODO
        throw new OperationNotSupportedException();

//        var dividend = this;
//
//        throwOnMatricesCanNotBeDivided(dividend, divisor);
//        throwOnMatricesCanNotBeMultiplied(dividend, divisor);
//
//        var swappedMatrix = divisor.multiple((T)(Number)(-1));
//
//        return new MyMatrix();
    }
}
