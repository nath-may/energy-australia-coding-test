package carshowservice.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
  public static String DEFAULT_MAKE = "Unknown Make";
  public static String DEFAULT_MODEL = "Unknown Model";

  private String make = DEFAULT_MAKE;

  private String model = DEFAULT_MODEL;
  private List<String> shows = new ArrayList<>();

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
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

    for (String show : shows) {
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
    if (this == obj) {
      return true;
    }

    Car car = (Car) obj;
    return this.make.equals(car.make) && this.model.equals(car.model);
  }
}
