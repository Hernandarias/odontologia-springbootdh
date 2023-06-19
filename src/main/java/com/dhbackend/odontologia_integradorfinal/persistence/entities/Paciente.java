package com.dhbackend.odontologia_integradorfinal.persistence.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pac;
    private String nom_pac;
    private String ape_pac;
    private String dni_pac;
    @JoinColumn(name = "id_domicilio")
    @ManyToOne
    private Domicilio domicilio;
    private LocalDateTime fecha_ingreso_pac;

    public Paciente() {
    }
    public Paciente(int id_pac, String nom_pac, String ape_pac, String dni_pac, Domicilio domicilio, LocalDateTime fecha_ingreso_pac) {
        this.id_pac = id_pac;
        this.nom_pac = nom_pac;
        this.ape_pac = ape_pac;
        this.dni_pac = dni_pac;
        this.domicilio = domicilio;
        this.fecha_ingreso_pac = fecha_ingreso_pac;
    }

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

    @Override
    public String toString() {
        return "Paciente{" +
                "id_pac=" + id_pac +
                ", nom_pac='" + nom_pac + '\'' +
                ", ape_pac='" + ape_pac + '\'' +
                ", dni_pac='" + dni_pac + '\'' +
                ", domicilio=" + domicilio +
                ", fecha_ingreso_pac=" + fecha_ingreso_pac +
                '}';
    }
}
