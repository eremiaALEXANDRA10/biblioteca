package com.company.modele;

import java.util.Objects;

public class Cerere extends Id<Long>{
    private final Long idCititor;
    private final Long idCarte;
    private final String operatie;

    public Long getIdCititor() {
        return idCititor;
    }

    public Long getIdCarte() {
        return idCarte;
    }

    public String getOperatie() {
        return operatie;
    }

    public Cerere(Long id, Long idCititor, Long idCarte, String operatie) {
        setId(id);
        this.idCititor = idCititor;
        this.idCarte = idCarte;
        this.operatie = operatie;
    }
    public Cerere() {
        this.setId((long) -1);
        this.idCititor = (long) -1;
        this.idCarte = (long) -1;
        this.operatie = "";
    }
    public Cerere(Long id) {
        this.setId(id);
        this.idCititor = (long) -1;
        this.idCarte = (long) -1;
        this.operatie = "";
    }

    @Override
    public String toString() {
        return "Cerere{" +
                "id=" + this.getId() +
                ", idCititor=" + idCititor +
                ", idCarte=" + idCarte +
                ", operatie='" + operatie + '\'' +
                '}';
    }

    @Override
    public Id<Long> entitateCSV(String[] entitate) {
        Long id = Long.valueOf(entitate[0]);
        Long cititor = Long.valueOf(entitate[1]);
        Long carte = Long.valueOf(entitate[2]);
        String operatie = entitate[3];
        return new Cerere(id, cititor, carte, operatie);
    }

    @Override
    public String toCSVString() {
        return this.getId() + "," + this.idCititor + "," + this.idCarte + "," + this.operatie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cerere cerere = (Cerere) o;
        return Objects.equals(getId(), cerere.getId());
    }
}
