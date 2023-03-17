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
}
