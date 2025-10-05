package mx.edu.uteq.idgs12.microservicio_division.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;

@Service
public class ProgramaEducativoService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private ProgramaEducativoRepository programaEducativoRepository;

    // Listar todos los programas educativos
    public List<ProgramaEducativoToViewListDto> findAll() {
        List<ProgramaEducativo> programas = programaEducativoRepository.findAll();
        List<ProgramaEducativoToViewListDto> resultado = new ArrayList<>();

        for (ProgramaEducativo programa : programas) {
            resultado.add(mapToDto(programa));
        }

        return resultado;
    }

    // Buscar un programa educativo por ID
    public ProgramaEducativoToViewListDto findById(Long id) {
        ProgramaEducativo programa = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa Educativo no encontrado con ID: " + id));
        return mapToDto(programa);
    }

    // Agregar un programa educativo
    public ProgramaEducativoToViewListDto create(ProgramaEducativoToCreateDto dto) {
        ProgramaEducativo entity = new ProgramaEducativo();
        entity.setPrograma(dto.getPrograma());
        entity.setActivo(dto.isActivo());

        if (dto.getDivisionId() != null) {
            Division division = divisionRepository.findById(dto.getDivisionId())
                    .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + dto.getDivisionId()));
            entity.setDivision(division);
        }

        ProgramaEducativo saved = programaEducativoRepository.save(entity);
        return mapToDto(saved);
    }

    // Editar un programa educativo
    public ProgramaEducativoToViewListDto update(Long id, ProgramaEducativoToUpdateDto dto) {
        ProgramaEducativo programa = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa Educativo no encontrado con ID: " + id));

        programa.setPrograma(dto.getPrograma());
        programa.setActivo(dto.isActivo());

        if (dto.getDivisionId() != null) {
            Division division = divisionRepository.findById(dto.getDivisionId())
                    .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + dto.getDivisionId()));
            programa.setDivision(division);
        }

        ProgramaEducativo updated = programaEducativoRepository.save(programa);
        return mapToDto(updated);
    }

    // Eliminar un programa educativo
    public void delete(Long id) {
        if (!programaEducativoRepository.existsById(id)) {
            throw new RuntimeException("Programa Educativo no encontrado con ID: " + id);
        }
        programaEducativoRepository.deleteById(id);
    }

    // Conversión de entidad a DTO
    private ProgramaEducativoToViewListDto mapToDto(ProgramaEducativo programa) {
        ProgramaEducativoToViewListDto dto = new ProgramaEducativoToViewListDto();
        dto.setProgramaId(programa.getId());
        dto.setPrograma(programa.getPrograma());
        dto.setActivo(programa.isActivo());

        if (programa.getDivision() != null) {
            dto.setDivisionId(programa.getDivision().getId());
            dto.setDivisionNombre(programa.getDivision().getNombre());
        }

        return dto;
    }
}