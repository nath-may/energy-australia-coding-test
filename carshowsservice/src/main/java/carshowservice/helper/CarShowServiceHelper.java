package carshowservice.helper;

import carshowservice.model.Car;
import carshowservice.model.CarShow;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarShowServiceHelper {
  /**
   * Serializes the json returned from the api endpoint into a list of car
   * and the shows they are attending.
   *
   * @param carShowsJson String returned from the api endpoint
   * @return List containing the cars and the shows they attend
   * @throws IOException Throws an exception the the json from the api endpoint cannot be parsed
   */
  public static List<Car> createCarShowsList(String carShowsJson) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    List<CarShow> carShows;

    try {
      carShows = mapper.readValue(carShowsJson, new TypeReference<List<CarShow>>() {});
    } catch (IOException exception) {
      throw new IOException(
              String.format("Failed to parse car show json: %s", exception.getMessage()));
    }

    List<Car> cars = carShows
        .stream()
        .flatMap(carShow -> carShow.getCars().stream())
        .distinct()
        .sorted(Comparator.comparing(Car::getMake))
        .collect(Collectors.toList());

    for (Car car : cars) {
      List<String> shows = carShows
          .stream()
          .filter(carShow -> carShow.getCars().contains(car))
          .map(CarShow::getName)
          .collect(Collectors.toList());
      car.getShows().addAll(shows);
    }

    return cars;
  }

  /**
   * Builds a string of all the cars and shows they are attending.
   *
   * @param cars List of cars to build the string from.
   * @return Formatted string of the cars
   */
  public static String formatCarShowsList(List<Car> cars) {
    StringBuilder stringBuilder = new StringBuilder();

    for (Car car : cars) {
      stringBuilder.append(car.toString());
    }

    return stringBuilder.toString();
  }
}
