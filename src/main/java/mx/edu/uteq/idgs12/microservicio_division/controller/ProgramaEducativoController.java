package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api")
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoService programaEducativoService;

    // listar todos los programas educativos
    @GetMapping
    public List<ProgramaEducativoToViewListDto> listarProgramas() {
        return programaEducativoService.findAll();
    }

    // Agregar un nuevo programa educativo
    @PostMapping
    public ProgramaEducativoToViewListDto crearPrograma(@RequestBody ProgramaEducativoToCreateDto dto) {
        return programaEducativoService.create(dto);
    }

    // editar un programa educativo
    @PutMapping("/{id}")
    public ProgramaEducativoToViewListDto actualizarPrograma(
            @PathVariable Long id,
            @RequestBody ProgramaEducativoToUpdateDto dto) {
        return programaEducativoService.update(id, dto);
    }
    // Eliminar un programa educativo

    @GetMapping("/programas")
    public List<ProgramaEducativoToViewListDto> findAll() {
        return programaEducativoService.findAll();
    }

    @GetMapping("/programas/{id}")
    public ProgramaEducativoToViewListDto findById(@PathVariable Long id) {
        return programaEducativoService.findById(id);
    }

    @DeleteMapping("/programas/{id}")
    public void delete(@PathVariable Long id) {
        programaEducativoService.delete(id);
    }

}
