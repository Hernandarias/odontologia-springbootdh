package com.dhbackend.odontologia_integradorfinal.persistence.repository;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {

    Optional<Turno> findById(int id);

    @Query(value="SELECT * FROM turno where id_od= ?1", nativeQuery = true)
    List<Turno> findByOdontologo(int id);

    @Query(value="SELECT * FROM turno where id_pac= ?1", nativeQuery = true)
    List<Turno> findByPaciente(int id);

}