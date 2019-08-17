package com.henmerlin.poi.dao;

import com.henmerlin.poi.model.AssetEntity;
import com.henmerlin.poi.service.aggregate.PoiAssetPositionAggregate;
import com.henmerlin.poi.util.RestOperations;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author henrique merlin
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public interface AssetDAO extends RestOperations<AssetEntity> {

    PoiAssetPositionAggregate getInsidePoiPositions();

}
