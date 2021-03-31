package biblioteca;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Date;

public class CerereInAsteptare {
    Cititor cititor;
    Carte carte;
    Date solicitareData;

    public CerereInAsteptare(Cititor cititor, Carte carte, Date solicitareData) {
        this.cititor = cititor;
        this.carte = carte;
        this.solicitareData = solicitareData;
    }

    public Cititor getCititor() {
        return cititor;
    }

    public Carte getCarte() {
        return carte;
    }

    public Date getSolicitareData() {
        return solicitareData;
    }

    //Afisare informatii ale cererii in asteptare pt imprumutarea unei carti
    public void afis() {
        System.out.println(carte.getTitlu() + "\t\t\t" + cititor.getNume() + "\t\t\t" + solicitareData + "\n");
    }
}
