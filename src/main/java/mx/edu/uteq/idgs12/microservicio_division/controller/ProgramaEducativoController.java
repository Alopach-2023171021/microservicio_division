package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.service.ProgramaEducativoService;

@RestController
@RequestMapping("/api/programas")
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoService programaEducativoService;

    // =========================
    // Obtener todos los programas educativos
    // =========================
    @GetMapping
    public List<ProgramaEducativoToViewListDto> findAll() {
        return programaEducativoService.findAll();
    }

    // =========================
    // Obtener un programa educativo por su ID
    // =========================
    @GetMapping("/{id}")
    public ProgramaEducativoToViewListDto findById(@PathVariable Long id) {
        return programaEducativoService.findById(id);
    }

    // =========================
    // Crear un nuevo programa educativo
    // =========================
    @PostMapping
    public ProgramaEducativoToViewListDto create(@RequestBody ProgramaEducativoToCreateDto dto) {
        return programaEducativoService.create(dto);
    }

    // =========================
    // Actualizar un programa educativo existente
    // =========================
    @PutMapping("/{id}")
    public ProgramaEducativoToViewListDto update(@PathVariable Long id, @RequestBody ProgramaEducativoToUpdateDto dto) {
        return programaEducativoService.update(id, dto);
    }
}
