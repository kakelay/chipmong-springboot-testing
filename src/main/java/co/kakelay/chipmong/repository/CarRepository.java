package co.kakelay.chipmong.repository;

import co.kakelay.chipmong.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository

public class CarRepository {
    private final List<Car> carList = new ArrayList<>();

    public List<Car> findAll() {
        return new ArrayList<>(carList);
    }

    public Optional<Car> findByName(String name) {
        return carList.stream().filter(car -> car.getName().equalsIgnoreCase(name)).findFirst();
    }

    public void save(Car car) {
        carList.add(car);
    }

    public List<Car> findByWheels(int wheels) {
        return carList.stream().filter(car -> car.getWheels() == wheels).collect(Collectors.toList());
    }
}
