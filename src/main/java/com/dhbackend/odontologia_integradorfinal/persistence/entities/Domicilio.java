package com.dhbackend.odontologia_integradorfinal.persistence.entities;

import javax.persistence.*;

@Entity
@Table
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_domicilio;
    private String calle_domicilio;
    private String nro_puerta_domicilio;
    private String ciudad_domicilio;
    private String provincia_domicilio;

    public Domicilio() {
    }
    public Domicilio(int id_domicilio, String calle_domicilio, String nro_puerta_domicilio, String ciudad_domicilio, String provincia_domicilio) {
        this.id_domicilio = id_domicilio;
        this.calle_domicilio = calle_domicilio;
        this.nro_puerta_domicilio = nro_puerta_domicilio;
        this.ciudad_domicilio = ciudad_domicilio;
        this.provincia_domicilio = provincia_domicilio;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getCalle_domicilio() {
        return calle_domicilio;
    }

    public void setCalle_domicilio(String calle_domicilio) {
        this.calle_domicilio = calle_domicilio;
    }

    public String getNro_puerta_domicilio() {
        return nro_puerta_domicilio;
    }

    public void setNro_puerta_domicilio(String nro_puerta_domicilio) {
        this.nro_puerta_domicilio = nro_puerta_domicilio;
    }

    public String getCiudad_domicilio() {
        return ciudad_domicilio;
    }

    public void setCiudad_domicilio(String ciudad_domicilio) {
        this.ciudad_domicilio = ciudad_domicilio;
    }

    public String getProvincia_domicilio() {
        return provincia_domicilio;
    }

    public void setProvincia_domicilio(String provincia_domicilio) {
        this.provincia_domicilio = provincia_domicilio;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id_domicilio=" + id_domicilio +
                ", calle_domicilio='" + calle_domicilio + '\'' +
                ", nro_puerta_domicilio='" + nro_puerta_domicilio + '\'' +
                ", ciudad_domicilio='" + ciudad_domicilio + '\'' +
                ", provincia_domicilio='" + provincia_domicilio + '\'' +
                '}';
    }
}
