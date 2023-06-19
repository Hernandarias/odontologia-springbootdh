package com.dhbackend.odontologia_integradorfinal;

import com.dhbackend.odontologia_integradorfinal.model.PacienteDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Paciente;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.PacienteRepository;
import com.dhbackend.odontologia_integradorfinal.service.PacienteService;
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

public class PacienteServiceTest {
    @Mock
    private PacienteRepository repository;

    @InjectMocks
    private PacienteService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");
        List<Paciente> os = Arrays.asList(
                new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56)),
                new Paciente(2, "2", "2", "2",domicilio,LocalDateTime.of(2017, 2, 13, 15, 56))
        );
        when(repository.findAll()).thenReturn(os);

        List<PacienteDto> result = service.findAll();

        assertEquals(2, result.size());

    }

    @Test
    void testGetPacienteById() {
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");
        int id = 1;
        Paciente o = new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));
        when(repository.findById(id)).thenReturn(Optional.of(o));

        PacienteDto result = service.getPacienteById(id);

        assertNotNull(result);
        assertEquals(o.getId_pac(), result.getId_pac());

    }

    @Test
    void testCreatePaciente() {
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");

        Paciente d = new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));
        when(repository.saveAndFlush(d)).thenReturn(d);

        assertNotNull(d);
        assertEquals(d.getId_pac(), 1);

    }

    @Test
    void testDeletePaciente() {
        Domicilio domicilio = new Domicilio(1, "1", "1", "1", "1");

        int id = 1;
        Paciente o = new Paciente(1, "1", "1", "1", domicilio,LocalDateTime.of(2017, 2, 13, 15, 56));
        when(repository.findById(id)).thenReturn(Optional.of(o));

        service.deletePaciente(id);

        verify(repository).deleteById(id);
    }
}
