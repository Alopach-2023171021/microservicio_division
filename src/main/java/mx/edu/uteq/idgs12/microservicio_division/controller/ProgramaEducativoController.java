package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.service.ProgramaEducativoService;

@RestController
@RequestMapping("/api/programas")
@CrossOrigin(origins = "*")

public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoService programaEducativoService;

    // Listar todos los programas educativos
    @GetMapping
    public List<ProgramaEducativoToViewListDto> findAll() {
        return programaEducativoService.findAll();
    }

    // Buscar programa por ID
    @GetMapping("/{id}")
    public ProgramaEducativoToViewListDto findById(@PathVariable Long id) {
        return programaEducativoService.findById(id);
    }

    // Agregar un nuevo programa educativo
    @PostMapping
    public ProgramaEducativoToViewListDto create(@RequestBody ProgramaEducativoToCreateDto dto) {
        return programaEducativoService.create(dto);
    }

    // Editar un programa educativo
    @PutMapping("/{id}")
    public ProgramaEducativoToViewListDto update(
            @PathVariable Long id,
            @RequestBody ProgramaEducativoToUpdateDto dto) {
        return programaEducativoService.update(id, dto);
    }

    // Eliminar un programa educativo
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        programaEducativoService.delete(id);
    }
}