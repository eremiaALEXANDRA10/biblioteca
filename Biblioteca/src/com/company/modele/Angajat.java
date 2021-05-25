package com.company.modele;

import java.util.ArrayList;
import java.util.Objects;
import java.util.SortedSet;

public class Angajat extends Persoana{
    private Double salariu;

    //constructor parametrizat
    public Angajat(Long id, String nume, String prenume, String adresa, String numarTelefon, String locDeMunca, Double salariu) {
        super(id, nume, prenume, adresa, numarTelefon, locDeMunca);
        this.salariu = salariu;
    }

    //constructor cu un singur parametru
    public Angajat(Long id) {
        super(id, "", "","","","");
        this.salariu = 1200.0;
    }

    //constructor neparametrizat
    public Angajat() {
        //(long)-1 imi initializeaza id-ul cu -1
        super((long) - 1,"","","","","");
        this.salariu = 1200.0;
    }

    public Double getSalariu() {
        return salariu;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" + super.toString() + ", salariu : " + salariu + '}';
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
        Double salariu = Double.valueOf(entitate[6]);
        return new Angajat(id, nume, prenume, adresa, numarTelefon, locDeMunca, salariu);
    }

    @Override
    public String toCSVString() {
        return this.getId() + ", " + this.nume + ", " + this.prenume + ", " + this.adresa + ", " + this.numarTelefon + ", " + this.locDeMunca + ", " + this.salariu;
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

        Angajat ang = (Angajat) o;
        return this.getId().equals(ang.getId());
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(salariu);
    }*/
}
