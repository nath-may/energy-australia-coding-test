package carshowservice.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make = "Unknown Make";
    private String model = "Unknown Model";
    private List<String> shows = new ArrayList<>();

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public List<String> getShows() {
        return shows;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(make);
        stringBuilder.append("\n\t");
        stringBuilder.append(model);

        for (String show: shows) {
            stringBuilder.append("\n\t\t");
            stringBuilder.append(show);
        }

        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return model.hashCode() + make.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        Car car = (Car) obj;
        return this.make.equals(car.make) && this.model.equals(car.model);
    }
}
