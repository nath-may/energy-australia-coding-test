package carshowservice.helper;

import carshowservice.model.Car;
import carshowservice.model.CarShow;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;

public class CarShowServiceHelperTest {
    @Test
    public void testFormatCarShowListAlphabetical() throws IOException {
        String carShowsJson = getResourceContent("samplecarshow.json");

        Car car = new Car();
        car.setMake("Hondaka");
        car.setModel("Elisa");
        car.getShows().add("New York Car Show");

        Car car2 = new Car();
        car2.setMake("George Motors");
        car2.setModel("George 15");
        car2.getShows().add("New York Car Show");
        car2.getShows().add("Melbourne Motor Show");

        String expectedFormattedCarShows = car2.toString() + car.toString();
        parseAndValidateOutput(carShowsJson, expectedFormattedCarShows, 2);
    }

    @Test
    public void testFormatCarShowListNullMake() throws IOException {
        String carShowsJson = getResourceContent("samplecarshow-nullmake.json");

        Car car = new Car();
        car.setMake(Car.DEFAULT_MAKE);
        car.setModel("George 15");
        car.getShows().add("New York Car Show");

        parseAndValidateOutput(carShowsJson, car.toString(), 3);
    }

    @Test
    public void testFormatCarShowListNullModel() throws IOException {
        String carShowsJson = getResourceContent("samplecarshow-nullmodel.json");

        Car car = new Car();
        car.setMake("George Motors");
        car.setModel(Car.DEFAULT_MODEL);
        car.getShows().add("New York Car Show");

        parseAndValidateOutput(carShowsJson, car.toString(), 3);
    }

    @Test
    public void testFormatCarShowListNullCarShowName() throws IOException {
        String carShowsJson = getResourceContent("samplecarshow-nullshowname.json");

        Car car = new Car();
        car.setMake("George Motors");
        car.setModel("George 15");
        car.getShows().add("New York Car Show");
        car.getShows().add(CarShow.DEFAULT_CAR_SHOW_NAME);

        parseAndValidateOutput(carShowsJson, car.toString(), 2);
    }

    @Test (expected = IOException.class)
    public void testFormatCarShowListEmptyResponnse() throws IOException {
        CarShowServiceHelper.createCarShowsList("");
    }

    private void parseAndValidateOutput(String carShowsJson, String expectedFormattedCarShows, int expectedSize) throws IOException {
        List<Car> cars = CarShowServiceHelper.createCarShowsList(carShowsJson);
        String formattedCarShows = CarShowServiceHelper.formatCarShowsList(cars);
        assertThat("Formatted car shows does not match expected output", formattedCarShows.contains(expectedFormattedCarShows));
        assertThat("Car list size does not match expected size", cars.size() == expectedSize);
    }

    private String getResourceContent(String filename) throws IOException {
        return IOUtils.toString(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream(filename)), "UTF-8");
    }
}