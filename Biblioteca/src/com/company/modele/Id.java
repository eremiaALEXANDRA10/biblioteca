package com.company.modele;

public abstract class Id<ID> {
    private ID id;

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id : " + id;
    }

    //Pt CSV
    public abstract Id<ID> entitateCSV(String[] entitate);

    public abstract String toCSVString();
}
