package task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyExchangeTest {
    @Test
    public void UAHtoUSD_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(1, CurrencyExchanger.Currencies.UAH);
        assertEquals(amount, 0.027, 0.0001);
    }
}
