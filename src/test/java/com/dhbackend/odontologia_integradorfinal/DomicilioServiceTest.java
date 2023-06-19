package com.dhbackend.odontologia_integradorfinal;

import com.dhbackend.odontologia_integradorfinal.mapper.DomicilioMapper;
import com.dhbackend.odontologia_integradorfinal.model.DomicilioDto;
import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;
import com.dhbackend.odontologia_integradorfinal.persistence.repository.DomicilioRepository;
import com.dhbackend.odontologia_integradorfinal.service.DomicilioService;


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


class DomicilioServiceTest {
    @Mock
    private DomicilioRepository repository;

    @InjectMocks
    private DomicilioService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Domicilio> domicilios = Arrays.asList(
                new Domicilio(1, "1", "1", "1", "1"),
                new Domicilio(2, "1", "2", "2", "2")
        );
        when(repository.findAll()).thenReturn(domicilios);

        List<DomicilioDto> result = service.findAll();

        assertEquals(2, result.size());

    }

    @Test
    void testGetDomicilioById() {
        int id = 1;
        Domicilio domicilio = new Domicilio(id, "1", "1", "1", "1");
        when(repository.findById(id)).thenReturn(Optional.of(domicilio));

        DomicilioDto result = service.getDomicilioById(id);

        assertNotNull(result);
        assertEquals(domicilio.getId_domicilio(), result.getId_domicilio());

    }

    @Test
    void testCreateDomicilio() {
        Domicilio d = new Domicilio(1, "1", "1", "1", "1");
        when(repository.saveAndFlush(d)).thenReturn(d);

        assertNotNull(d);
        assertEquals(d.getId_domicilio(), 1);

    }

    @Test
    void testDeleteDomicilio() {
        int id = 1;
        Domicilio domicilio = new Domicilio(id, "1", "1", "1", "1");
        when(repository.findById(id)).thenReturn(Optional.of(domicilio));

        service.deleteDomicilio(id);

        verify(repository).deleteById(id);
    }


}
