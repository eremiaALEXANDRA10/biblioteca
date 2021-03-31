package biblioteca;

import java.util.Date;

public class Imprumut {
    private Cititor cititor;
    private Carte carte;
    private Date dataInceput;
    private Date dataFinal;

    public Imprumut(Cititor cititor, Carte carte, Date dataInc, Date dataFin) {
        this.cititor = cititor;
        this.carte = carte;
        this.dataInceput = dataInc;
        this.dataFinal = dataFin;
    }

    public Cititor getCititor() {
        return cititor;
    }
    public Carte getCarte() {
        return carte;
    }

    public Date getDataInceput() {
        return dataInceput;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void reinnoireImprumut(Date dataInceput) {
        this.dataInceput = dataInceput;
        System.out.println("\n Data pentru returnarea cartii" + getCarte().getTitlu() + "a fost modificata.");
    }
}
