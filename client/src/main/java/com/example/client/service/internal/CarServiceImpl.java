package com.example.client.service.internal;

import com.example.client.model.Car;
import com.example.client.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private static final String BASE_URL = "http://localhost:8080/api/cars";
    private final CrudService<Car> crudService = new CrudService<>();

    @Override
    public List<Car> getAllCars() {
        return crudService.getAll(BASE_URL, Car.class);
    }

    @Override
    public void createCar(Car car) {
        crudService.create(BASE_URL, car);
    }

    @Override
    public void updateCar(Long id, Car car) {
        crudService.update(BASE_URL + "/" + id, car);
    }

    @Override
    public void deleteCar(Long id) {
        crudService.delete(BASE_URL + "/" + id);
    }

}
