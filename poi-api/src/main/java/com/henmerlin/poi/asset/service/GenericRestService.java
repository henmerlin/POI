/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.asset.service;

import com.henmerlin.poi.generic.RestOperations;
import java.util.List;
import org.springframework.stereotype.Service;
import com.henmerlin.poi.generic.GenericDAO;

/**
 *
 * @author henrique merlin
 * @param <T>
 */
@Service
public abstract class GenericRestService<T> implements RestOperations<T> {

    public GenericDAO<T> dao;

    public GenericRestService(GenericDAO dao) {
        this.dao = dao;
    }

    @Override
    public T findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public void create(T entity) {
        dao.create(entity);
    }

    @Override
    public T update(T entity) {
        return dao.update(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(Integer entityId) {
        dao.deleteById(entityId);
    }

}
