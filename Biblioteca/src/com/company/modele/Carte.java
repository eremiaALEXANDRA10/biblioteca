package com.company.modele;


public class Carte extends Id<Long> {
    private final Long idAutor;
    private final Long idSectiune;
    private final String titlu;
    private final String editura;
    private String descriere;
    private Boolean disponibil;
    private Boolean inAsteptare;

    //constructor parametrizat
    public Carte(Long id, Long autor, Long sectiune, String titlu, String editura, String descriere, Boolean disponibil, Boolean inAsteptare) {
        this.disponibil = disponibil;
        this.inAsteptare = inAsteptare;
        this.setId(id);
        this.idAutor = autor;
        this.idSectiune = sectiune;
        this.titlu = titlu;
        this.editura = editura;
        this.descriere = descriere;
    }

    public Carte(Long id, Long autor, Long sectiune, String titlu, String editura, String descriere) {
        this.disponibil = true;
        this.inAsteptare = false;
        this.setId(id);
        this.idAutor = autor;
        this.idSectiune = sectiune;
        this.titlu = titlu;
        this.editura = editura;
        this.descriere = descriere;
    }

    //constructor neparametrizat
    public Carte() {
        this.setId((long) - 1);
        this.idAutor = (long) - 1;
        this.idSectiune = (long) - 1;
        this.titlu = "";
        this.editura = "";
        this.descriere = "";
        this.inAsteptare = false;
        this.disponibil = true;
    }

    public Carte(Long id) {
        this.setId(id);
        this.idAutor = (long) - 1;
        this.idSectiune = (long) - 1;
        this.titlu = "";
        this.editura = "";
        this.descriere = "";
        this.inAsteptare = false;
        this.disponibil = true;
    }

    public Boolean getDisponibil(){
        return this.disponibil;
    }
    public void setDisponibil(Boolean disponibil){
        this.disponibil = disponibil;
    }
    public Boolean getInAsteptare(){
        return this.inAsteptare;
    }
    public void setinAsteptare(Boolean inAsteptare){
        this.inAsteptare = inAsteptare;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdSectiune() {
        return idSectiune;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getEditura() {
        return editura;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Carte{" + super.toString() +
                ", autor : " + idAutor +
                ", sectiune : " + idSectiune +
                ", titlu : " + titlu +
                ", editura : " + editura +
                ", descriere : " + descriere +
                ", disponibil : " + disponibil +
                ", inAsteptare : " + inAsteptare + '}';
    }

    //Pt CSV
    @Override
    public Id<Long> entitateCSV(String[] entitate) {
        Long id = Long.valueOf(entitate[0]);
        Long autor = Long.valueOf(entitate[1]);
        Long sectiune = Long.valueOf(entitate[2]);
        String titlu = entitate[3];
        String editura = entitate[4];
        String descriere = entitate[5];
        Boolean disponibil = Boolean.parseBoolean(entitate[6]);
        Boolean inAsteptare = Boolean.parseBoolean(entitate[7]);
        return new Carte(id, autor, sectiune, titlu, editura, descriere, disponibil, inAsteptare);
    }

    @Override
    public String toCSVString() {
        return this.getId() + ","
                + this.idAutor + ","
                + this.idSectiune + ","
                + this.titlu + ","
                + this.editura + ","
                + this.descriere + ","
                + this.disponibil + ","
                + this.inAsteptare;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Carte carte = (Carte) o;
        return this.getId().equals(carte.getId());
    }
}
