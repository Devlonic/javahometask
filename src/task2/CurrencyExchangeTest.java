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

    @Test
    public void UAN_to_PLN_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(256, CurrencyExchanger.Currencies.UAH, CurrencyExchanger.Currencies.PLN);
        assertEquals(30.59, amount, 1);
    }

    @Test
    public void EUR_to_PLN_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(1, CurrencyExchanger.Currencies.EUR, CurrencyExchanger.Currencies.PLN);
        assertEquals(4.7, amount, 1);
    }

    @Test
    public void GBP_to_PLN_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(1, CurrencyExchanger.Currencies.GBP, CurrencyExchanger.Currencies.PLN);
        assertEquals(5.76, amount, 0.5);
    }

    @Test
    public void UAH_to_YEN_test() {
        CurrencyExchanger ex = new CurrencyExchanger();
        double amount = ex.convertTo(23, CurrencyExchanger.Currencies.UAH, CurrencyExchanger.Currencies.YEN);
        assertEquals(82.38, amount, 0.5);
    }
}
