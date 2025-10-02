package mx.edu.uteq.idgs12.microservicio_division.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;

@Service
public class DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    // Aqui puedes agregar metodos parr manejar la logica

    public Division save(Division division) {
        return divisionRepository.save(division);
    }
}
