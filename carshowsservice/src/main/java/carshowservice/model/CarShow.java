package carshowservice.model;

import java.util.List;

public class CarShow {
    private String name = "Unknown Car Show";
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }
}
