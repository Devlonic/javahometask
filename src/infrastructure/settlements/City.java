package infrastructure.settlements;

import infrastructure.countries.Country;
import people.Human;

import java.util.Arrays;

public class City {
    // TODO should be replaced with collections.generic.MyList
    private Human[] citizens;
    private String name;
    private int countCitizens;
    private Country country;

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    private City(int capacity) {
        this.citizens = new Human[capacity];
        this.countCitizens = 0;
        this.country = null;
    }
    public City(String name, int capacity) {
        this(capacity);

        this.name = name;
    }

    private void throwOnCityOverflow() throws CityOverflowException {
        if(this.countCitizens == this.citizens.length)
            throw new CityOverflowException(this);
    }
    private void throwOnAlreadySettled(final Human human) throws CityHumanAlreadySettledException {
        // if human is found in array - throw exception
        if(Arrays.stream(this.citizens).anyMatch(h->h==human))
            throw new CityHumanAlreadySettledException(human, this);
    }
    private void throwOnNotSettled(final Human human) throws CityHumanNotSettledException {
        // if human is not found in array - throw exception
        if(Arrays.stream(this.citizens).anyMatch(h->h==human) == false)
            throw new CityHumanNotSettledException(human, this);
    }

    public void settle(final Human human) throws CitySettleException {
        this.throwOnCityOverflow();
        this.throwOnAlreadySettled(human);

        this.citizens[this.countCitizens++] = human;

        // just for debug
        System.out.printf("%s was successfully settled to %s\n", human.getName(), this.name);
    }

    private void deleteFromArray(final Human human) {
        // replace object by null
        for (int i = 0; i < this.citizens.length; i++) {
            if(this.citizens[i] == human)
                this.citizens[i] = null;
        }
    }
    public void evict(final Human human) throws CitySettleException {
        this.throwOnNotSettled(human);

        this.deleteFromArray(human);

        // just for debug
        System.out.printf("%s was successfully evicted from %s\n", human.getName(), this.name);
    }
}
