package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Carte;
import com.company.modele.Sectiune;

import java.util.ArrayList;

public class CarteController implements InterfataController<Carte> {
    private final InterfataRepo<Carte> repoCarti;

    public CarteController(InterfataRepo<Carte> repoCarti) {
        this.repoCarti = repoCarti;
    }
    public CarteController() {
        this.repoCarti = new RepoCSV<>("carti.csv", new Carte());
    }

    @Override
    public boolean contains(Carte object) {
        return repoCarti.contains(object);
    }

    @Override
    public boolean remove(Carte object) {
        return repoCarti.remove(object);
    }

    @Override
    public boolean add(Carte object) {
        return repoCarti.add(object);
    }

    @Override
    public boolean update(Carte object) {
        return repoCarti.update(object);
    }

    @Override
    public void remove(int index) {
        repoCarti.remove(index);
    }

    @Override
    public Carte getByID(Long id) {
        return repoCarti.get(repoCarti.indexOf(new Carte(id)));

    }

    @Override
    public ArrayList<Carte> getAll() {
        return repoCarti.getAll();
    }
}
