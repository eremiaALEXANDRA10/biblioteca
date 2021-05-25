package com.company.modele;

import java.util.Objects;


public class Etaj extends Id<Long> {
    private String nume; //de ex "A-I"/"Î-R"/"S-Z" (am scris in agenda la pct 13)

    //constructor parametrizat
    public Etaj(Long id, String nume) {
        this.setId(id);
        this.nume = nume;
    }

    //constructor neparametrizat
    public Etaj() {
        this.setId((long) -1);
        this.nume = "";
    }
    public Etaj(Long id) {
        this.setId(id);
        this.nume = "";
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Etaj{" + super.toString() + ", nume : " + nume + '}';
    }

    //Pt CSV
    @Override
    public Id<Long> entitateCSV(String[] entitate) {
        Long id = Long.valueOf(entitate[0]);
        String nume = entitate[1];
        return new Etaj(id, nume);
    }

    @Override
    public String toCSVString() {
        return this.getId() + ", " + this.nume;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Etaj et = (Etaj) o;
        return this.getId().equals(et.getId());
    }

}
