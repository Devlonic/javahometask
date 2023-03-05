package sales;

import javax.management.MalformedObjectNameException;

public abstract class Money {
    // fields
    private int fullPartCount;
    private int hundredPartCount;
    private String fullPartName;
    private String hundredPartName;

    // constructors
    public Money(int fullPartCount, int hundredPartCount, String fullPartName, String hundredPartName) {
        this.throwOnValidationFault(fullPartCount, hundredPartCount);

        this.fullPartCount = fullPartCount;
        this.hundredPartCount = hundredPartCount;
        this.fullPartName = fullPartName;
        this.hundredPartName = hundredPartName;

        this.normalize();
    }
    public Money(int hundredPartCount, String fullPartName, String hundredPartName) {
        this(0, hundredPartCount, fullPartName, hundredPartName);
    }
    public Money(String fullPartName, String hundredPartName) {
        this(0, 0, fullPartName, hundredPartName);
    }

    // validation
    private void throwOnValidationFault(int fullPartCount, int hundredPartCount) {
        if(this.validate(fullPartCount, hundredPartCount) == false)
            throw new IllegalArgumentException("Parts validation fault");
    }
    private void throwOnValidationFaultFullPart(int fullPartCount) {
        if(this.validateFullPart(fullPartCount) == false)
            throw new IllegalArgumentException("fullPartCount validation fault");
    }
    private void throwOnValidationFaultHundredPart(int hundredPartCount) {
        if(this.validateHundredPart(hundredPartCount) == false)
            throw new IllegalArgumentException("hundredPartCount validation fault");
    }


    private boolean validate(int fullPartCount, int hundredPartCount) {
        return this.validateFullPart(fullPartCount) && this.validateHundredPart(hundredPartCount);
    }
    private boolean validateFullPart(int part) {
        return part >= 0;
    }
    private boolean validateHundredPart(int part) {
        return part >= 0;
    }

    // normalization
    private void normalize() {
        if(hundredPartCount >= 100) {
            fullPartCount = hundredPartCount / 100;
            hundredPartCount = hundredPartCount % 100;
        }
    }
    private void denormalize() {
        this.hundredPartCount += this.fullPartCount * 100;
    }

    @Override
    public String toString() {
        return String.format("%d %s,%d %s", this.fullPartCount, this.fullPartName, this.hundredPartCount, this.hundredPartName);
    }

    protected void decreaseHundredPartCount(int hundredPartCount) {
        // validate hundredPartCount
        this.throwOnValidationFaultFullPart(hundredPartCount);

        // convert it from 6,34 to 634
        this.denormalize();

        // validate
        // TODO replace with method
        if(this.hundredPartCount - hundredPartCount < 0)
            throw new IllegalArgumentException("Money cannot be negative");

        // subtract
        this.hundredPartCount -= hundredPartCount;

        // convert it from 634 to 6,34
        this.normalize();
    }
}

