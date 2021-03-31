package biblioteca;

import java.io.*; //pt throws IOException, BufferedReader etc.(pt citire)
import java.util.*; //pt scanner

public class Cititor extends Persoana {
    private ArrayList<Imprumut> cartiImprumutate; //cartile care sunt deja imprumutate de catre cititor
    private ArrayList<CerereInAsteptare> cartiInAsteptare; //cartile pe care cititorul doreste sa le imprumute si pt care asteapta sa ii fie acceptata cererea

    public Cititor(int id, String nume, String prenume, String adresa, int numarTelefon) {
        super(id, nume, prenume, adresa, numarTelefon);

        cartiImprumutate = new ArrayList();
        cartiInAsteptare = new ArrayList();
    }

    public ArrayList<Imprumut> getCartiImprumutate() {
        return cartiImprumutate;
    }

    public ArrayList<CerereInAsteptare> getCartiInAsteptare() {
        return cartiInAsteptare;
    }

    //Informatii despre cititor
    @Override
    public void afisInfo() {
        super.afisInfo();
        afisCartiImprumutate();
        afisCartiInAsteptare();
    }

    //Afisarea informatiilor despre cartile imprumutate de catre cititor
    public void afisCartiImprumutate() {
        if(!cartiImprumutate.isEmpty()) //daca vectorul de imprumutate nu e gol
        {
            System.out.println("Lista cartilor imprumutate: ");
            System.out.println("Nr. crt. \t\t\tTitlu\t\t\tAutor\t\t\tEditura\t\t\tSectiune");
            for(int i = 0; i < cartiImprumutate.size(); i++) {
                System.out.print(i + ". " + "\t\t\t");//folosesc System.out.print ca sa afisez pe aceeasi linie, nu pe linii diferite ca la System.out.println
                cartiImprumutate.get(i).getCarte().afisInfo();
                System.out.print("\n");
            }
        }
        else
            System.out.println("Nu exista carti imprumutate.");
    }

    //Afisarea informatiilor despre cartile pe care cititorul isi doreste sa le imprumute.
    public void afisCartiInAsteptare() {
        if(!cartiInAsteptare.isEmpty()) //daca vectorul de carti in asteptare nu e gol
        {
            System.out.println("Lista cartilor in asteptare: ");
            System.out.println("Nr. crt. \t\t\tTitlu\t\t\tAutor\t\t\tEditura\t\t\tSectiune");
            for(int i = 0; i < cartiInAsteptare.size(); i++) {
                System.out.print(i + ". " + "\t\t\t");//folosesc System.out.print ca sa afisez pe aceeasi linie, nu pe linii diferite ca la System.out.println
                cartiInAsteptare.get(i).getCarte().afisInfo();
                System.out.print("\n");
            }
        }
        else
            System.out.println("Nu exista carti in asteptare.");
    }

    //Actualizare informatii despre cititor
    public void actualizareInfoCititor() throws IOException {
        String alegere;
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n Doriti sa actualizati numele" + getNume() + "? (Da/Nu");
        alegere = sc.next();
        if(alegere.equals("Da")) {
            System.out.println("Noul nume este: ");
            setNume(reader.readLine());
            System.out.println("\n Numele a fost actualizat cu succes.");
        }

        System.out.println("\n Doriti sa actualizati prenumele" + getPrenume() + "? (Da/Nu");
        alegere = sc.next();
        if(alegere.equals("Da")) {
            System.out.println("Noul prenume este: ");
            setPrenume(reader.readLine());
            System.out.println("\n Prenumele a fost actualizat cu succes.");
        }

        System.out.println("\n Doriti sa actualizati adresa" + getAdresa() + "? (Da/Nu");
        alegere = sc.next();
        if(alegere.equals("Da")) {
            System.out.println("Noua adresa este: ");
            setAdresa(reader.readLine());
            System.out.println("\n Adresa a fost actualizata cu succes.");
        }

        System.out.println("\n Doriti sa actualizati numarul de telefon" + getNumarTelefon() + "? (Da/Nu");
        alegere = sc.next();
        if(alegere.equals("Da")) {
            System.out.println("Noul numar de telefon este: ");
            setNumarTelefon(sc.nextInt());
            System.out.println("\n Numarul de telefon a fost actualizat cu succes.");
        }

        System.out.println("\n Datele cititorului au fost actualizate cu succes!");
    }

    //Adaugarea unei carti in lista de imprumutate
    public void adaugareCarteImprumutata(Imprumut carteImpr) {
        cartiImprumutate.add(carteImpr);
    }
    //Eliminarea unei carti din lista de imprumutate
    public void eliminareCarteImprumutata(Imprumut carteImpr) {
        cartiImprumutate.remove(carteImpr);
    }

    //Adaugarea unei carti in lista de dorinte(carti care urmeaza sa fie imprumutate)
    public void adaugareCarteDorita(CerereInAsteptare cerereAst) {
        cartiInAsteptare.add(cerereAst);
    }
    //Eliminarea unei carti din lista de dorinte(carti care urmeaza sa fie imprumutate)
    public void eliminareCarteDorita(CerereInAsteptare cerereAst) {
        cartiInAsteptare.remove(cerereAst);
    }
}
