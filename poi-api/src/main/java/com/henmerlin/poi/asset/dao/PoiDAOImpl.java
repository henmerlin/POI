package com.henmerlin.poi.asset.dao;

import com.henmerlin.poi.generic.dao.GenericRestDAO;
import com.henmerlin.poi.asset.model.PoiEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Qualifier("poi")
public class PoiDAOImpl extends GenericRestDAO<PoiEntity> {

    public PoiDAOImpl() {
        super(PoiEntity.class);
    }

}
