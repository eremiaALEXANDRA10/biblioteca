package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Cerere;
import com.company.modele.Sectiune;

import java.util.ArrayList;

public class CerereController implements InterfataController<Cerere> {
    private final InterfataRepo<Cerere> repoCititor;

    public CerereController(InterfataRepo<Cerere> repoCerere) {
        this.repoCititor = repoCerere;
    }
    public CerereController() {
        this.repoCititor = new RepoCSV<>("cereri.csv", new Cerere());
    }

    @Override
    public boolean contains(Cerere object) {
        return repoCititor.contains(object);
    }

    @Override
    public boolean remove(Cerere object) {
        return repoCititor.remove(object);
    }

    @Override
    public boolean add(Cerere object) {
        return repoCititor.add(object);
    }

    @Override
    public boolean update(Cerere object) {
        return repoCititor.update(object);
    }

    @Override
    public void remove(int index) {
        repoCititor.remove(index);
    }

    @Override
    public Cerere getByID(Long id) {
        return repoCititor.get(repoCititor.indexOf(new Cerere(id)));

    }

    @Override
    public ArrayList<Cerere> getAll() {
        return repoCititor.getAll();
    }
}
