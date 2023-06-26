package com.dhbackend.odontologia_integradorfinal;

import com.dhbackend.odontologia_integradorfinal.model.TurnoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Turno;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.TurnoRepository;
import com.dhbackend.odontologia_integradorfinal.service.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TurnoServiceTest {
    @Mock
    private TurnoRepository repository;

    @InjectMocks
    private TurnoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Odontologo o = new Odontologo(1, "1", "1", "1");
        LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);
        LocalDateTime b = LocalDateTime.of(2019, 2, 13, 15, 56);
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");
        Paciente p = new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));
        List<Turno> os = Arrays.asList(
                new Turno(1,p,o,a),
                new Turno(2,p,o,b)
        );
        when(repository.findAll()).thenReturn(os);

        List<TurnoDto> result = service.findAll();

        assertEquals(2, result.size());

    }

    @Test
    void testGetTurnoById() {
        Odontologo o = new Odontologo(1, "1", "1", "1");
        LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");
        int id = 1;
        Paciente p = new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));

        Turno t=new Turno(1,p,o,a);

        when(repository.findById(id)).thenReturn(Optional.of(t));

        TurnoDto result = service.getTurnoById(id);

        assertNotNull(result);
        assertEquals(t.getId_turno(), result.getId_turno());

    }

    @Test
    void testCreateTurno() {
        Odontologo o = new Odontologo(1, "1", "1", "1");
        LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");

        Paciente p = new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));
        Turno t=new Turno(1,p,o,a);
        when(repository.saveAndFlush(t)).thenReturn(t);

        assertNotNull(t);
        assertEquals(t.getId_turno(), 1);

    }

    @Test
    void testDeleteTurno() {
        Odontologo o = new Odontologo(1, "1", "1", "1");
        LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");

        int id = 1;
        Paciente p= new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));
        Turno t=new Turno(1,p,o,a);
        when(repository.existsById(id)).thenReturn(true);
        when(repository.findById(id)).thenReturn(Optional.of(t));

        service.deleteTurno(id);

        verify(repository).deleteById(id);
    }
}
