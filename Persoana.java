package biblioteca;

public abstract class Persoana {
    protected int id;
    protected String nume;
    protected String prenume;
    protected String adresa;
    protected int numarTelefon;

    static int idCurent = 0; // id-ul va fi incrementat pentru fiecare persoana creata si astfel fiecare dintre acestea va avea un id unic

    public Persoana(int id, String nume, String prenume, String adresa, int numarTelefon) {
        idCurent++;
        if(id<=0)
            id = idCurent;

        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;

    }

    public void afisInfo(){
        System.out.println("Informatii: ");
        System.out.println("Id: " + this.id);
        System.out.println("Nume: " + this.nume);
        System.out.println("Prenume: " + this.prenume);
        System.out.println("Adresa: " + this.adresa);
        System.out.println("Numar telefon: " + this.numarTelefon);

    }

    public void setNume(String nume){
        this.nume = nume;
    }

    public String getNume(){
        return this.nume;
    }

    public void setPrenume(String prenume){
        this.prenume = prenume;
    }

    public String getPrenume(){
        return this.prenume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa(){
        return this.adresa;
    }

    public void setNumarTelefon(int numarTelefon){
        this.numarTelefon = numarTelefon;
    }

    public int getNumarTelefon(){
        return this.numarTelefon;
    }

    public int getId(){
        return this.id;
    }
}

