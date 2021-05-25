package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Cititor;
import com.company.modele.Sectiune;

import java.util.ArrayList;

public class CititorController implements InterfataController<Cititor> {
    private final InterfataRepo<Cititor> repoCititor;

    public CititorController(InterfataRepo<Cititor> repoCititor) {
        this.repoCititor = repoCititor;
    }
    public CititorController() {
        this.repoCititor = new RepoCSV<>("cititori.csv", new Cititor());
    }

    @Override
    public boolean contains(Cititor object) {
        return repoCititor.contains(object);
    }

    @Override
    public boolean remove(Cititor object) {
        return repoCititor.remove(object);
    }

    @Override
    public boolean add(Cititor object) {
        return repoCititor.add(object);
    }

    @Override
    public boolean update(Cititor object) {
        return repoCititor.update(object);
    }

    @Override
    public void remove(int index) {
        repoCititor.remove(index);
    }

    @Override
    public Cititor getByID(Long id) {
        return repoCititor.get(repoCititor.indexOf(new Cititor(id)));

    }

    @Override
    public ArrayList<Cititor> getAll() {
        return repoCititor.getAll();
    }
}
