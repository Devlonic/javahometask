package task5;


public class MassConverter {
    public double convertTo(double originAmount, Mass originMeasure, Mass targetMeasure) {
        // non-KILOGRAM -> non-KILOGRAM
        if(originMeasure != Mass.KILOGRAM && targetMeasure !=  Mass.KILOGRAM) {
            var originToMeterAmount = convertTo(originAmount, originMeasure, Mass.KILOGRAM);
            return convertTo(originToMeterAmount, Mass.KILOGRAM, targetMeasure);
        } else if(originMeasure == Mass.KILOGRAM) // KILOGRAM to any
            // result is originAmount * (targetMeasure.ratioToKilogram^(-1))
            return originAmount * Math.pow(targetMeasure.ratioToKilogram, -1);
        else
            return originAmount * originMeasure.ratioToKilogram;
    }

    public enum Mass {
        MILLIGRAM(0.000001),
        GRAM(0.001),
        KILOGRAM(1),
        CENTNER(100),
        TON(1000);

        private final double ratioToKilogram;

        Mass(double ratioToKilogram) {
            this.ratioToKilogram = ratioToKilogram;
        }
    }
}
