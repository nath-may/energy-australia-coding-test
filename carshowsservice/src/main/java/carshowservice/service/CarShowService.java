package carshowservice.service;

import carshowservice.helper.CarShowServiceHelper;
import carshowservice.model.Car;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CarShowService {
  /**
   * Queries the Energy Australia api and returns a formatted string of the cars and the shows they
   * have attended.
   *
   * @return Formatted car make, model and shows attended
   * @throws IOException Throws an exception when the api returns are error
   */
  public String getFormattedCarShowsList() throws IOException {
    String carShowsJson = IOUtils.toString(new URL("http://eacodingtest.digital.energyaustralia.com.au/api/v1/cars").openStream());

    List<Car> cars = CarShowServiceHelper.createCarShowsList(carShowsJson);
    return CarShowServiceHelper.formatCarShowsList(cars);
  }
}
