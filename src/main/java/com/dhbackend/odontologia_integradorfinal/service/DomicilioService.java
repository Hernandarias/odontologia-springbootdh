package com.dhbackend.odontologia_integradorfinal.service;

import com.dhbackend.odontologia_integradorfinal.controller.exception.ResourceNotFoundException;
import com.dhbackend.odontologia_integradorfinal.mapper.DomicilioMapper;
import com.dhbackend.odontologia_integradorfinal.mapper.OdontologoMapper;
import com.dhbackend.odontologia_integradorfinal.model.DomicilioDto;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.DomicilioRepository;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.OdontologoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    Logger logger = LogManager.getLogger(DomicilioService.class);
    @Autowired
    private DomicilioRepository repository;

    public List<DomicilioDto> findAll() {
        try {
            List<Domicilio> ds1 = repository.findAll();
            logger.info("Se listados todos los domicilios");
            return DomicilioMapper.mapToDtoList(ds1);
        }catch (Exception e){
            logger.error("Error al listar domicilios: " + e.getMessage());
            return null;
        }
    }

    public DomicilioDto getDomicilioById(int id) {
        try{
            Optional<Domicilio> dOptional = repository.findById(id);
            if (dOptional.isPresent()) {
                Domicilio d = dOptional.get();
                logger.info("Domicilio encontrado: " + d.toString());
                return DomicilioMapper.mapToDto(d);
            } else {
                logger.error("Domicilio no encontrado con id: " + id);
                return null;
            }
        }catch (Exception e){
            logger.error("Error al buscar domicilio: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public DomicilioDto createDomicilio(DomicilioDto dd) {
        try {
            Domicilio d = new Domicilio(dd.getId_domicilio(), dd.getCalle_domicilio(), dd.getNro_puerta_domicilio(), dd.getCiudad_domicilio(), dd.getProvincia_domicilio());
            d = repository.saveAndFlush(d);
            logger.info("Domicilio creado: " + d.toString());
            return DomicilioMapper.mapToDto(d);
        }catch (Exception e){
            logger.error("Error al crear domicilio: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public DomicilioDto editDomicilio(DomicilioDto dd) {
        try {
            Domicilio d = new Domicilio(dd.getId_domicilio(), dd.getCalle_domicilio(), dd.getNro_puerta_domicilio(), dd.getCiudad_domicilio(), dd.getProvincia_domicilio());
            d = repository.saveAndFlush(d);
            logger.info("Domicilio editado: " + d.toString());
            return DomicilioMapper.mapToDto(d);
        }
        catch (Exception e){
            logger.error("Error al editar domicilio: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public void deleteDomicilio(int id) {
        try{
            if (!repository.existsById(id)) {
                logger.error("Domicilio no encontrado con id: " + id);
                throw new ResourceNotFoundException("Domicilio no encontrado con id: " + id);
            }
            repository.deleteById(id);
            logger.info("Domicilio eliminado con id: " + id);
        }
        catch (Exception e){
            logger.error("Error al eliminar domicilio: " + e.getMessage());
        }
    }


}
