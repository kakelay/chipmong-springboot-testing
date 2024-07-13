
package co.kakelay.chipmong.controller;
import co.kakelay.chipmong.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/ask")
    public ResponseEntity<List<String>> askCarName(@RequestParam String name) {
        List<String> result = carService.askCarName(name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addCar(@RequestParam String name, @RequestParam int wheels) {
        Map<String, String> response = carService.addCar(name, wheels);
        return ResponseEntity.ok(response);
    }
}
