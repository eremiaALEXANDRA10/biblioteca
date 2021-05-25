package com.company.Controller;

import com.company.Repo.InterfataRepo;
import com.company.Repo.RepoCSV;
import com.company.modele.Etaj;
import com.company.modele.Sectiune;

import java.util.ArrayList;

public class SectiuneController implements InterfataController<Sectiune> {
    private final InterfataRepo<Sectiune> repoSectiuni;

    public SectiuneController(InterfataRepo<Sectiune> repoSectiuni) {
        this.repoSectiuni = repoSectiuni;
    }
    public SectiuneController() {
        this.repoSectiuni = new RepoCSV<>("sectiuni.csv", new Sectiune());
    }

    @Override
    public boolean contains(Sectiune object) {
        return repoSectiuni.contains(object);
    }

    @Override
    public boolean remove(Sectiune object) {
        return repoSectiuni.remove(object);
    }

    @Override
    public boolean add(Sectiune object) {
        return repoSectiuni.add(object);
    }

    @Override
    public boolean update(Sectiune object) {
        return repoSectiuni.update(object);
    }

    @Override
    public void remove(int index) {
        repoSectiuni.remove(index);
    }

    @Override
    public Sectiune getByID(Long id) {
        return repoSectiuni.get(repoSectiuni.indexOf(new Sectiune(id)));
    }

    @Override
    public ArrayList<Sectiune> getAll() {
        return repoSectiuni.getAll();
    }
}
