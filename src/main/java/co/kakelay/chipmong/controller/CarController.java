package co.kakelay.chipmong.controller;

import co.kakelay.chipmong.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/ask")
    public String askCarName(@RequestParam String name) {
        return carService.askCarName(name);
    }

    @PostMapping("/add")
    public String addCar(@RequestParam String name, @RequestParam int wheels) {
        return carService.addCar(name, wheels);
    }
}
