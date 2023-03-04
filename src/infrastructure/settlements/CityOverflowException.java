package infrastructure.settlements;

public class CityOverflowException extends CitySettleException {
    public CityOverflowException(City city) {
        super("City is overflow", city);
    }
}

