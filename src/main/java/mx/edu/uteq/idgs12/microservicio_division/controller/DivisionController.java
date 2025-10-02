package mx.edu.uteq.idgs12.microservicio_division.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/division")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @PostMapping
    public Division save(@RequestBody Division division) {
        return divisionService.save(division);
    }

}
