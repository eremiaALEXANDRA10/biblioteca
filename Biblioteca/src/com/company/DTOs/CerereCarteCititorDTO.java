package com.company.DTOs;

import com.company.Controller.CarteController;
import com.company.Controller.CerereController;
import com.company.Controller.CititorController;
import com.company.modele.Carte;
import com.company.modele.Cerere;
import com.company.modele.Cititor;
import com.company.modele.Sectiune;

import java.util.*;
import java.util.stream.Collectors;

public class CerereCarteCititorDTO {
    private final CititorController cititorController;
    private final CarteController carteController;
    private final CerereController cerereController;

    public CerereCarteCititorDTO(CititorController cititorController, CarteController carteController, CerereController cerereController) {
        this.cititorController = cititorController;
        this.carteController = carteController;
        this.cerereController = cerereController;
    }
    public ArrayList<Carte> toateCartileImprumutateCititorIstorie(Long idCititor){
        var mapCereri = cerereController.getAll().stream()
                .filter(e -> e.getIdCititor().equals(idCititor) && e.getOperatie().equals("Imprumut"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        return this.carteController.getAll().stream()
                .filter(e -> mapCereri.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Carte> toateCartileNereturnateCititor(Long idCititor){
        var mapCereriImprumuturi = cerereController.getAll().stream()
                .filter(e -> e.getIdCititor().equals(idCititor) && e.getOperatie().equals("Imprumut"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        var mapCereriRestituiri = cerereController.getAll().stream()
                .filter(e -> e.getIdCititor().equals(idCititor) && e.getOperatie().equals("Restituire"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));

        return carteController.getAll().stream()
                .filter(e-> mapCereriImprumuturi.containsKey(e.getId())
                        && !mapCereriRestituiri.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Carte> toateCartileRezervateCititor(Long idCititor){
        var mapCereriRezervare = cerereController.getAll().stream()
                .filter(e -> e.getIdCititor().equals(idCititor) && e.getOperatie().equals("Rezervare"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        var mapCereriRestituiri = cerereController.getAll().stream()
                .filter(e -> e.getIdCititor().equals(idCititor) &&
                        (e.getOperatie().equals("Renuntare") || e.getOperatie().equals("Imprumut")))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));

        return carteController.getAll().stream()
                .filter(e-> mapCereriRezervare.containsKey(e.getId())
                        && !mapCereriRestituiri.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Cititor> totiCititoriiImprumutCarte(Long idCarte){
        var mapCereri = cerereController.getAll().stream()
                .filter(e -> e.getIdCarte().equals(idCarte))
                .collect(Collectors.toMap(
                        Cerere::getIdCititor,
                        Cerere::getIdCarte, (a1, a2) -> a1));
        return cititorController.getAll().stream()
                .filter(e -> mapCereri.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Carte> toateCartileImprumutateIstorie(){
        var mapCereriImprumuturi = cerereController.getAll().stream()
                .filter(e ->  e.getOperatie().equals("Imprumut"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        return this.carteController.getAll().stream()
                .filter(e -> mapCereriImprumuturi.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Carte> toateCartileRezervateIstorie(){
        var mapCereriRezervari = cerereController.getAll().stream()
                .filter(e ->  e.getOperatie().equals("Rezervare"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        return this.carteController.getAll().stream()
                .filter(e -> mapCereriRezervari.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Carte> toateCartileNereturnate(){
        var mapCereriImprumuturi = cerereController.getAll().stream()
                .filter(e -> e.getOperatie().equals("Imprumut"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        var mapCereriRestituiri = cerereController.getAll().stream()
                .filter(e -> e.getOperatie().equals("Restituire"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));

        return carteController.getAll().stream()
                .filter(e-> mapCereriImprumuturi.containsKey(e.getId())
                        && !mapCereriRestituiri.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Carte> toateCartileRezervate(){
        var mapCereriRezervare = cerereController.getAll().stream()
                .filter(e -> e.getOperatie().equals("Rezervare"))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));
        var mapCereriRestituiri = cerereController.getAll().stream()
                .filter(e ->
                        (e.getOperatie().equals("Renuntare") || e.getOperatie().equals("Imprumut")))
                .collect(Collectors.toMap(
                        Cerere::getIdCarte,
                        Cerere::getIdCititor, (a1, a2) -> a1));

        return carteController.getAll().stream()
                .filter(e-> mapCereriRezervare.containsKey(e.getId())
                        && !mapCereriRestituiri.containsKey(e.getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean addCerere(Cerere cerere){
        // Operatie (0 - Imprumutare, 1 - Restituire, 2 - Rezervare, 3 - Renuntare)\n: ");
        var carte = carteController.getByID(cerere.getIdCarte());
        var cititor = cititorController.getByID(cerere.getIdCititor());
        var cereriCarteCititorRezervare = cerereController.getAll().stream()
                .filter(e -> e.getIdCarte().equals(carte.getId()) &&
                        e.getIdCititor().equals(cititor.getId()) &&
                        e.getOperatie().equals("Rezervare"))
                .count();
        var cereriCarteCititorRenuntare = cerereController.getAll().stream()
                .filter(e -> e.getIdCarte().equals(carte.getId()) &&
                        e.getIdCititor().equals(cititor.getId()) &&
                        e.getOperatie().equals("Renuntare"))
                .count();

        if(cerere.getOperatie().equals("Imprumutare")){
            if(carte.getDisponibil() && carte.getInAsteptare() &&
                    cereriCarteCititorRenuntare < cereriCarteCititorRezervare ){
                carte.setDisponibil(false);
                carte.setinAsteptare(false);
                carteController.update(carte);
                cerereController.add(cerere);
                return true;
            }
            return false;
        }
        if(cerere.getOperatie().equals("Restituire")){
            if(!carte.getDisponibil()){
                cerereController.add(cerere);
                carte.setDisponibil(true);
                carteController.update(carte);
                return true;
            }
            return false;
        }

        if(cerere.getOperatie().equals("Rezervare")){
            if(!carte.getInAsteptare() && carte.getDisponibil()){
                cerereController.add(cerere);
                carte.setinAsteptare(true);
                carteController.update(carte);
                return true;
            }
            return false;
        }
        if(cerere.getOperatie().equals("Renuntare")){
            if(carte.getInAsteptare()){
                cerereController.add(cerere);
                carte.setinAsteptare(false);
                carteController.update(carte);
                return true;
            }
            return false;
        }
        return false;
    }
    public Carte createCarte(Long id, Long idAutor, Long idSectiune, String titlu, String editura, String descriere){
        if(carteController.contains(new Carte(id))) {
            var carte = carteController.getByID(id);
            return new Carte(id, idAutor, idSectiune, titlu, editura, descriere, carte.getDisponibil(), carte.getInAsteptare());
        }
        return new Carte(id, idAutor, idSectiune, titlu, editura, descriere, true, false);
    }
//    public boolean addCarte()
}
