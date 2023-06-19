package com.dhbackend.odontologia_integradorfinal.mapper;

import com.dhbackend.odontologia_integradorfinal.model.DomicilioDto;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;

import java.util.List;
import java.util.stream.Collectors;

public class DomicilioMapper {
    public static DomicilioDto mapToDto(Domicilio domicilio) {
        DomicilioDto domicilioDTO = new DomicilioDto();
        domicilioDTO.setId_domicilio(domicilio.getId_domicilio());
        domicilioDTO.setCalle_domicilio(domicilio.getCalle_domicilio());
        domicilioDTO.setNro_puerta_domicilio(domicilio.getNro_puerta_domicilio());
        domicilioDTO.setCiudad_domicilio(domicilio.getCiudad_domicilio());
        domicilioDTO.setProvincia_domicilio(domicilio.getProvincia_domicilio());
        return domicilioDTO;
    }

    public static List<DomicilioDto> mapToDtoList(List<Domicilio> domicilio) {
        return domicilio.stream()
            .map(DomicilioMapper::mapToDto)
            .collect(Collectors.toList());
    }
}
