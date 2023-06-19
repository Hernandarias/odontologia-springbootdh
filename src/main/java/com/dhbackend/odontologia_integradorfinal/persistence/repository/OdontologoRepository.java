package com.dhbackend.odontologia_integradorfinal.persistence.repository;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {

    Optional<Odontologo> findById(int id);
}