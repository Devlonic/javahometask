package items;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Car {
    private String model;
    private String manufacturerName;
    private int productionYear;
    private float engineVolume;

    public Car(String model, String manufacturerName, int productionYear, float engineVolume) {
        this.model = model;
        this.manufacturerName = manufacturerName;
        this.productionYear = productionYear;
        this.engineVolume = engineVolume;
    }

    public Car(InputStream inputStream, PrintStream printStream) {
        var in = new Scanner(inputStream);
        printStream.printf("Enter model:\t");
        this.model = in.nextLine();
        printStream.printf("Enter manufacturerName:\t");
        this.manufacturerName = in.nextLine();
        printStream.printf("Enter productionYear:\t");
        this.productionYear = Integer.parseInt(in.nextLine());
        printStream.printf("Enter engineVolume:\t");
        this.engineVolume = Float.parseFloat(in.nextLine());
    }

    public Car() {
        this(System.in, System.out);
    }

    public void print(PrintStream ps) {
        ps.print(this.toString());
    }

    @Override
    public String toString() {
        return String.format("""
                Model =\t%s
                Manufacturer =\t%s
                Production year =\t%d
                Engine volume =\t%f
                """, model, manufacturerName, productionYear, engineVolume);
    }
}
