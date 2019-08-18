/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.generic.dao;

import com.henmerlin.poi.generic.RestOperations;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author henrique merlin
 * @param <T>
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class GenericRestDAO<T> implements RestOperations<T> {

    private final Class<T> clazz;

    @Autowired
    protected EntityManager em;

    public GenericRestDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public <T> T findById(Integer id, Class<T> clazz) {
        return (T) em.find(clazz, id);
    }

    @Override
    public T findById(Integer id) {
        return (T) em.find(clazz, id);
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public List findAll() {
        return em.createQuery("FROM " + clazz).getResultList();
    }

    @SuppressWarnings("JPQLValidation")
    protected <T> List<T> findAll(List<Integer> ids, T clazz) {
        return em.createQuery("FROM " + clazz + " WHERE id IN :ids")
                .setParameter(":ids", ids)
                .getResultList();
    }

    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    public T update(T entity) {
        return (T) em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void deleteById(Integer entityId) {
        T entity = findById(entityId);
        delete(entity);
    }

}
