package com.company.modele;

import java.util.List;
import java.util.Objects;


public class Autor extends Persoana {
    private String specializareGenLiterar;

    //constructor parametrizat
    public Autor(Long id, String nume, String prenume, String adresa, String numarTelefon, String locDeMunca, String specializareGenLiterar) {
        super(id, nume, prenume, adresa, numarTelefon, locDeMunca);
        this.specializareGenLiterar = specializareGenLiterar;
    }

    //constructor cu un singur parametru
    public Autor(Long id) {
        super(id, "", "","","","");
        this.specializareGenLiterar = "";
    }

    //constructor neparametrizat
    public Autor() {
        //(long)-1 imi initializeaza id-ul cu -1
        super((long) - 1,"","","","","");
        this.specializareGenLiterar = "";
    }

    public String getSpecializareGenLiterar() {
        return specializareGenLiterar;
    }

    public void setSpecializareGenLiterar(String specializareGenLiterar) {
        this.specializareGenLiterar = specializareGenLiterar;
    }

    @Override
    public String toString() {
        return "Autor{" + super.toString() + ", specializare gen literar : " + specializareGenLiterar + '}';
    }

    //Pt CSV
    @Override
    public Id<Long> entitateCSV(String[] entitate) {
        Long id = Long.valueOf(entitate[0]);
        String nume = entitate[1];
        String prenume = entitate[2];
        String adresa = entitate[3];
        String numarTelefon = entitate[4];
        String locDeMunca = entitate[5];
        String specializareGenLiterar = entitate[6];
        return new Autor(id, nume, prenume, adresa, numarTelefon, locDeMunca, specializareGenLiterar);
    }

    @Override
    public String toCSVString() {
        return this.getId() + ", " + this.nume + ", " + this.prenume + ", " + this.adresa + ", " + this.numarTelefon + ", " + this.locDeMunca + ", " + this.specializareGenLiterar;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        if(!super.equals(o)) {
            return false;
        }

        Autor aut = (Autor) o;
        return this.getId().equals(aut.getId());
    }
    /*
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specializareGenLiterar);
    }*/
}
