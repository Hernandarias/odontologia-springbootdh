package com.dhbackend.odontologia_integradorfinal.controller;

import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.model.PacienteDto;
import com.dhbackend.odontologia_integradorfinal.service.OdontologoService;
import com.dhbackend.odontologia_integradorfinal.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<List<PacienteDto>> getAllPacientes() {
        List<PacienteDto> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> getPacienteById(@PathVariable int id) {
        PacienteDto dto = service.getPacienteById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<PacienteDto> createPaciente(@RequestBody PacienteDto dto) {
        return ResponseEntity.ok(service.createPaciente(dto));
    }
    @PostMapping("/edit")
    public ResponseEntity<PacienteDto> editPaciente(@RequestBody PacienteDto dto) {
        return ResponseEntity.ok(service.editPaciente(dto));
    }

    @PostMapping("/delete/{id}")
    public void deletePaciente(@PathVariable int id) {
        service.deletePaciente(id);
    }
}
