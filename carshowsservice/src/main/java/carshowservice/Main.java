package carshowservice;

import carshowservice.service.CarShowService;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    CarShowService service = new CarShowService();
    System.out.println(service.getFormattedCarShowsList());
  }
}
