package mx.edu.uteq.idgs12.microservicio_division.dto;

import lombok.Data;

@Data
public class ProgramaEducativoToViewListDto {
    private Long programaId;
    private String programa;
    private boolean activo;
    private String divisionNombre;
    private Long divisionId;
}
