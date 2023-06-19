package com.dhbackend.odontologia_integradorfinal.controller;

import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public ResponseEntity<List<OdontologoDto>> getAllOdontologos() {
        List<OdontologoDto> odontologos = odontologoService.findAll();
        return ResponseEntity.ok(odontologos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDto> getOdontologoById(@PathVariable int id) {
        OdontologoDto odontologo = odontologoService.getOdontologoById(id);
        return ResponseEntity.ok(odontologo);
    }

    @PostMapping("/create")
    public ResponseEntity<OdontologoDto> createOdontologo(@RequestBody OdontologoDto odontologoDto) {
        return ResponseEntity.ok(odontologoService.createOdontologo(odontologoDto));
    }
    @PostMapping("/edit")
    public ResponseEntity<OdontologoDto> editOdontologo(@RequestBody OdontologoDto odontologoDto) {
        return ResponseEntity.ok(odontologoService.editOdontologo(odontologoDto));
    }

    @PostMapping("/delete/{id_odontologo}")
    public void deleteOdontologo(@PathVariable int id_odontologo) {
        odontologoService.deleteOdontologo(id_odontologo);
    }
}
