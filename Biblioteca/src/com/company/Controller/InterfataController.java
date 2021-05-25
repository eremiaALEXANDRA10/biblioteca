package com.company.Controller;

import java.util.ArrayList;

public interface InterfataController<T> {
    boolean contains(T object);
    boolean remove(T object);
    boolean add(T object);
    boolean update(T object);
    void remove(int index);
    T getByID(Long id);
    ArrayList<T> getAll();
}
