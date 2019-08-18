package com.henmerlin.poi.asset.dao;

import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.service.AssetFilter;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import com.henmerlin.poi.generic.RestOperations;
import java.util.List;
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

    List<PoiMeetingAggregate> getInsidePoiPositions(AssetFilter filter);

}
