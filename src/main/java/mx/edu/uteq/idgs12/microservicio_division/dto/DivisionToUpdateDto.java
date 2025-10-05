package mx.edu.uteq.idgs12.microservicio_division.dto;

import lombok.Data;

@Data
public class DivisionToUpdateDto {
    private String nombre;
    private String image;
    private boolean activo;
}