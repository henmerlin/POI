/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.dao;

import com.henmerlin.poi.util.RestOperations;
import com.henmerlin.poi.model.AbstractEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class GenericRestDAO<T> implements RestOperations<T> {

    private Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;

    public void setClazz(Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Override
    public T findById(Long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public List findAll() {
        return getCurrentSession().createQuery("FROM " + clazz).list();
    }

    @Override
    public void create(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        T entity = findById(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
