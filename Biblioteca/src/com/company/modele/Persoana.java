package com.company.modele;

public abstract class Persoana extends Id<Long> {
    protected String nume;
    protected String prenume;
    protected String adresa;
    protected String numarTelefon;
    protected String locDeMunca;

    public Persoana(Long id, String nume, String prenume, String adresa, String numarTelefon, String locDeMunca) {
        this.setId(id);
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
        this.locDeMunca = locDeMunca;
    }

    public String getNume() {

        return nume;
    }

    public void setNume(String nume) {

        this.nume = nume;
    }

    public String getPrenume() {

        return prenume;
    }

    public void setPrenume(String prenume) {

        this.prenume = prenume;
    }

    public String getAdresa() {

        return adresa;
    }

    public void setAdresa(String adresa) {

        this.adresa = adresa;
    }

    public String getNumarTelefon() {

        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {

        this.numarTelefon = numarTelefon;
    }

    public String getLocDeMunca() {

        return locDeMunca;
    }

    public void setLocDeMunca(String locDeMunca) {

        this.locDeMunca = locDeMunca;
    }

    @Override
    public String toString() {
        return '{' + super.toString() + ", nume : " + nume + ", prenume : " + prenume + ", adresa : " + adresa + ", telefon : " + numarTelefon + ", loc de munca : " + locDeMunca + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Persoana pers = (Persoana) o;
        return this.getId().equals(pers.getId());
    }
}
