package task4;

public class MeasuresConverter {
    public double convertTo(double originAmount, Measures originMeasure, Measures targetMeasure) {

    }

    public enum Measures {
        MILLIMETER(0.000001),
        SANTIMETER(0.01),
        DECIMETER(0.1),
        METER(1),
        KILOMETER(1000);

        private double ratioToMeter;

        Measures(double ratioToMainMeasure) {
            this.ratioToMeter = ratioToMainMeasure;
        }
    }
}
