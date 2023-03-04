package infrastructure.countries;

import collections.generic.MyList;
import infrastructure.settlements.City;
import people.Human;

public class Country {
    private MyList<City> cities;

    private String name;

    private Country() {
        this.cities = new MyList<>();
    }

    public Country(String name) {
        this();
        this.name = name;
    }

    public void addCity(City city) {
        if(city.getCountry() != null)
            throw new RuntimeException(city.getName() + " already in " + city.getCountry().name);

        if(this.cities.exist(city))
            throw new RuntimeException(city.getName() + " already in " + this.name);

        this.cities.add(city);
        city.setCountry(this);

        // just for visualization. can be removed.
        System.out.println(city.getName() + " added to " + this.name);
    }
}
