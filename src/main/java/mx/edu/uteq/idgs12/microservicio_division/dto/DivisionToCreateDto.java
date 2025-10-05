package mx.edu.uteq.idgs12.microservicio_division.dto;

import lombok.Data;
import java.util.List;

@Data
public class DivisionToCreateDto {
    private String nombre;
    private String image;
    private boolean activo;
    private List<String> programasEducativos;
}
