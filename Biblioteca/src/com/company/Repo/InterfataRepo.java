package com.company.Repo;

import java.util.ArrayList;

public interface InterfataRepo<T> {
    int size();
    boolean isEmpty();
    boolean contains(T object);
    boolean remove(T object);
    T get(int index);
    T set(int index, T element);
    int indexOf(T object);
    boolean add(T object);
    boolean add(int index, T element);
    boolean remove(int index);
    boolean update(T object);
    ArrayList<T> getAll();

}
