package com.dhbackend.odontologia_integradorfinal.controller;

import com.dhbackend.odontologia_integradorfinal.mapper.OdontologoMapper;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.model.TurnoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService service;

    @GetMapping
    public ResponseEntity<List<TurnoDto>> getAllTurnos() {
        List<TurnoDto> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDto> getTurnoById(@PathVariable int id) {
        TurnoDto dto = service.getTurnoById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/odontologo/{id}")
    public ResponseEntity<List<TurnoDto>> getTurnoByOdontologo(@PathVariable int id) {
        List<TurnoDto> dto = service.getTurnoByOdontologo(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<TurnoDto>> getTurnoByPaciente(@PathVariable int id) {
        List<TurnoDto> dto = service.getTurnoByPaciente(id);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/create")
    public ResponseEntity<TurnoDto> createTurno(@RequestBody TurnoDto dto) {
        return ResponseEntity.ok(service.createTurno(dto));
    }
    @PostMapping("/edit")
    public ResponseEntity<TurnoDto> editTurno(@RequestBody TurnoDto dto) {
        return ResponseEntity.ok(service.editTurno(dto));
    }

    @PostMapping("/delete/{id}")
    public void deleteTurno(@PathVariable int id) {
        service.deleteTurno(id);
    }
}
