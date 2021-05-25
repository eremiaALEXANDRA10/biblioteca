package com.company.UI;

import com.company.Controller.*;
import com.company.DTOs.CerereCarteCititorDTO;
import com.company.DTOs.SectiuneDTO;
import com.company.modele.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UI {
    // todo: adauga toate controllerele : done
    //todo: scrie si restul controlllerelor

    private final AngajatController angajatController;
    private final AutorController autorController;
    private final CarteController carteController;
    private final CititorController cititorController;
    private final CerereController cerereController;
    private final EtajController etajController;
    private final SectiuneController sectiuneController;
    private final CerereCarteCititorDTO cerereDTO;
    private final SectiuneDTO sectiuneDTO;


    public UI(AngajatController angajatController, AutorController autorController,
              CarteController carteController, CititorController cititorController, CerereController cerereController, EtajController etajController, SectiuneController sectiuneController, SectiuneDTO sectiuneDTO) {
        this.angajatController = angajatController;
        this.autorController = autorController;
        this.carteController = carteController;
        this.cititorController = cititorController;
        this.cerereController = cerereController;
        this.etajController = etajController;
        this.sectiuneController = sectiuneController;
        this.sectiuneDTO = sectiuneDTO;
        this.cerereDTO = new CerereCarteCititorDTO(cititorController, carteController, cerereController);
    }

    public UI() {
        this.angajatController = new AngajatController();
        this.autorController = new AutorController();
        this.carteController = new CarteController();
        this.cititorController = new CititorController();
        this.cerereController = new CerereController();
        this.etajController = new EtajController();
        this.sectiuneController = new SectiuneController();
        this.cerereDTO = new CerereCarteCititorDTO(cititorController, carteController, cerereController);
        this.sectiuneDTO = new SectiuneDTO(sectiuneController, etajController);
    }

    private void printMenu() {
        System.out.println("Bun venit! Optiunile meniului sunt: ");
        System.out.println("1. Adauga un angajat nou");
        System.out.println("2. Actualizeaza datele unui angajat");
        System.out.println("3. Sterge un angajat existent");
        System.out.println("4. Listeaza angajatii");

        System.out.println("5. Adauga un autor nou");
        System.out.println("6. Actualizeaza datele unui autor");
        System.out.println("7. Sterge un autor existent");
        System.out.println("8. Listeaza autorii");

        System.out.println("9. Adauga o carte noua");
        System.out.println("10. Actualizeaza datele unei carti");
        System.out.println("11. Sterge o carte existenta");
        System.out.println("12. Listeaza cartile");

        System.out.println("13. Adauga o cerere noua");
        System.out.println("14. Listeaza cererile");

        System.out.println("15. Adauga un cititor nou");
        System.out.println("16. Actualizeaza datele unui cititor");
        System.out.println("17. Listeaza cititorii");

        System.out.println("18. Adauga un etaj nou");
        System.out.println("19. Actualizeaza datele unui etaj");
        System.out.println("20. Sterge un etaj existent");
        System.out.println("21. Listeaza etajele");

        System.out.println("22. Adauga o sectiune noua");
        System.out.println("23. Actualizeaza datele unei sectiuni");
        System.out.println("24. Sterge o sectiune existenta");
        System.out.println("25. Listeaza sectiunile");

        System.out.println("26. Listeaza toate cartile imprumutate vreodata de un cititor");
        System.out.println("27. Listeaza cartile nereturnate de un cititor");
        System.out.println("28. Listeaza cartile rezervate de un cititor");
        System.out.println("29. Listeaza toti cititorii care au imprumutat vreodata o anumita carte");
        System.out.println("30. Listeaza toate cartile imprumutate vreodata");
        System.out.println("31. Listeaza toate cartile rezervate vreodata");
        System.out.println("32. Listeaza toate cartile nereturnate acum");
        System.out.println("33. Listeaza toate cartile rezervate acum");
        System.out.println("0. Iesire din meniu");
    }

    private Integer getValidCommand(Scanner keyboard) {
        int command = 0;
        List<Integer> arr = IntStream.range(0, 34).boxed().collect(Collectors.toList());

        do {
            System.out.println("Alege o optiune valida: ");
            try {
                command = Integer.parseInt(keyboard.next());
            }
            catch (RuntimeException e) {
                System.out.println("Eroare:" + e.getMessage());
            }
        }
        while (!arr.contains(command));
        return command;
    }

    private Long readLong(String parameter) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(parameter + ": ");
            return Long.valueOf(bufferedReader.readLine());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void runConsole() {
        Scanner keyboard = new Scanner(System.in);
        int running = 1;
        while (running == 1) {
            printMenu();
            var command = getValidCommand(keyboard);
            switch (command) {
                case 1 -> addAngajat();
                case 2 -> updateAngajat();
                case 3 -> deleteAngajat();
                case 4 -> listAngajati();

                //todo restul CRUD operations

                case 5 -> addAutor();
                case 6 -> updateAutor();
                case 7 -> deleteAutor();
                case 8 -> listAutori();

                case 9 -> addCarte();
                case 10 -> updateCarte();
                case 11 -> deleteCarte();
                case 12 -> listCarti();

                case 13 -> addCerere();
                case 14 -> listCereri();

                case 15 -> addCititor();
                case 16 -> updateCititor();
                case 17 -> listCititori();

                case 18 -> addEtaj();
                case 19 -> updateEtaj();
                case 20 -> deleteEtaj();
                case 21 -> listEtaje();

                case 22 -> addSectiune();
                case 23 -> updateSectiune();
                case 24 -> deleteSectiune();
                case 25 -> listSectiuni();

                case 26 -> filterCartiImprumutateVreodataCititor();
                case 27 -> filterCartiNereturnateCititor();
                case 28 -> filterCartiRezervateCititor();
                case 29 -> filterCititoriImprumutVreodata();
                case 30 -> filterCartiImprumutateVreodata();
                case 31 -> filterCartiRezervateVreodata();
                case 32 -> filterCartiNereturnateAcum();
                case 33 -> filterCartiRezervateAcum();

                default -> running = 0;
            }
        }
    }


    private void filterCartiImprumutateVreodataCititor() {
        Long id = readLong("idCititor");
        if (id != null) {
            var cereri = this.cerereDTO.toateCartileImprumutateCititorIstorie(id);
            System.out.println(
                    cereri.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n")));
        }
        else
            System.out.println("Id invalid");

    }

    private void filterCartiNereturnateCititor() {
        Long id = readLong("idCititor");
        if (id != null) {
            System.out.println(
                    this.cerereDTO.toateCartileNereturnateCititor(id).stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n")));
        }
        else
            System.out.println("Id invalid");
    }

    private void filterCartiRezervateCititor() {
        Long id = readLong("idCititor");
        if (id != null) {
            System.out.println(
                    this.cerereDTO.toateCartileRezervateCititor(id).stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n")));
        }
        else
            System.out.println("Id invalid");

    }

    private void filterCititoriImprumutVreodata() {
        Long id = readLong("idCarte");
        if (id != null) {
            System.out.println(
                    this.cerereDTO.totiCititoriiImprumutCarte(id).stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n")));
        }
        else
            System.out.println("Id invalid");

    }

    private void filterCartiImprumutateVreodata() {
        System.out.println(
                this.cerereDTO.toateCartileImprumutateIstorie().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));

    }

    private void filterCartiRezervateVreodata() {
        System.out.println(
                this.cerereDTO.toateCartileRezervateIstorie().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    private void filterCartiNereturnateAcum() {
        System.out.println(
                this.cerereDTO.toateCartileNereturnate().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    private void filterCartiRezervateAcum() {
        System.out.println(
                this.cerereDTO.toateCartileRezervate().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    //Cerere

    private Cerere readCerere() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("idCititor: ");
            Long idCititor = Long.valueOf(bufferedReader.readLine());
            System.out.println("idCarte: ");
            Long idCarte = Long.valueOf(bufferedReader.readLine());
            System.out.println("Operatie (0 - Imprumutare, 1 - Restituire, 2 - Rezervare, 3 - Renuntare)\n: ");
            long operatie = Long.parseLong(bufferedReader.readLine());

            String[] optiuni = {"Imprumutare", "Restituire", "Rezervare", "Renuntare"};


            return new Cerere(id, idCititor, idCarte, optiuni[Math.toIntExact(operatie)]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void addCerere() {
        var cerere = readCerere();
        if (cerere != null) {
            var bool = cerereDTO.addCerere(cerere);
            if (bool) {
                System.out.println("Cerere adaugata");
            }
            else System.out.println("Cererea nu a putut fi adaugata");
        }
    }

    private void listCereri() {
        System.out.println(
                cerereController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }


    private Angajat readAngajat() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Nume: ");
            String nume = bufferedReader.readLine();
            System.out.println("Prenume: ");
            String prenume = bufferedReader.readLine();
            System.out.println("Adresa: ");
            String adresa = bufferedReader.readLine();
            System.out.println("Numar de telefon: ");
            String telefon = bufferedReader.readLine();
            System.out.println("Loc de munca: ");
            String job = bufferedReader.readLine();
            System.out.println("Salariu: ");
            Double salariu = Double.valueOf(bufferedReader.readLine());

            return new Angajat(id, nume, prenume, adresa, telefon, job, salariu);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    //Angajat
    private void addAngajat() {
        var angajat = readAngajat();
        if (angajat != null) {
            var bool = angajatController.add(angajat);
            if (bool)
                System.out.println("Angajat adaugat");
            else System.out.println("Angajatul nu a putut fi adaugat");
        }
    }

    private void updateAngajat() {
        var angajat = readAngajat();
        if (angajat != null) {
            if (angajatController.update(angajat))
                System.out.println("Angajat actualizat");
            else System.out.println("Angajatul nu a putut fi actualizat");
        }
    }

    private void deleteAngajat() {
        Long id = readLong("id");
        if (id != null) {
            this.angajatController.remove(new Angajat(id));
            System.out.println("Angajat sters");
        }
        else
            System.out.println("Angajatul nu poate fi sters");
    }

    private void listAngajati() {
        System.out.println(
                angajatController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    ////////////////Autor
    private Autor readAutor() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Nume: ");
            String nume = bufferedReader.readLine();
            System.out.println("Prenume: ");
            String prenume = bufferedReader.readLine();
            System.out.println("Adresa: ");
            String adresa = bufferedReader.readLine();
            System.out.println("Numar de telefon: ");
            String telefon = bufferedReader.readLine();
            System.out.println("Loc de munca: ");
            String job = bufferedReader.readLine();
            System.out.println("Specializare gen literar: ");
            String specializareGenLiterar = bufferedReader.readLine();

            return new Autor(id, nume, prenume, adresa, telefon, job, specializareGenLiterar);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void addAutor() {
        var autor = readAutor();
        if (autor != null) {
            var bool = autorController.add(autor);
            if (bool)
                System.out.println("Autor adaugat");
            else System.out.println("Autorul nu a putut fi adaugat");
        }
    }

    private void updateAutor() {
        var autor = readAutor();
        if (autor != null) {
            if (autorController.update(autor))
                System.out.println("Autor actualizat");
            else System.out.println("Autorul nu a putut fi actualizat");
        }
    }

    private void deleteAutor() {
        Long id = readLong("id");
        if (id != null) {
            this.autorController.remove(new Autor(id));
            System.out.println("Autor sters");
        }
        else
            System.out.println("Autorul nu poate fi sters");
    }

    private void listAutori() {
        System.out.println(
                autorController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    /////////////////Carte
    private Carte readCarte() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Id autor: ");
            Long idAutor = Long.valueOf(bufferedReader.readLine());
            System.out.println("Id sectiune: ");
            Long idSectiune = Long.valueOf(bufferedReader.readLine());
            System.out.println("Titlu: ");
            String titlu = bufferedReader.readLine();
            System.out.println("Editura: ");
            String editura = bufferedReader.readLine();
            System.out.println("Descriere: ");
            String descriere = bufferedReader.readLine();

            return cerereDTO.createCarte(id, idAutor, idSectiune, titlu, editura, descriere);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void addCarte() {
        var carte = readCarte();
        if (carte != null) {
            var bool = carteController.add(carte);
            if (bool)
                System.out.println("Carte adaugata");
            else System.out.println("Cartea nu a putut fi adaugata");
        }
    }

    private void updateCarte() {
        var autor = readCarte();
        if (autor != null) {
            if (carteController.update(autor))
                System.out.println("Carte actualizata");
            else System.out.println("Cartea nu a putut fi actualizata");
        }
    }

    private void deleteCarte() {
        Long id = readLong("id");
        if (id != null) {
            this.carteController.remove(new Carte(id));
            System.out.println("Carte steasa");
        }
        else
            System.out.println("Cartea nu poate fi stearsa");
    }

    private void listCarti() {
        System.out.println(
                carteController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

    //Cititor

    private Cititor readCititor() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Nume: ");
            String nume = bufferedReader.readLine();
            System.out.println("Prenume: ");
            String prenume = bufferedReader.readLine();
            System.out.println("Adresa: ");
            String adresa = bufferedReader.readLine();
            System.out.println("Numar de telefon: ");
            String telefon = bufferedReader.readLine();
            System.out.println("Loc de munca: ");
            String job = bufferedReader.readLine();
            System.out.println("Varsta: ");
            Integer varsta = Integer.valueOf(bufferedReader.readLine());

            return new Cititor(id, nume, prenume, adresa, telefon, job, varsta);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void addCititor() {
        var autor = readCititor();
        if (autor != null) {
            var bool = cititorController.add(autor);
            if (bool)
                System.out.println("Cititor adaugat");
            else System.out.println("Cititorul nu a putut fi adaugat");
        }
    }

    private void updateCititor() {
        var autor = readCititor();
        if (autor != null) {
            if (cititorController.update(autor))
                System.out.println("Cititor actualizat");
            else System.out.println("Cititorul nu a putut fi actualizat");
        }
    }

    private void deleteCititor() {
        Long id = readLong("id");
        if (id != null) {
            this.cititorController.remove(new Cititor(id));
            System.out.println("Cititor sters");
        }
        else
            System.out.println("Cititorul nu poate fi sters");
    }

    private void listCititori() {
        System.out.println(
                cititorController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }
    // Etaj

    private Etaj readEtaj() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Nume: ");
            String nume = bufferedReader.readLine();

            return new Etaj(id, nume);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void addEtaj() {
        var autor = readEtaj();
        if (autor != null) {
            var bool = etajController.add(autor);
            if (bool)
                System.out.println("Etaj adaugat");
            else System.out.println("Etajul nu a putut fi adaugat");
        }
    }

    private void updateEtaj() {
        var autor = readEtaj();
        if (autor != null) {
            if (etajController.update(autor))
                System.out.println("Etaj actualizat");
            else System.out.println("Etajul nu a putut fi actualizat");
        }
    }

    private void deleteEtaj() {
        Long id = readLong("id");
        if (id != null) {
            this.etajController.remove(new Etaj(id));
            System.out.println("Etaj sters");
        }
        else
            System.out.println("Etajul nu poate fi sters");
    }

    private void listEtaje() {
        System.out.println(
                etajController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }
//Sectiune

    private Sectiune readSectiune() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("id: ");
            Long id = Long.valueOf(bufferedReader.readLine());
            System.out.println("Nume: ");
            String nume = bufferedReader.readLine();

            return sectiuneDTO.createSectiune(id, nume);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private void addSectiune() {
        var carte = readSectiune();
        if (carte != null) {
            var bool = sectiuneController.add(carte);
            if (bool)
                System.out.println("Sectiune adaugata");
            else System.out.println("Sectiunea nu a putut fi adaugata");
        }
    }

    private void updateSectiune() {
        var autor = readSectiune();
        if (autor != null) {
            if (sectiuneController.update(autor))
                System.out.println("Sectiune actualizata");
            else System.out.println("Sectiune nu a putut fi actualizata");
        }
    }

    private void deleteSectiune() {
        Long id = readLong("id");
        if (id != null) {
            this.sectiuneController.remove(new Sectiune(id));
            System.out.println("Carte steasa");
        }
        else
            System.out.println("Cartea nu poate fi stearsa");
    }

    private void listSectiuni() {
        System.out.println(
                sectiuneController.getAll().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));
    }

}
