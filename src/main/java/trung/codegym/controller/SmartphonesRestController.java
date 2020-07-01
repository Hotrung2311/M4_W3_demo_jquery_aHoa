package trung.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trung.codegym.model.SmartPhone;
import trung.codegym.service.PhoneService;

import java.util.List;

@RestController
@RequestMapping("/api/smartphones")
public class SmartphonesRestController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("")
    public List<SmartPhone> getAllPhones() {
        return (List<SmartPhone>) phoneService.findAll();
    }

    @PostMapping("")
    public SmartPhone createSmartphone(@RequestBody SmartPhone smartPhone) {
        return phoneService.save(smartPhone);
    }
}
