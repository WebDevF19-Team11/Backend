package com.wbdv.projectbackend.serives;

import com.google.common.collect.Streams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class BaseService<T, ID> {

    public abstract CrudRepository<T, ID> getRepository();

    public T get(ID id) throws Exception {
        return getRepository().findById(id).orElseThrow(Exception::new);
    }

    public List<T> getAll() {
        return Streams.stream(getRepository().findAll()).collect(Collectors.toList());
    }

    public T create(T object) {
        return getRepository().save(object);
    }

    public T update(T object) {
        return getRepository().save(object);
    }

    public void delete(ID id) {
        getRepository().deleteById(id);
    }

}