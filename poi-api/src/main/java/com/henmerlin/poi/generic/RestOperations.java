/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.generic;

import java.util.List;

/**
 *
 * @author henrique merlin
 * @param <T>
 */
public interface RestOperations<T> {

    T findById(final Long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final Long entityId);
}
