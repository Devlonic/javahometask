package task1;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ShipDock {
    class Person {
        private static Random random = new Random();
        private String name;
        private String lastName;

        public Person() {
            this.name = getRandomName();
            this.lastName = getRandomLastName();
        }

        private final static String[] names = {
          "John","Jane", "Kane","Max", "Afanasiy","Akakiy","Ivan","Vasya","Kane","Stepan",
        };
        private final static String[] lastNames = {
          "Smith","O'Neill", "Elsher","Collymore", "Verlice"
        };
        private static String getRandomName() {
            return names[random.nextInt(names.length)];
        }
        private static String getRandomLastName() {
            return lastNames[random.nextInt(lastNames.length)];
        }

        @Override
        public String toString() {
            return String.format("Person %s %s", this.name, this.lastName);
        }
    }
    class Ship {
        private static int totalCreated = 0;
        private static Random random = new Random();

        private int id;
        private boolean isLastStop;
        private LinkedHashSet<Person> persons;
        private int seatCount;
        private int hoursBeforeDispatch;

        public Ship() {
            this.id = totalCreated++;
            this.persons = new LinkedHashSet<>();
            this.seatCount = random.nextInt(8) + 2;
            this.hoursBeforeDispatch = random.nextInt(2) + 1;
        }

        public boolean seatInto(Person person) {
            if(!this.hasFreeSeats())
                return false;

            return this.persons.add(person);
        }

        public int getOutOfShip(int personsCount) {
            int countGettedOut = 0;
            for (int i = 0; i < personsCount; i++) {
                // remove first human
                if(this.persons.removeIf(p->true))
                    countGettedOut++;
            }
            return countGettedOut;
        }

        public boolean hasFreeSeats() {
            return this.persons.stream().count() < seatCount;
        }

        @Override
        public String toString() {
            return String.format("Ship %d total seats: %d used seats: %d", this.id, this.seatCount, this.persons.stream().count());
        }
    }
    class ShipDockState {
        private int iteration;
        private int hour;
        private long countNewShips;
        private long countNewPersons;
        private long countSeatedPersons;
        private long countUnseatedPersons;
        private long countShipsInDock;

        public ShipDockState(int iteration, int hour, long countNewShips, long countNewPersons, long countSeatedPersons, long countUnseatedPersons, long countShipsInDock) {
            this.iteration = iteration;
            this.hour = hour;
            this.countNewShips = countNewShips;
            this.countNewPersons = countNewPersons;
            this.countSeatedPersons = countSeatedPersons;
            this.countUnseatedPersons = countUnseatedPersons;
            this.countShipsInDock = countShipsInDock;
        }

        public int getIteration() {
            return iteration;
        }

        public int getHour() {
            return hour;
        }

        public long getCountNewShips() {
            return countNewShips;
        }

        public long getCountNewPersons() {
            return countNewPersons;
        }

        public long getCountSeatedPersons() {
            return countSeatedPersons;
        }

        public long getCountUnseatedPersons() {
            return countUnseatedPersons;
        }

        public long getCountShipsInDock() {
            return countShipsInDock;
        }


        @Override
        public String toString() {
            return String.format("iteration: %d\t" +
                            "hour: %d\t" +
                            "countNewShips: %d\t" +
                            "countNewPersons: %d\t" +
                            "countSeatedPersons: %d\t" +
                            "countUnseatedPersons: %d\t" +
                            "countShipsInDock: %d\t",
                    this.iteration,
                    this.hour,
                    this.countNewShips,
                    this.countNewPersons,
                    this.countSeatedPersons,
                    this.countUnseatedPersons,
                    this.countShipsInDock);
        }
    }

    private static Random random = new Random();

    public ShipDock(double[] personsPerHour, double[] shipsPerHour) {
        if(personsPerHour.length != 24 || shipsPerHour.length != 24)
            throw new RuntimeException("arrays length must be equal 24");

        this.personsPerHour = personsPerHour;
        this.shipsPerHour = shipsPerHour;
    }

    private final double[] personsPerHour;
    private final double[] shipsPerHour;

    private Queue<Person> waitingForShipPersons = new ArrayDeque<>();
    private LinkedHashSet<Ship> availableShips = new LinkedHashSet<>();
    // init hour is 0 AM
    private int currentHour = 0;

    private Set<Person> getPersonsInCurrentHour() {
        var p = new HashSet<Person>();
        double countNewPersons = personsPerHour[currentHour] + random.nextInt(4) - 2; // [-2;2]
        for (int i = 0; i < countNewPersons; i++) {
            p.add(new Person());
        }

        return p;
    }
    private Set<Ship> getShipsInCurrentHour() {
        var p = new HashSet<Ship>();
        double countNewPersons = shipsPerHour[currentHour] + random.nextInt(6) - 2;
        for (int i = 0; i < countNewPersons; i++) {
            p.add(new Ship());
        }

        return p;
    }

    private void displayCurrentState(ShipDockState state) {
        System.out.println(state.toString());
    }

    // no stop possible
    public void start() throws InterruptedException {
        // one iteration is 1 hour
        int iteration = 0;
        while(true) {
            // get incoming persons and ships for current hour
            var newPersons = getPersonsInCurrentHour();
            var newShips = getShipsInCurrentHour();

            // put them to object state
            availableShips.addAll(newShips);
            waitingForShipPersons.addAll(newPersons);

            // put waiting persons to available ships
            AtomicInteger countSeated = new AtomicInteger();
            availableShips.forEach(s-> {
                while(this.waitingForShipPersons.size() > 0 && s.hasFreeSeats()) {
                    var person = this.waitingForShipPersons.poll();

                    s.seatInto(person);
                    countSeated.getAndIncrement();
                }
            });

            this.displayCurrentState(
                    new ShipDockState(
                            iteration,
                            currentHour,
                            newShips.size(),
                            newPersons.size(),
                            countSeated.get(),
                            this.waitingForShipPersons.size(),
                            this.availableShips.size()));

            if(currentHour < 23)
                currentHour++;
            else
                currentHour = 0;

            TimeUnit.SECONDS.sleep(1);

            iteration++;
        }
    }
}
