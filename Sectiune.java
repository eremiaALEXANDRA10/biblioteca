package biblioteca;

import java.util.Arrays;

public class Sectiune {
    private String denumire;
    private Carte[] cartes; //compozitie

    public Sectiune(String denumire, Carte[] cartes) {
        this.denumire = denumire;
        this.cartes = Arrays.copyOf(cartes, cartes.length);
    }

    @Override
    public String toString() {
        return "Sectiunea " + denumire + '\'' + ", carti: " + Arrays.toString(cartes);
    }
}
