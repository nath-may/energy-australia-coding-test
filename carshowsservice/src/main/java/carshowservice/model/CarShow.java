package carshowservice.model;

import java.util.List;

public class CarShow {
  public static String DEFAULT_CAR_SHOW_NAME = "Unknown Car Show";

  private String name = DEFAULT_CAR_SHOW_NAME;
  private List<Car> cars;

  public String getName() {
    return name;
  }

  public List<Car> getCars() {
    return cars;
  }
}
