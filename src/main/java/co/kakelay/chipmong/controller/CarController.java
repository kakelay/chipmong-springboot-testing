package co.kakelay.chipmong.controller;

import co.kakelay.chipmong.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private ApplicationContext context;

    @GetMapping("/ask")
    public String askCarName(@RequestParam String name) {
        if (name.equalsIgnoreCase("Bye")) {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    // Wait for 500 millis before shutting down
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                SpringApplication.exit(context, () -> 0);
            }).start();
            return "Goodbye! Your application will shut down shortly.";
        }
        return carService.askCarName(name);
    }

    @PostMapping("/add")
    public String addCar(@RequestParam String name, @RequestParam int wheels) {
        return carService.addCar(name, wheels);
    }
}
