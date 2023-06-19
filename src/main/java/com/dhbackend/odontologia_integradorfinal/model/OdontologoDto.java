package com.dhbackend.odontologia_integradorfinal.model;

public class OdontologoDto {

    private int id_od;
    String mat_od;
    String nom_od;
    String ape_od;

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
}
