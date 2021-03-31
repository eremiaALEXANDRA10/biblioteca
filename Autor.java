package biblioteca;


public class Autor extends Persoana{
    protected String genLiterar;

    public Autor(int id, String nume, String prenume, String adresa, int numarTelefon, String genLiterar) {
        super(id, nume, prenume, adresa, numarTelefon);
        this.genLiterar = genLiterar;
    }

    @Override
    public void afisInfo() {
        super.afisInfo();
        System.out.println("Gen literar: " + this.genLiterar + "\n");
    }

    public void setGenLiterar(){
        this.genLiterar = genLiterar;
    }

    public String getGenLiterar(){
        return genLiterar;
    }
}
