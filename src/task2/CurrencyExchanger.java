package task2;

public class CurrencyExchanger {

    public CurrencyExchanger() {
        Currencies.mainCurrency = Currencies.USD;
    }

    public double convertTo(double originAmount, Currencies originCurrency, Currencies targetCurrency) {
        if(originCurrency != Currencies.mainCurrency && targetCurrency != Currencies.mainCurrency) {
            var originToMainCurrency = convertTo(originAmount, originCurrency, Currencies.USD);
            return convertTo(originToMainCurrency, Currencies.mainCurrency, targetCurrency);
        } else if(originCurrency == Currencies.mainCurrency)
            return originAmount * targetCurrency.ratioFromMainCurrency;
        else if(targetCurrency == Currencies.mainCurrency)
            return originAmount * originCurrency.ratioToMainCurrency;
        else throw new UnsupportedOperationException();
    }

    public enum Currencies {
        USD(1, 1),
        PLN(0.23, 4.41),
        EUR(1.06, 0.94),
        GBP(1.21, 0.82),
        YEN(0.0076, 132.27),
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
