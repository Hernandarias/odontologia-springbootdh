package com.dhbackend.odontologia_integradorfinal.persistence.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turno;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pac", nullable = false)
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_od", nullable = false)
    private Odontologo odontologo;
    @Column(nullable = false)
    private LocalDateTime fecha_hora;

    public Turno() {
    }
    public Turno(int id_turno, Paciente paciente, Odontologo odontologo, LocalDateTime fecha_hora) {
        this.id_turno = id_turno;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha_hora = fecha_hora;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id_turno=" + id_turno +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha_hora=" + fecha_hora +
                '}';
    }
}
