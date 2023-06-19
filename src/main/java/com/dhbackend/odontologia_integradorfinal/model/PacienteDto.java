package com.dhbackend.odontologia_integradorfinal.model;

import com.dhbackend.odontologia_integradorfinal.persistence.entities.Domicilio;

import javax.persistence.*;
import java.time.LocalDateTime;

public class PacienteDto {

    private int id_pac;
    String nom_pac;
    String ape_pac;
    String dni_pac;
    Domicilio domicilio;
    LocalDateTime fecha_ingreso_pac;


    public int getId_pac() {
        return id_pac;
    }

    public void setId_pac(int id_pac) {
        this.id_pac = id_pac;
    }

    public String getNom_pac() {
        return nom_pac;
    }

    public void setNom_pac(String nom_pac) {
        this.nom_pac = nom_pac;
    }

    public String getApe_pac() {
        return ape_pac;
    }

    public void setApe_pac(String ape_pac) {
        this.ape_pac = ape_pac;
    }

    public String getDni_pac() {
        return dni_pac;
    }

    public void setDni_pac(String dni_pac) {
        this.dni_pac = dni_pac;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDateTime getFecha_ingreso_pac() {
        return fecha_ingreso_pac;
    }

    public void setFecha_ingreso_pac(LocalDateTime fecha_ingreso_pac) {
        this.fecha_ingreso_pac = fecha_ingreso_pac;
    }
}
