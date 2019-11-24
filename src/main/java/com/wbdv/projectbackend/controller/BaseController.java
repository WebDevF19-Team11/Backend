package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.serives.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class BaseController<T, ID> {

    public abstract BaseService<T, ID> getService();

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public T create(@RequestBody T object) {
        return getService().create(object);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<T> getAll() {
        return getService().getAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/{id}")
    public T getById(@PathVariable(value = "id") ID id) throws Exception {
        return getService().get(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", path = "/{id}")
    @ResponseBody
    public T update(@PathVariable(value = "id") ID id, @RequestBody T object) {
        return getService().update(object);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable(value = "id") ID id) {
        getService().delete(id);
    }
}