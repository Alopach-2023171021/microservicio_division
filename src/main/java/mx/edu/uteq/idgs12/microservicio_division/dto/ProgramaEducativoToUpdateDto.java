package mx.edu.uteq.idgs12.microservicio_division.dto;

import lombok.Data;

@Data
public class ProgramaEducativoToUpdateDto {
    private String programa;
    private boolean activo;
    private Long divisionId;
}