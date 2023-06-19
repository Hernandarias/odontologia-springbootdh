package com.dhbackend.odontologia_integradorfinal.persistence.entities;

import javax.persistence.*;

@Entity
@Table
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_od;
    private String mat_od;
    private String nom_od;
    private String ape_od;

    public Odontologo() {
    }
    public Odontologo(int id_od, String mat_od, String nom_od, String ape_od) {
        this.id_od = id_od;
        this.mat_od = mat_od;
        this.nom_od = nom_od;
        this.ape_od = ape_od;
    }

    public int getId_od() {
        return id_od;
    }

    public void setId_od(int id_od) {
        this.id_od = id_od;
    }

    public String getMat_od() {
        return mat_od;
    }

    public void setMat_od(String mat_od) {
        this.mat_od = mat_od;
    }

    public String getNom_od() {
        return nom_od;
    }

    public void setNom_od(String nom_od) {
        this.nom_od = nom_od;
    }

    public String getApe_od() {
        return ape_od;
    }

    public void setApe_od(String ape_od) {
        this.ape_od = ape_od;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id_od=" + id_od +
                ", mat_od='" + mat_od + '\'' +
                ", nom_od='" + nom_od + '\'' +
                ", ape_od='" + ape_od + '\'' +
                '}';
    }
}
