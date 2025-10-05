package mx.edu.uteq.idgs12.microservicio_division.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    // Listar todas las divisiones
    public List<DivisionToViewListDto> findAll() {
        List<Division> divisiones = divisionRepository.findAll();
        List<DivisionToViewListDto> resultado = new ArrayList<>();
        for (Division division : divisiones) {
            resultado.add(convertirADto(division));
        }
        return resultado;
    }

    // Buscar una división por ID
    public DivisionToViewListDto findById(Long id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + id));
        return convertirADto(division);
    }

    // Borrar una división
    public void delete(Long id) {
        if (!divisionRepository.existsById(id)) {
            throw new RuntimeException("División no encontrada con ID: " + id);
        }
        divisionRepository.deleteById(id);
    }

    // Habilitar una división
    public DivisionToViewListDto habilitar(Long id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + id));

        division.setActivo(true);
        Division updated = divisionRepository.save(division);

        return convertirADto(updated);
    }

    // Deshabilitar una división
    public DivisionToViewListDto deshabilitar(Long id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + id));

        division.setActivo(false);
        Division updated = divisionRepository.save(division);

        return convertirADto(updated);
    }

    // Crear una nueva división
    public DivisionToViewListDto create(DivisionToCreateDto dto) {
        Division entity = new Division();
        entity.setNombre(dto.getNombre());
        entity.setImage(dto.getImage());
        entity.setActivo(dto.isActivo());

        Division saved = divisionRepository.save(entity);

        return convertirADto(saved);
    }

    // Actualizar una división existente
    public DivisionToViewListDto update(Long id, DivisionToUpdateDto dto) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + id));

        division.setNombre(dto.getNombre());
        division.setImage(dto.getImage());
        division.setActivo(dto.isActivo());

        Division updated = divisionRepository.save(division);

        return convertirADto(updated);
    }

    // Convertir entidad a DTO
    private DivisionToViewListDto convertirADto(Division division) {
        DivisionToViewListDto dto = new DivisionToViewListDto();
        dto.setDivisionId(division.getId());
        dto.setNombre(division.getNombre());
        dto.setImage(division.getImage());
        dto.setActivo(division.isActivo());

        if (division.getProgramaEducativo() != null) {
            List<String> programas = new ArrayList<>();
            for (ProgramaEducativo prog : division.getProgramaEducativo()) {
                programas.add(prog.getPrograma());
            }
            dto.setProgramasEducativos(programas);
        } else {
            dto.setProgramasEducativos(new ArrayList<>());
        }

        return dto;
    }
}