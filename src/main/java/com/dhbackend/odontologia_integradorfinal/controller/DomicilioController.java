package com.dhbackend.odontologia_integradorfinal.controller;

import com.dhbackend.odontologia_integradorfinal.model.DomicilioDto;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.service.DomicilioService;
import com.dhbackend.odontologia_integradorfinal.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    private DomicilioService dService;

    @GetMapping
    public ResponseEntity<List<DomicilioDto>> getAllDomicilios() {
        List<DomicilioDto> ds = dService.findAll();
        return ResponseEntity.ok(ds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDto> getDById(@PathVariable int id) {
        DomicilioDto d = dService.getDomicilioById(id);
        return ResponseEntity.ok(d);
    }

    @PostMapping("/create")
    public ResponseEntity<DomicilioDto> createD(@RequestBody DomicilioDto dd) {
        return ResponseEntity.ok(dService.createDomicilio(dd));
    }

    @PostMapping("/edit")
    public ResponseEntity<DomicilioDto> editD(@RequestBody DomicilioDto dd) {
        return ResponseEntity.ok(dService.editDomicilio(dd));
    }

    @PostMapping("/delete/{id_domicilio}")
    public void deleteD(@PathVariable int id_domicilio) {
        dService.deleteDomicilio(id_domicilio);
    }

}
