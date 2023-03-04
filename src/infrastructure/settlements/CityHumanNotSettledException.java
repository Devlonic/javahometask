package infrastructure.settlements;

import people.Human;

public class CityHumanNotSettledException extends CitySettleException {
    private Human human;

    public Human getHuman() {
        return human;
    }

    public CityHumanNotSettledException(Human human, City city) {
        super(String.format("%s is not settled in %s", human.getName(), city.getName()), city);
        this.human = human;
    }
}
