package com.henmerlin.poi.asset.service.aggregate;

import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.model.AssetPositionEntity;
import com.henmerlin.poi.asset.model.PoiEntity;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @see https://martinfowler.com/bliki/DDD_Aggregate.html
 * @author henrique merlin
 */
public class PoiMeetingAggregate {

    private final PoiEntity poi;

    private final AssetEntity asset;

    private final List<AssetPositionEntity> positions = new LinkedList<>();

    private AssetPositionEntity lastPosition;

    public PoiMeetingAggregate(PoiEntity poi, AssetEntity asset, AssetPositionEntity position) {
        this.poi = poi;
        this.asset = asset;
        addPosition(position);
    }

    public AssetEntity getAsset() {
        return asset;
    }

    public PoiEntity getPoi() {
        return poi;
    }

    public final void addPosition(AssetPositionEntity position) {
        lastPosition = position;
        positions.add(position);
    }

    public AssetPositionEntity getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(AssetPositionEntity lastPosition) {
        this.lastPosition = lastPosition;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.poi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PoiMeetingAggregate other = (PoiMeetingAggregate) obj;
        if (!Objects.equals(this.poi, other.poi)) {
            return false;
        }
        if (!Objects.equals(this.asset, other.asset)) {
            return false;
        }
        if (!Objects.equals(this.positions, other.positions)) {
            return false;
        }
        return true;
    }

}
