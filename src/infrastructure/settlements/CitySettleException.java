package infrastructure.settlements;

public class CitySettleException extends RuntimeException {
    public CitySettleException(String message, City city) {
        super(message);
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    private City city;
}
