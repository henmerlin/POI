package com.henmerlin.poi.asset.service.aggregate;

import com.henmerlin.poi.asset.model.AssetEntity;
import java.util.List;

/**
 * @see https://martinfowler.com/bliki/DDD_Aggregate.html
 * @author henrique merlin
 */
public class AssetMeetingAggregate {

    private final AssetEntity asset;

    private PoiMeetingAggregate lastPoi;

    private final List<PoiMeetingAggregate> pois = new PoiMeetingList();

    public AssetMeetingAggregate(AssetEntity asset, PoiMeetingAggregate lastPoi) {
        this.asset = asset;
        addPois(lastPoi);
    }

    public AssetEntity getAsset() {
        return asset;
    }

    public PoiMeetingAggregate getLastPoi() {
        return lastPoi;
    }

    public List<PoiMeetingAggregate> getPois() {
        return pois;
    }

    public final void addPois(PoiMeetingAggregate poi) {
        this.lastPoi = poi;
        pois.add(poi);
    }

}
