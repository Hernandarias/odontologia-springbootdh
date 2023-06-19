package com.dhbackend.odontologia_integradorfinal.mapper;

import com.dhbackend.odontologia_integradorfinal.model.DomicilioDto;
import com.dhbackend.odontologia_integradorfinal.model.PacienteDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;

import java.util.List;
import java.util.stream.Collectors;

public class PacienteMapper {
    public static PacienteDto mapToDto(Paciente p) {
        PacienteDto dd = new PacienteDto();
        dd.setId_pac(p.getId_pac());
        dd.setDomicilio(p.getDomicilio());
        dd.setNom_pac(p.getNom_pac());
        dd.setApe_pac(p.getApe_pac());
        dd.setDni_pac(p.getDni_pac());
        dd.setFecha_ingreso_pac(p.getFecha_ingreso_pac());
        return dd;
    }

    public static List<PacienteDto> mapToDtoList(List<Paciente> pp) {
        return pp.stream()
            .map(PacienteMapper::mapToDto)
            .collect(Collectors.toList());
    }
}
