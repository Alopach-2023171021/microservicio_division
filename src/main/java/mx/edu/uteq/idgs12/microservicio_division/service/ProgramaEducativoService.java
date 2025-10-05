package mx.edu.uteq.idgs12.microservicio_division.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToCreateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToUpdateDto;
import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;

@Service
public class ProgramaEducativoService {

    @Autowired
    private ProgramaEducativoRepository programaEducativoRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    // =========================
    // Listar todos los programas educativos
    // =========================
    public List<ProgramaEducativoToViewListDto> findAll() {
        List<ProgramaEducativo> programas = programaEducativoRepository.findAll();
        List<ProgramaEducativoToViewListDto> resultado = new ArrayList<>();

        for (ProgramaEducativo programa : programas) {
            resultado.add(convertirADto(programa));
        }

        return resultado;
    }

    // =========================
    // Buscar un programa educativo por ID
    // =========================
    public ProgramaEducativoToViewListDto findById(Long id) {
        ProgramaEducativo programa = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa Educativo no encontrado con ID: " + id));

        return convertirADto(programa);
    }

    // =========================
    // Crear un nuevo programa educativo
    // =========================
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
        return convertirADto(saved);
    }

    // =========================
    // Actualizar un programa educativo existente
    // =========================
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
        return convertirADto(updated);
    }

    // =========================
    // Método auxiliar para convertir a DTO
    // =========================
    private ProgramaEducativoToViewListDto convertirADto(ProgramaEducativo programa) {
        ProgramaEducativoToViewListDto dto = new ProgramaEducativoToViewListDto();
        dto.setProgramaId(programa.getId());
        dto.setPrograma(programa.getPrograma());
        dto.setActivo(programa.isActivo());

        if (programa.getDivision() != null) {
            dto.setDivisionNombre(programa.getDivision().getNombre());
            dto.setDivisionId(programa.getDivision().getId());
        }

        return dto;
    }
}
