package com.dhbackend.odontologia_integradorfinal.service;

import com.dhbackend.odontologia_integradorfinal.controller.exception.ResourceNotFoundException;
import com.dhbackend.odontologia_integradorfinal.mapper.TurnoMapper;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.model.PacienteDto;
import com.dhbackend.odontologia_integradorfinal.model.TurnoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Turno;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.OdontologoRepository;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.TurnoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    Logger logger = LogManager.getLogger(TurnoService.class);
    @Autowired
    private TurnoRepository repository;


    public List<TurnoDto> findAll() {
        try {
            List<Turno> ds1 = repository.findAll();
            logger.info("Se listaron todos los turnos, son: " + ds1.size());
            return TurnoMapper.mapToDtoList(ds1);
        } catch (Exception e) {
            logger.error("No se pudieron listar los turnos: "+e.getMessage());
            return null;
        }
    }

    public List<TurnoDto> getTurnoByOdontologo(int id) {
        try {
            List<Turno> ds1 = repository.findByOdontologo(id);
            logger.info("Se listaron todos los turnos del odontologo: " + id + " , son: " + ds1.size());
            return TurnoMapper.mapToDtoList(ds1);
        } catch (Exception e) {
            logger.error("No se pudieron listar los turnos del odontologo: "+id+" , error: "+e.getMessage());
            return null;
        }
    }

    public List<TurnoDto> getTurnoByPaciente(int id) {
        try {
            List<Turno> ds1 = repository.findByPaciente(id);
            logger.info("Se listaron todos los turnos del paciente: " + id + " , son: " + ds1.size());
            return TurnoMapper.mapToDtoList(ds1);
        } catch (Exception e) {
            logger.error("No se pudieron listar los turnos del paciente: "+id+" , error: "+e.getMessage());
            return null;
        }
    }


    public TurnoDto getTurnoById(int id) {
        try {
            Optional<Turno> dOptional = repository.findById(id);
            if (dOptional.isPresent()) {
                Turno d = dOptional.get();
                logger.info("Se listo el turno con id: " + id + " , es: " + dOptional.toString());
                return TurnoMapper.mapToDto(d);
            } else {
                logger.error("No se encontro el turno con id: " + id);
                return null;
            }
        } catch (Exception e) {
            logger.error("No se encontro el turno con id: " + id + " , error: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public TurnoDto createTurno(TurnoDto dd) {
        try {
            Turno d = new Turno(dd.getId_turno(), dd.getPaciente(), dd.getOdontologo(), dd.getFecha_hora());
            d = repository.saveAndFlush(d);
            logger.info("Se creo el turno con id: " + dd.getId_turno());
            return TurnoMapper.mapToDto(d);
        } catch (Exception e) {
            logger.error("No se pudo crear el turno, error: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public TurnoDto editTurno(TurnoDto dd) {
        try {
            Turno d = new Turno(dd.getId_turno(), dd.getPaciente(), dd.getOdontologo(), dd.getFecha_hora());
            d = repository.saveAndFlush(d);
            logger.info("Se edito el turno con id: " + dd.getId_turno());
            return TurnoMapper.mapToDto(d);
        } catch (Exception e) {
            logger.error("No se pudo editar el turno, error: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public void deleteTurno(int id) {
        try {
            if(!repository.existsById(id)){
                logger.error("No se pudo eliminar el turno con id: " + id + " , error: el turno no se encuentra registrado en el sistema");
                throw new ResourceNotFoundException("El turno no se encuentra registrado en el sistema", id);
            }
            repository.deleteById(id);
            logger.info("Se elimino el turno con id: " + id);
        } catch (Exception e) {
            logger.error("No se pudo eliminar el turno con id: " + id + " , error: " + e.getMessage());

        }
    }


}
