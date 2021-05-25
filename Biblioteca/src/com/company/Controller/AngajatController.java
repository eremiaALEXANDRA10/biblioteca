package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Angajat;
import com.company.modele.Sectiune;

import java.util.ArrayList;

public class AngajatController implements InterfataController<Angajat>{
    private final InterfataRepo<Angajat> repoAngajati;

    public AngajatController(InterfataRepo<Angajat> repoAngajati) {
        this.repoAngajati = repoAngajati;
    }
    public AngajatController() {
        this.repoAngajati = new RepoCSV<>("angajati.csv", new Angajat());
    }

    @Override
    public boolean contains(Angajat object) {
        return repoAngajati.contains(object);
    }

    @Override
    public boolean remove(Angajat object) {
        return repoAngajati.remove(object);
    }

    @Override
    public boolean add(Angajat object) {
        return repoAngajati.add(object);
    }

    @Override
    public boolean update(Angajat object) {
        return repoAngajati.update(object);
    }

    @Override
    public void remove(int index) {
        repoAngajati.remove(index);
    }

    @Override
    public Angajat getByID(Long id) {
        return repoAngajati.get(repoAngajati.indexOf(new Angajat(id)));

    }

    @Override
    public ArrayList<Angajat> getAll() {
        return repoAngajati.getAll();
    }
}
