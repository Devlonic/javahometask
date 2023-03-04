package infrastructure.settlements;

import people.Human;

public class CityHumanAlreadySettledException extends CitySettleException {
    private Human human;

    public Human getHuman() {
        return human;
    }

    public CityHumanAlreadySettledException(Human human, City city) {
        super(String.format("%s is already settled to %s", human.getName(), city.getName()), city);
        this.human = human;
    }
}

