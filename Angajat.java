package biblioteca;

public class Angajat extends Persoana{
    protected double salariu;

    public Angajat(int id, String nume, String prenume, String adresa, int numarTelefon, double salariu) {
        super(id, nume, prenume, adresa, numarTelefon);
        this.salariu = salariu;
    }

    //Informatii despre angajat
    @Override
    public void afisInfo() {
        super.afisInfo();
        System.out.println("Salariu: " + this.salariu + "\n");
    }

    public void setSalariu(){
        this.salariu = salariu;
    }

    public double getSalariu(){
        return salariu;
    }

}
