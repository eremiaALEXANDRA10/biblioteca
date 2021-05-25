package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Autor;
import com.company.modele.Sectiune;

import java.util.ArrayList;

public class AutorController implements InterfataController<Autor> {
    private final InterfataRepo<Autor> repoAutori;

    public AutorController(InterfataRepo<Autor> repoAutori) {
        this.repoAutori = repoAutori;
    }
    public AutorController() {
        this.repoAutori = new RepoCSV<>("autori.csv", new Autor());
    }

    @Override
    public boolean contains(Autor object) {
        return repoAutori.contains(object);
    }

    @Override
    public boolean remove(Autor object) {
        return repoAutori.remove(object);
    }

    @Override
    public boolean add(Autor object) {
        return repoAutori.add(object);
    }

    @Override
    public boolean update(Autor object) {
        return repoAutori.update(object);
    }

    @Override
    public void remove(int index) {
        repoAutori.remove(index);
    }

    @Override
    public Autor getByID(Long id) {
        return repoAutori.get(repoAutori.indexOf(new Autor(id)));

    }

    @Override
    public ArrayList<Autor> getAll() {
        return repoAutori.getAll();
    }
}
