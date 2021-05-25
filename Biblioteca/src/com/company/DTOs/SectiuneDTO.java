package com.company.DTOs;

import com.company.Controller.EtajController;
import com.company.Controller.SectiuneController;
import com.company.modele.Etaj;
import com.company.modele.Sectiune;

public class SectiuneDTO {
    private final SectiuneController sectiuneController;
    private final EtajController etajController;

    public SectiuneDTO(SectiuneController sectiuneController, EtajController etajController) {
        this.sectiuneController = sectiuneController;
        this.etajController = etajController;
    }

    public Etaj etajMinimSectiuni(){
        int min = 50000000;
        Long idEtaj = (long) -1;
        for(var etaj: etajController.getAll()) {
            var countEtaj = this.sectiuneController.getAll()
                    .stream().filter(s -> s.getIdEtaj().equals(etaj.getId())).count();
            if(min > countEtaj){
                min = (int) countEtaj;
                idEtaj = etaj.getId();
            }
        }
        return etajController.getByID(idEtaj);
    }

    public Sectiune createSectiune(Long id, String nume){
        if(sectiuneController.contains(new Sectiune(id)))
            return new Sectiune(id, nume, sectiuneController.getByID(id).getIdEtaj());
        return new Sectiune(id, nume, etajMinimSectiuni().getId());
    }
}
