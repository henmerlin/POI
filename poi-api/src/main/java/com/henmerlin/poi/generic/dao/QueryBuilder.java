package com.henmerlin.poi.generic.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author henrique merlin
 */
public class QueryBuilder {

    private String sql = "";

    private final EntityManager manager;

    private final Map<String, Object> parameters = new HashMap<>();

    private QueryBuilder(EntityManager manager) {
        this.manager = manager;
    }

    public static QueryBuilder init(EntityManager entityManager) {
        return new QueryBuilder(entityManager);
    }

    public String getSql() {
        return sql;
    }

    public QueryBuilder paramAppend(String param, Object criteria) {
        parameters.put(param, criteria);
        return this;
    }

    public QueryBuilder sqlAppend(String strToConcat) {
        sql(getSql().concat(strToConcat));
        return this;
    }

    public QueryBuilder sql(String sql) {
        this.sql = sql;
        return this;
    }

    public Query build() {
        Query query = manager.createQuery(sql);
        applyParameters(query, parameters);
        return query;
    }

    protected void applyParameters(Query query, Map<String, Object> params) {
        params.entrySet().forEach((entry) -> {
            if (entry.getValue() instanceof Date) {
                Date date = (Date) entry.getValue();
                query.setParameter(entry.getKey(), date, TemporalType.TIMESTAMP);
            } else {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        });
    }

    public EntityManager getManager() {
        return manager;
    }

}
