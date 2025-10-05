package mx.edu.uteq.idgs12.microservicio_division.dto;

import java.util.List;

import lombok.Data;

@Data
public class DivisionToViewListDto {
    private Long divisionId;
    private String nombre;
    private String image;
    private boolean activo;
    private List<String> programasEducativos;
}
