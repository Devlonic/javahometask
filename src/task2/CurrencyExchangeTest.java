package task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyExchangeTest {
    @Test
    public void UAH_to_USD_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(1, CurrencyExchanger.Currencies.UAH, CurrencyExchanger.Currencies.USD);
        assertEquals(0.027, amount, 0.001);
    }

    @Test
    public void USD_to_UAH_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(1, CurrencyExchanger.Currencies.USD, CurrencyExchanger.Currencies.UAH);
        assertEquals(36.93, amount, 0.001);
    }

    @Test
    public void PLN_to_UAH_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(3, CurrencyExchanger.Currencies.PLN, CurrencyExchanger.Currencies.UAH);
        assertEquals(25.1, amount, 1);
    }
}
