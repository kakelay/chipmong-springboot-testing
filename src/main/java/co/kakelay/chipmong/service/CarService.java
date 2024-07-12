package co.kakelay.chipmong.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarService {

    private Map<String, Integer> carWheelMap = new HashMap<>();

    public String askCarName(String name) {
        if (name.equalsIgnoreCase("All")) {
            return carWheelMap.entrySet().stream()
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList()).toString();
        } else if (name.equalsIgnoreCase("4-wheel-car")) {
            return carWheelMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 4)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList()).toString();
        } else if (name.equalsIgnoreCase("2-wheel-car")) {
            return carWheelMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 2)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList()).toString();
        } else {
            if (carWheelMap.containsKey(name)) {
                return name + " has " + carWheelMap.get(name) + " wheels.";
            } else {
                return name + " is not in my list. Please provide the number of wheels to add it.";
            }
        }
    }

    public String addCar(String name, int wheels) {
        carWheelMap.put(name, wheels);
        return "Thanks. I updated the information.";
    }
}
