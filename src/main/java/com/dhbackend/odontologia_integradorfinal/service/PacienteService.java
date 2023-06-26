package com.dhbackend.odontologia_integradorfinal.service;

import com.dhbackend.odontologia_integradorfinal.controller.exception.ResourceNotFoundException;
import com.dhbackend.odontologia_integradorfinal.mapper.OdontologoMapper;
import com.dhbackend.odontologia_integradorfinal.mapper.PacienteMapper;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.model.PacienteDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.OdontologoRepository;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.PacienteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    Logger logger = LogManager.getLogger(PacienteService.class);
    @Autowired
    private PacienteRepository repository;

    public List<PacienteDto> findAll() {
        try {
            List<Paciente> ps = repository.findAll();
            logger.info("Pacientes encontrados tras listar todos: " + ps.size());
            return PacienteMapper.mapToDtoList(ps);
        } catch (Exception e) {
            logger.error("Error al listar todos los pacientes: " + e.getMessage());
            return null;
        }
    }

    public PacienteDto getPacienteById(int id) {
        try {
            Optional<Paciente> pOptional = repository.findById(id);
            if (pOptional.isPresent()) {
                Paciente p = pOptional.get();
                logger.info("Paciente encontrado por id: " + p.toString());
                return PacienteMapper.mapToDto(p);
            } else {
                logger.error("Paciente no encontrado por id: " + id);
                return null;
            }
        } catch (Exception e) {
            logger.error("Error al buscar paciente por id: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public PacienteDto createPaciente(PacienteDto dd) {
        try {
            Paciente p = new Paciente(dd.getId_pac(), dd.getNom_pac(), dd.getApe_pac(), dd.getDni_pac(), dd.getDomicilio(), dd.getFecha_ingreso_pac());
            p = repository.saveAndFlush(p);
            logger.info("Paciente creado: " + p.toString());
            return PacienteMapper.mapToDto(p);
        }catch (Exception e){
            logger.error("Error al crear paciente: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public PacienteDto editPaciente(PacienteDto dd) {
        try {
            Paciente p = new Paciente(dd.getId_pac(), dd.getNom_pac(), dd.getApe_pac(), dd.getDni_pac(), dd.getDomicilio(), dd.getFecha_ingreso_pac());
            p = repository.saveAndFlush(p);
            logger.info("Paciente editado: " + p.toString());
            return PacienteMapper.mapToDto(p);

        }catch (Exception e){
            logger.error("Error al editar paciente: " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public void deletePaciente(int id) {

        try {
            if (!repository.existsById(id)){
                logger.error("No existe paciente con id: " + id);
                throw new ResourceNotFoundException("No existe paciente con id: " + id);
            }
            repository.deleteById(id);
            logger.info("Paciente eliminado por id: " + id);
        }catch (Exception e){
            logger.error("Error al eliminar paciente por id: " + e.getMessage());
        }
    }

}
