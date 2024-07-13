package co.kakelay.chipmong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarService {

    private Map<String, Integer> carWheelMap = new HashMap<>();
    @Autowired
    private ApplicationContext context;

    public List<String> askCarName(String name) {
        if (name.equalsIgnoreCase("All")) {
            return carWheelMap.entrySet().stream()
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
        else if (name.equalsIgnoreCase("Bye")) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                    // Wait for 500 millis before shutting down
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                SpringApplication.exit(context, () -> 0);
            }).start();
            return List.of("Goodbye! Your application will shut down shortly.");
        }
        else if (name.equalsIgnoreCase("4-wheel-car")) {
            return carWheelMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 4)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
        else if (name.equalsIgnoreCase("2-wheel-car")) {
            return carWheelMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == 2)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        } else {
            if (carWheelMap.containsKey(name)) {
                return List.of(name + " has " + carWheelMap.get(name) + " wheels.");
            } else {
                return List.of(name + " is not in my list. Please provide the number of wheels to add it.");
            }
        }
    }

    public Map<String, String> addCar(String name, int wheels) {
        carWheelMap.put(name, wheels);
        return Map.of("message", "Thanks. I updated the information.");
    }
}
