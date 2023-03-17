package task2;

public class CurrencyExchanger {

    public CurrencyExchanger() {
        Currencies.mainCurrency = Currencies.USD;
    }

    public double convertTo(double originAmount, Currencies originCurrency, Currencies targetCurrency) {
        if(originCurrency != Currencies.mainCurrency)
            return originAmount * originCurrency.ratioToMainCurrency;
        else
            return originAmount * targetCurrency.ratioFromMainCurrency;
    }

    public enum Currencies {
        USD(1, 1),
        PLN(0.23, 4.41),
        UAH(0.027, 36.93);

        private static Currencies mainCurrency;

        private double ratioToMainCurrency;
        private double ratioFromMainCurrency;

        Currencies(double ratioToMainCurrency, double ratioFromMainCurrency) {
            this.ratioToMainCurrency = ratioToMainCurrency;
            this.ratioFromMainCurrency = ratioFromMainCurrency;
        }
    }
}
