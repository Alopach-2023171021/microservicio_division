package com.idgs12.idgs12.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.idgs12.idgs12.dto.DivisionToCreateDto;
import com.idgs12.idgs12.dto.DivisionToUpdateDto;
import com.idgs12.idgs12.dto.DivisionToViewListDto;
import com.idgs12.idgs12.services.DivisionService;

@RestController
@RequestMapping("/api")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @PostMapping("/divisiones")
    public DivisionToViewListDto create(@RequestBody DivisionToCreateDto dto) {
        return divisionService.create(dto);
    }

    @PutMapping("/divisiones/{id}")
    public DivisionToViewListDto update(@PathVariable Long id, @RequestBody DivisionToUpdateDto dto) {
        return divisionService.update(id, dto);
    }
}
