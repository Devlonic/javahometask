package task4;


public class MeasuresConverter {
    public double convertTo(double originAmount, Measures originMeasure, Measures targetMeasure) {
        // non-meters -> non-meters
        if(originMeasure != Measures.METER && targetMeasure !=  Measures.METER) {
            var originToMeterAmount = convertTo(originAmount, originMeasure, Measures.METER);
            return convertTo(originToMeterAmount, Measures.METER, targetMeasure);
        } else if(originMeasure == Measures.METER) // meters to any
            // result is originAmount * (targetMeasure.ratioToMeter^(-1))
            return originAmount * Math.pow(targetMeasure.ratioToMeter, -1);
        else
            return originAmount * originMeasure.ratioToMeter;
    }

    public enum Measures {
        MILLIMETER(0.001),
        SANTIMETER(0.01),
        DECIMETER(0.1),
        METER(1),
        KILOMETER(1000);

        private final double ratioToMeter;

        Measures(double ratioToMeter) {
            this.ratioToMeter = ratioToMeter;
        }
    }
}
