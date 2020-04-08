package ru.yura.web.serviceRest;

import java.util.List;

public interface DaoServiceRest<T> {
    T findModelByName(String name);
    List<T> findAll();
    T delete(T model);
    T add(T model, Long ids);
    T update(T model, Long[] ids);
    T findById(Long id);
    void drop();
    void create();


}
