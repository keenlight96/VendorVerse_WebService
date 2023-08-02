package com.webservice.service;

import java.util.List;

public interface ICrudService<E> {
    List<E> getAll();
    E getById(int id);
    E create(E e);
    E edit (E e);
    void deleteById(int id);
}
