package com.company.modele;

public class Cititor extends Persoana {
    private Integer varsta;

    //constructor parametrizat
    public Cititor(Long id, String nume, String prenume, String adresa, String numarTelefon,
                   String locDeMunca, Integer varsta) {
        super(id, nume, prenume, adresa, numarTelefon, locDeMunca);
        this.varsta = varsta;
    }

    //constructor cu un singur parametru
    public Cititor(Long id) {
        super(id, "", "", "", "", "");
        this.varsta = 14;
    }

    //constructor neparametrizat
    public Cititor() {
        //(long)-1 imi initializeaza id-ul cu -1
        super((long) -1, "", "", "", "", "");
        this.varsta = 14;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Cititor{" +
                super.toString() +
                ", varsta : " + varsta +
                '}';
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
        Integer varsta = Integer.valueOf(entitate[6]);
        return new Cititor(id, nume, prenume, adresa, numarTelefon, locDeMunca, varsta);
    }

    @Override
    public String toCSVString() {
        return this.getId() + ", " + this.nume + ", " + this.prenume + ", "
                + this.adresa + ", " + this.numarTelefon + ", " + this.locDeMunca
                + ", " + this.varsta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Cititor cit = (Cititor) o;
        return this.getId().equals(cit.getId());
    }
}
