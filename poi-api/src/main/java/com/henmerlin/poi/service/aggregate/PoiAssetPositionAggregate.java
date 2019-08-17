package com.henmerlin.poi.service.aggregate;

import com.henmerlin.poi.model.AssetPositionEntity;
import com.henmerlin.poi.model.PoiEntity;
import java.util.List;

/**
 * @see https://martinfowler.com/bliki/DDD_Aggregate.html
 * @author henrique merlin
 */
public class PoiAssetPositionAggregate {

    private PoiEntity poi;

    private List<AssetPositionEntity> positions;

    public PoiEntity getPoi() {
        return poi;
    }

    public List<AssetPositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<AssetPositionEntity> positions) {
        this.positions = positions;
    }

}
