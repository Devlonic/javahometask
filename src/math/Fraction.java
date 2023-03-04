package math;

public class Fraction {
    private int value;
    private int numerator;
    private int denominator;


    public Fraction(int numerator, int denominator) {
        this.throwOnValidationFault(0, numerator, denominator);

        this.value = 0;
        this.numerator = numerator;
        this.denominator = denominator;

        this.normalize();
    }
    public Fraction(int value, int numerator, int denominator) {
        this.throwOnValidationFault(value, numerator, denominator);

        this.value = value;
        this.numerator = numerator;
        this.denominator = denominator;

        this.normalize();
    }

    private void throwOnValidationFault(int value, int numerator, int denominator) {
        if(denominator == 0)
            throw new IllegalArgumentException("the denominator must not be zero");
    }

    private void normalize() {
        // no need to normalize
        if(numerator < denominator)
            return;

        this.value += numerator / denominator;
        this.numerator = numerator % denominator;
    }

    private static int getHighestCommonDenominator(int denominator1, int denominator2) {
        while(true) {
            if(denominator1 == 0 || denominator2 == 0)
                return denominator1 + denominator2;

            if(denominator1 > denominator2) {
                denominator1 = denominator1 % denominator2;
            } else
                denominator2 = denominator2 % denominator1;
        }
    }
    private static int getLowestCommonAliquot(int denominator1, int denominator2) {
        return denominator1 / getHighestCommonDenominator(denominator1, denominator2) * denominator2;
    }
    public static Fraction add(Fraction left, Fraction right) {
        if(left.denominator == right.denominator) {
            return new Fraction(
                    left.value + right.value,
                    left.numerator + right.numerator,
                    left.denominator);
        } else {
            int lcd = getLowestCommonAliquot(left.denominator, right.denominator);
            return new Fraction(left.value + right.value,
                    ((lcd / left.denominator)*left.numerator) + ((lcd / right.denominator)*right.numerator),
                    lcd);
        }
    }
    public static Fraction add(Fraction left, int number) {
        return  new Fraction(left.value+number, left.numerator, left.denominator);
    }

    public double getDecimal() {
        return (double) this.numerator / (double) this.denominator + this.value;
    }

    @Override
    public String toString() {
        return String.format("%d/%d=%f", this.numerator, this.denominator, this.getDecimal());
    }
}
