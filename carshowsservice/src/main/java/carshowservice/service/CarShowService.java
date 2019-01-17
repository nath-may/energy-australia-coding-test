package carshowservice.service;

import carshowservice.helper.CarShowServiceHelper;
import carshowservice.model.Car;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class CarShowService {
    public String getFormattedCarShowsList() throws IOException {
        String API_ENDPOINT = "http://eacodingtest.digital.energyaustralia.com.au/api/v1/cars";
        String carShowsJson = IOUtils.toString(new URL(API_ENDPOINT).openStream());

        List<Car> cars = CarShowServiceHelper.createCarShowsList(carShowsJson);
        return CarShowServiceHelper.formatCarShowsList(cars);
    }
}