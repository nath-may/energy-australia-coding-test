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
    public static List<Car> createCarShowsList(String carShowsJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<CarShow> carShows = mapper.readValue(carShowsJson, new TypeReference<List<CarShow>>(){});

        List<Car> cars = carShows
                .stream()
                .flatMap(carShow -> carShow.getCars().stream())
                .distinct()
                .sorted(Comparator.comparing(Car::getMake))
                .collect(Collectors.toList());

        for (Car car: cars) {
            List<String> shows = carShows
                    .stream()
                    .filter(carShow -> carShow.getCars().contains(car))
                    .map(CarShow::getName)
                    .collect(Collectors.toList());
            car.getShows().addAll(shows);
        }

        return cars;
    }

    public static String formatCarShowsList(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car: cars) {
            stringBuilder.append(car.toString());
        }

        return stringBuilder.toString();
    }
}
