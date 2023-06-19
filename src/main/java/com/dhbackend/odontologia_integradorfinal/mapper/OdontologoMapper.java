package com.dhbackend.odontologia_integradorfinal.mapper;

import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;

import java.util.List;
import java.util.stream.Collectors;

public class OdontologoMapper {
    public static OdontologoDto mapToDto(Odontologo odontologo) {
        OdontologoDto odontologoDTO = new OdontologoDto();
        odontologoDTO.setId_od(odontologo.getId_od());
        odontologoDTO.setMat_od(odontologo.getMat_od());
        odontologoDTO.setNom_od(odontologo.getNom_od());
        odontologoDTO.setApe_od(odontologo.getApe_od());
        return odontologoDTO;
    }

    public static List<OdontologoDto> mapToDtoList(List<Odontologo> odontologos) {
        return odontologos.stream()
            .map(OdontologoMapper::mapToDto)
            .collect(Collectors.toList());
    }
}
