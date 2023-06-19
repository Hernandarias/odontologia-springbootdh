package com.dhbackend.odontologia_integradorfinal.mapper;

import com.dhbackend.odontologia_integradorfinal.model.PacienteDto;
import com.dhbackend.odontologia_integradorfinal.model.TurnoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Turno;

import java.util.List;
import java.util.stream.Collectors;

public class TurnoMapper {
    public static TurnoDto mapToDto(Turno d) {
        TurnoDto dd = new TurnoDto();
        dd.setId_turno(d.getId_turno());
        dd.setFecha_hora(d.getFecha_hora());
        dd.setOdontologo(d.getOdontologo());
        dd.setPaciente(d.getPaciente());
        return dd;
    }

    public static List<TurnoDto> mapToDtoList(List<Turno> pp) {
        return pp.stream()
            .map(TurnoMapper::mapToDto)
            .collect(Collectors.toList());
    }
}
