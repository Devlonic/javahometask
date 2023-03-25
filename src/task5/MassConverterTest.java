package task5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MassConverterTest {
    @Test
    public void KILOGRAM_TO_GRAM_test() {
        MassConverter ex = new MassConverter();
        double amount = ex.convertTo(1, MassConverter.Mass.KILOGRAM, MassConverter.Mass.GRAM);
        assertEquals(1000, amount, 0.0001);
    }

    @Test
    public void GRAM_TO_KILOGRAM_test() {
        MassConverter ex = new MassConverter();
        double amount = ex.convertTo(1000, MassConverter.Mass.GRAM, MassConverter.Mass.KILOGRAM);
        assertEquals(1, amount, 0.0001);
    }

    @Test
    public void KILOGRAM_TO_TONS_test() {
        MassConverter ex = new MassConverter();
        double amount = ex.convertTo(1, MassConverter.Mass.KILOGRAM, MassConverter.Mass.TON);
        assertEquals(0.001, amount, 0.0001);
    }

    @Test
    public void CENTNER_TO_MILLIGRAM_test() {
        MassConverter ex = new MassConverter();
        double amount = ex.convertTo(1, MassConverter.Mass.CENTNER, MassConverter.Mass.MILLIGRAM);
        assertEquals(100000000, amount, 0.0001);
    }

    @Test
    public void MILLIGRAM_TO_KILOGRAM_test() {
        MassConverter ex = new MassConverter();
        double amount = ex.convertTo(1000000, MassConverter.Mass.MILLIGRAM, MassConverter.Mass.KILOGRAM);
        assertEquals(1, amount, 0.0001);
    }
}
