package com.henmerlin.poi.dao;

import com.henmerlin.poi.model.AssetEntity;
import com.henmerlin.poi.service.aggregate.PoiAssetPositionAggregate;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AssetDAOImpl extends GenericRestDAO<AssetEntity> implements AssetDAO {

    private final EntityManager rm;

    @Autowired
    public AssetDAOImpl(EntityManager rm) {
        this.rm = rm;
    }

    /**
     * @see Docs: <br>
     * https://postgis.net/docs/ST_DWithin.html
     * <br>
     * https://postgis.net/docs/ST_Point.html
     * <br>
     * http://www.hibernatespatial.org/documentation/03-dialects/01-overview/
     * @return
     */
    @Override
    public PoiAssetPositionAggregate getInsidePoiPositions() {
        return null;
    }

}
