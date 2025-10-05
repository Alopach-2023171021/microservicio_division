package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;

@RestController
@RequestMapping("/api/divisiones")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    // Obtener todas las divisiones
    @GetMapping
    public List<DivisionToViewListDto> findAll() {
        return divisionService.findAll();
    }

    // Obtener una división por su ID
    @GetMapping("/{id}")
    public DivisionToViewListDto findById(@PathVariable Long id) {
        return divisionService.findById(id);
    }

    // Crear una nueva división
    @PostMapping
    public DivisionToViewListDto create(@RequestBody DivisionToCreateDto dto) {
        return divisionService.create(dto);
    }

    // Actualizar una división existente
    @PutMapping("/{id}")
    public DivisionToViewListDto update(@PathVariable Long id, @RequestBody DivisionToUpdateDto dto) {
        return divisionService.update(id, dto);
    }

    // Eliminar una división
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        divisionService.delete(id);
    }
}
