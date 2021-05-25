package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Angajat;
import com.company.modele.Etaj;

import java.util.ArrayList;

public class EtajController implements InterfataController<Etaj> {
    private final InterfataRepo<Etaj> repoEtaje;

    public EtajController(InterfataRepo<Etaj> repoEtaje) {
        this.repoEtaje = repoEtaje;
    }
    public EtajController() {
        this.repoEtaje = new RepoCSV<>("etaje.csv", new Etaj());
    }

    @Override
    public boolean contains(Etaj object) {
        return repoEtaje.contains(object);
    }

    @Override
    public boolean remove(Etaj object) {
        return repoEtaje.remove(object);
    }

    @Override
    public boolean add(Etaj object) {
        return repoEtaje.add(object);
    }

    @Override
    public boolean update(Etaj object) {
        return repoEtaje.update(object);
    }

    @Override
    public void remove(int index) {
        repoEtaje.remove(index);
    }

    public Etaj getByID(Long id){
        return repoEtaje.get(repoEtaje.indexOf(new Etaj(id)));
    }

    @Override
    public ArrayList<Etaj> getAll() {
        return repoEtaje.getAll();
    }
}
