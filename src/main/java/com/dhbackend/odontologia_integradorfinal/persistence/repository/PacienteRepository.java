package com.dhbackend.odontologia_integradorfinal.persistence.repository;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    Optional<Paciente> findById(int id);
}