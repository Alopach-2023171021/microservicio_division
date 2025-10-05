package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;

@RestController
@RequestMapping("/api")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping("/divisiones")
    public List<DivisionToViewListDto> findAll() {
        return divisionService.findAll();
    }

    @GetMapping("/divisiones/{id}")
    public DivisionToViewListDto findById(@PathVariable Long id) {
        return divisionService.findById(id);
    }

    @GetMapping
    public List<DivisionToViewListDto> getAllDivisiones() {
        return divisionService.findAll();
    }

    // Borrar división
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        divisionService.delete(id);
    }

    // Habilitar división (activar)
    @PutMapping("/habilitar/{id}")
    public DivisionToViewListDto habilitar(@PathVariable Long id) {
        return divisionService.habilitar(id);
    }

    // Deshabilitar división (desactivar)
    @PutMapping("/deshabilitar/{id}")
    public DivisionToViewListDto deshabilitar(@PathVariable Long id) {
        return divisionService.deshabilitar(id);
    }

    // Crear una nueva división
    @PostMapping("/divisiones")
    public DivisionToViewListDto create(@RequestBody DivisionToCreateDto dto) {
        return divisionService.create(dto);
    }

    // Actualizar una división existente
    @PutMapping("/divisiones/{id}")
    public DivisionToViewListDto update(@PathVariable Long id, @RequestBody DivisionToUpdateDto dto) {
        return divisionService.update(id, dto);
    }

}
