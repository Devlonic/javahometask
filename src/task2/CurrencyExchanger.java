package task2;

public class CurrencyExchanger {

    public double convertTo(double originAmount, Currencies originCurrency) {
        return originAmount * originCurrency.ratioToMainCurrency;
    }

    public enum Currencies {
        UAH(0.027);

        private final double ratioToMainCurrency;

        Currencies(double ratioToMainCurrency) {
            this.ratioToMainCurrency = ratioToMainCurrency;
        }
    }
}
