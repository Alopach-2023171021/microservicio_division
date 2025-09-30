package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(length= 100)
    private String nombre;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
