package com.dhbackend.odontologia_integradorfinal.service;

import com.dhbackend.odontologia_integradorfinal.mapper.OdontologoMapper;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.OdontologoRepository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    Logger logger = LogManager.getLogger(OdontologoService.class);
    @Autowired
    private OdontologoRepository repository;

    public List<OdontologoDto> findAll() {
        try {
            List<Odontologo> odontologos = repository.findAll();
            logger.info("Se listaron todos los odontologos");
            return OdontologoMapper.mapToDtoList(odontologos);
        } catch (Exception e) {
            logger.error("No se pudieron listar los odontologos por: " + e.getMessage());
            return null;
        }
    }

    public OdontologoDto getOdontologoById(int id) {
        try {
            Optional<Odontologo> odontologoOptional = repository.findById(id);
            if (odontologoOptional.isPresent()) {
                Odontologo odontologo = odontologoOptional.get();
                logger.info("Se encontro el odontologo con id: " + id + " " + odontologo.toString());
                return OdontologoMapper.mapToDto(odontologo);
            } else {
                logger.error("No se encontro el odontologo con id: " + id);
                return null;
            }
        } catch (Exception e) {
            logger.error("No se pudo encontrar el odontologo por: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public OdontologoDto createOdontologo(OdontologoDto odontologoDTO) {
        try {
            Odontologo odontologo = new Odontologo(odontologoDTO.getId_od(), odontologoDTO.getMat_od(), odontologoDTO.getNom_od(), odontologoDTO.getApe_od());
            odontologo = repository.saveAndFlush(odontologo);
            logger.info("Se creo el odontologo con id: " + odontologo.getId_od() + " " + odontologo.toString());
            return OdontologoMapper.mapToDto(odontologo);
        } catch (Exception e) {
            logger.error("No se pudo crear el odontologo por: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public OdontologoDto editOdontologo(OdontologoDto odontologoDTO) {
        try {
            Odontologo odontologo = new Odontologo(odontologoDTO.getId_od(), odontologoDTO.getMat_od(), odontologoDTO.getNom_od(), odontologoDTO.getApe_od());
            odontologo = repository.saveAndFlush(odontologo);
            logger.info("Se edito el odontologo con id: " + odontologo.getId_od() + " " + odontologo.toString());
            return OdontologoMapper.mapToDto(odontologo);
        } catch (Exception e) {
            logger.error("No se pudo editar el odontologo por: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public void deleteOdontologo(int id) {
        try {
            repository.deleteById(id);
            logger.info("Se elimino el odontologo con id: " + id);
        } catch (Exception e) {
            logger.error("No se pudo eliminar el odontologo por: " + e.getMessage());
        }
    }

}
