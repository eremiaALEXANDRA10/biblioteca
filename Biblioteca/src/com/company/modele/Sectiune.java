package com.company.modele;

public class Sectiune extends Id<Long>{
    private String nume;
    private final Long idEtaj;

    //constructor parametrizat
    public Sectiune(Long id, String nume, Long idEtaj) {
        this.idEtaj = idEtaj;
        this.setId(id);
        this.nume = nume;
    }

    //constructor neparametrizat
    public Sectiune() {
        this.setId((long)-1);
        this.nume = "";
        this.idEtaj = (long) -1;
    }
    public Sectiune(Long id) {
        this.setId(id);
        this.nume = "";
        this.idEtaj = (long) -1;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Long getIdEtaj() {
        return idEtaj;
    }

    @Override
    public Id<Long> entitateCSV(String[] entitate) {
        Long id = Long.valueOf(entitate[0]);
        String nume = entitate[1];
        Long idEtaj = Long.valueOf(entitate[2]);
        return new Sectiune(id, nume, idEtaj);
    }

    @Override
    public String toString() {
        return "Sectiune{"
                + super.toString() +
                ", nume='" + nume + '\'' +
                ", idEtaj=" + idEtaj +
                '}';
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," + this.nume + "," + this.getIdEtaj();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Sectiune sec = (Sectiune) o;
        return this.getId().equals(sec.getId());
    }
}
