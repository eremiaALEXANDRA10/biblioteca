package com.company.Repo;


import com.company.modele.Id;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class RepoCSV<T extends Id<Long>> implements InterfataRepo<T> {
    private final String filepath;
    public static final String delimiter = ",";
    private final T elem;

    public RepoCSV(String filepath, T elem) {
        this.filepath = filepath;
        this.elem = elem;
    }

    private ArrayList<T> read() {
        ArrayList<T> elems = new ArrayList<T>();
        try {
            File file = new File(this.filepath);
            var ignored = file.createNewFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null)
                if (!line.equals("")) {
                    tempArr = line.split(delimiter);
                    var new_elem = elem.entitateCSV(tempArr);
                    elems.add((T) new_elem);
                }
            br.close();
        }
        catch (IOException ignored) {
        }
        return elems;
    }

    private void write(ArrayList<T> elems, String mesaj) {
        try {
            elems.sort((Comparator<Id<Long>>) (o1, o2) -> o1.getId().compareTo(o2.getId()));
            FileWriter csvWriter = new FileWriter(getFilepath());
            for (var line_elem : elems) {
                csvWriter.append(line_elem.toCSVString());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();

            FileWriter logWriter = new FileWriter("log.txt", true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            logWriter.append("\nFisierul ")
                    .append(getFilepath())
                    .append(" a fost actualizat ")
                    .append(dtf.format(LocalDateTime.now()))
                    .append(mesaj);
            logWriter.flush();
            logWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return read().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(T object) {
        return read().contains(object);
    }

    @Override
    public boolean add(T object) {
        var elems = read();
        if (indexOf(object) != -1)
            return false;
        elems.add(object);
        String mesaj = "prin adaugarea elementului " + object;
        write(elems, mesaj);
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (contains(element))
            return false;
        var elems = read();
        elems.add(index, element);
        String mesaj = "prin adaugarea elementului " + element + " pe pozitia " + index;
        write(elems, mesaj);
        return (indexOf(element) == index);
    }

    @Override
    public boolean remove(T object) {
        var elems = read();
        var bool = elems.remove(object);
        String mesaj = "prin stergerea elementului " + object;
        write(elems, mesaj);
        return bool;
    }

    @Override
    public boolean remove(int index) {
        var elems = read();
        if (0 <= index && index < size()) {
            elems.remove(index);
            String mesaj = "prin stergerea elementului de pe pozitia " + index;
            write(elems, mesaj);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(T object) {
        var pos = indexOf(object);
        if (pos == -1)
            return false;
        this.set(pos, object);
        return true;
    }

    @Override
    public ArrayList<T> getAll() {
        return read();
    }


    @Override
    public T get(int index) {
        var elems = read();
        return elems.get(index);
    }

    @Override
    public T set(int index, T element) {
        var elems = read();
        String mesaj = "prin actualizarea elementului de pe pozitia " + index + " cu noua valoare " + element
                + " (valoarea initiala = " + elems.get(index) + ")";
        var elem = elems.set(index, element);
        write(elems, mesaj);
        return elem;
    }

    @Override
    public int indexOf(T object) {
        var elems = read();
        return elems.indexOf(object);
    }

    @Override
    public String toString() {
        var elems = read();
        return elems.stream().map(Object::toString).reduce("\n", String::concat);
    }

    public String getFilepath() {
        return filepath;
    }
}
