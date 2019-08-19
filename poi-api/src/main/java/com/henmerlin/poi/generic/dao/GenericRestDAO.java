/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.generic.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.henmerlin.poi.generic.GenericDAO;

/**
 *
 * @author henrique merlin
 * @param <T>
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class GenericRestDAO<T> implements GenericDAO<T> {

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
        return em.createQuery("SELECT cl FROM " + clazz.getSimpleName() + " cl").getResultList();
    }

    @SuppressWarnings("JPQLValidation")
    protected <T> List<T> findAll(List<Integer> ids, T clazz) {
        return em.createQuery("FROM " + clazz + " WHERE id IN :ids")
                .setParameter(":ids", ids)
                .getResultList();
    }

    @Override
    @Transactional
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        return (T) em.merge(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        em.remove(update(entity));
    }

    @Override
    @Transactional
    public void deleteById(Integer entityId) {
        T entity = findById(entityId);
        delete(entity);
    }

}
