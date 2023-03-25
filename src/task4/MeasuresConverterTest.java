package task4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeasuresConverterTest {
    @Test
    public void METERS_TO_SANTIMETERS_test() {
        MeasuresConverter ex = new MeasuresConverter();
        double amount = ex.convertTo(1, MeasuresConverter.Measures.METER, MeasuresConverter.Measures.SANTIMETER);
        assertEquals(100, amount, 0.0001);
    }

    @Test
    public void SANTIMETERS_TO_METERS_test() {
        MeasuresConverter ex = new MeasuresConverter();
        double amount = ex.convertTo(100, MeasuresConverter.Measures.SANTIMETER, MeasuresConverter.Measures.METER);
        assertEquals(1, amount, 0.0001);
    }

    @Test
    public void METERS_TO_KILOMETERS_test() {
        MeasuresConverter ex = new MeasuresConverter();
        double amount = ex.convertTo(1, MeasuresConverter.Measures.METER, MeasuresConverter.Measures.KILOMETER);
        assertEquals(0.001, amount, 0.0001);
    }

    @Test
    public void DECIMETERS_TO_MILLIMETERS_test() {
        MeasuresConverter ex = new MeasuresConverter();
        double amount = ex.convertTo(1, MeasuresConverter.Measures.DECIMETER, MeasuresConverter.Measures.MILLIMETER);
        assertEquals(100, amount, 0.0001);
    }

    @Test
    public void MILLIMETERS_TO_KILOMETERS_test() {
        MeasuresConverter ex = new MeasuresConverter();
        double amount = ex.convertTo(1000000, MeasuresConverter.Measures.MILLIMETER, MeasuresConverter.Measures.KILOMETER);
        assertEquals(1, amount, 0.0001);
    }
}
