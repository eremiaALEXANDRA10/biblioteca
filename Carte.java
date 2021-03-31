package biblioteca;

import java.util.Arrays;
import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Carte {
    private int id;
    private String titlu;
    private String editura;
    private Autor[] autors; //agregare -> has-a
    private boolean esteImprumutata; //daca este imprumutata =>true, altfel =>false
    private ArrayList<CerereInAsteptare> cerereInAsteptares; //lista tuturor cererilor in asteptare pt imprumutarea unei carti

    static private int idCarte = 0; // id-ul va fi incrementat pentru fiecare carte creata si astfel fiecare dintre acestea va avea un id unic

    public Carte(int id, String titlu, String editura, Autor[] autors, boolean esteImprumutata) {
        idCarte++;
        if(id<=0) {
            this.id = idCarte;
        }
        else
            this.id = id;

        this.titlu = titlu;
        this.editura = editura;
        this.autors = autors;
        this.esteImprumutata = esteImprumutata;
        cerereInAsteptares = new ArrayList();
    }

    public int getId() {
        return id;
    }
    public String getTitlu() {
        return titlu;
    }
    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getEditura() {
        return editura;
    }
    public void setEditura(String editura) {
        this.editura = editura;
    }

    public Autor[] getAutors() {
        return autors;
    }
    public void setAutors(Autor[] autors) {
        this.autors = autors;
    }

    public boolean getStadiuImprumut() {
        return esteImprumutata;
    }
    public void setStadiuImprumut(boolean stadiuImprumut) {
        this.esteImprumutata = stadiuImprumut;
    }

    public ArrayList<CerereInAsteptare> getCerereInAsteptares() {
        return cerereInAsteptares;
    }

    public static void setIdCarte(int idC) {
        idCarte = idC;
    }

    //Adaugarea unei cereri pt imprumutul unei carti
    public void adaugareCerereAst(CerereInAsteptare cerereAst) {
        cerereInAsteptares.add(cerereAst);
    }

    //Eliminarea unei cereri pt imprumutul unei carti
    public void eliminareCerereAst() {
        if(!cerereInAsteptares.isEmpty()) {
            cerereInAsteptares.remove(0); //cererile se solutioneaza de la cea mai indepartata la cea mai recenta
        }
    }

    //Afisarea tuturor cererilor de asteptare pentru o carte
    public void afisCereriAsteptare() {
        if(!cerereInAsteptares.isEmpty()) {
            System.out.println("\n Cererile in asteptare sunt: ");
            System.out.println("Nr. crt. \t\t\t Titlul cartii \t\t\t Nume cititor \t\t\t Data cererii");
            for(int i = 0; i < cerereInAsteptares.size(); i++) {
                System.out.print(i + ". " + "\t\t\t");
                cerereInAsteptares.get(i).afis();
            }
        }
        else System.out.println("Nu exista cereri in asteptare.");
    }

    //Afisare informatii despre carte
    public String afisInfo() {
        return "Id carte: " + id + '\'' +"\t\tTitlu: " + titlu + '\'' + ", editura: " + editura + '\'' + ", autor: " + Arrays.toString(autors) + '\'' + ", status imprumut: " + esteImprumutata;
    }

    //Actualizarea informatiilor despre o carte
    public void actualizareInfoCarte() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String alegere;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nDoriti sa actualizati titlul? (Da/Nu)");
        alegere = scanner.next();

        if (alegere.equals("Da")) {
            System.out.println("\nIntroduceti noul titlu: ");
            titlu = reader.readLine();
        }

        System.out.println("\nDoriti sa actualizati editura? (Da/Nu)");
        alegere = scanner.next();

        if (alegere.equals("Da")) {
            System.out.println("\nIntroduceti editura: ");
            editura = reader.readLine();
        }

        /* imi da eroare la autor
        System.out.println("\nDoriti sa actualizati autorul? (Da/Nu)");
        alegere = scanner.next();

        if (alegere.equals("Da")) {
            System.out.println("\nIntroduceti noul autor: ");
            setAutors(reader.readLine());
        }*/

        System.out.println("\nDoriti sa actualizati statusul? (Da/Nu)");
        alegere = scanner.next();

        if (alegere.equals("Da")) {
            System.out.println("\nIntroduceti noul status: ");
            esteImprumutata = scanner.nextBoolean();
        }

    }

    //Adaugarea unei carti pe lista de dorinte(in asteptare)
    public void adaugareCarteDorinte(Cititor cititor) {
        CerereInAsteptare cerereInAsteptare = new CerereInAsteptare(cititor, this, new Date());
        adaugareCerereAst(cerereInAsteptare); //Se adauga solicitarea in coada tuturor solicitarilor pentru cartea dorita
        cititor.adaugareCarteDorita(cerereInAsteptare); //Se adauga dorinta si pentru cititor
        System.out.println("\n Cererea pentru cartea " + titlu + "a fost inregistrata cu succes de catre " + cititor.getNume() + ".\n");
    }

    //Solicitare pentru o carte in asteptare
    public void cerereCarte(Cititor cititor) {
        boolean statusCerere = true;

        //In cazul in care cititorul a imprumutat deja cartea in cauza, atunci acesta nu mai poate depunde cerere pentru aceeasi carte. Va trebui sa prelungeasca termenul de returnare pe care il are.
        for(int i = 0; i < cititor.getCartiImprumutate().size(); i++) {
            if(cititor.getCartiImprumutate().get(i).getCarte() == this) {
                System.out.println("\n Ai imprumutat deja cartea " + titlu);
                return;
            }
        }

        //In cazul in care cititorul a depus deja cerere pentru cartea in cauza, atunci nu mai poate depunde alta
        for(int i = 0; i < cerereInAsteptares.size(); i++) {
            if(cerereInAsteptares.get(i).getCititor() == cititor) {
                statusCerere = false;
                break;
            }
        }

        if(statusCerere) {
            adaugareCarteDorinte(cititor);
        }
        else System.out.println("Ai depus deja o cerere pentru aceasta carte.");

    }

    //Returnearea unei carti
    public void returnareCarte(Cititor cititor, Imprumut imprumut, Angajat angajat) {
        imprumut.getCarte().setStadiuImprumut(false);
        imprumut.setDataFinal(new Date());
        cititor.eliminareCarteImprumutata(imprumut);
        System.out.println("Cartea cu titlul" + imprumut.getCarte().getTitlu() + "a fost returnata de catre cititorul " + cititor.getNume() + "." );
    }
}
