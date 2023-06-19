package com.dhbackend.odontologia_integradorfinal;

import com.dhbackend.odontologia_integradorfinal.model.DomicilioDto;
import com.dhbackend.odontologia_integradorfinal.model.OdontologoDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Odontologo;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.DomicilioRepository;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.OdontologoRepository;
import com.dhbackend.odontologia_integradorfinal.service.DomicilioService;
import com.dhbackend.odontologia_integradorfinal.service.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OdontologoServiceTest {
    @Mock
    private OdontologoRepository repository;

    @InjectMocks
    private OdontologoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Odontologo> os = Arrays.asList(
                new Odontologo(1, "1", "1", "1"),
                new Odontologo(2, "2", "2", "2")
        );
        when(repository.findAll()).thenReturn(os);

        List<OdontologoDto> result = service.findAll();

        assertEquals(2, result.size());

    }

    @Test
    void testGetOdontologoById() {
        int id = 1;
        Odontologo o = new Odontologo(id, "1", "1", "1");
        when(repository.findById(id)).thenReturn(Optional.of(o));

        OdontologoDto result = service.getOdontologoById(id);

        assertNotNull(result);
        assertEquals(o.getId_od(), result.getId_od());

    }

    @Test
    void testCreateOdontologo() {
        Odontologo d = new Odontologo(1, "1", "1", "1");
        when(repository.saveAndFlush(d)).thenReturn(d);

        assertNotNull(d);
        assertEquals(d.getId_od(), 1);

    }

    @Test
    void testDeleteOdontologo() {
        int id = 1;
        Odontologo o = new Odontologo(id, "1", "1", "1");
        when(repository.findById(id)).thenReturn(Optional.of(o));

        service.deleteOdontologo(id);

        verify(repository).deleteById(id);
    }
}
