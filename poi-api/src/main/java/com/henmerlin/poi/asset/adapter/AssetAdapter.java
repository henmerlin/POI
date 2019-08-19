package com.henmerlin.poi.asset.adapter;

import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.service.aggregate.AssetMeetingAggregate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public class AssetAdapter {

    public static Asset adaptEntity(AssetEntity entity) {
        final Asset asset = create();
        asset.setId(entity.getId());
        asset.setKey(entity.getAssetKey());
        return asset;
    }

    public static AssetEntity toEntity(Asset entity) {
        final AssetEntity asset = new AssetEntity();
        asset.setId(entity.getId());
        asset.setAssetKey(entity.getKey());
        return asset;
    }

    public static List<Asset> adaptEntities(List<AssetEntity> entities) {
        final List<Asset> assets = new ArrayList<>();
        entities.stream().forEach((agg) -> {
            assets.add(adaptEntity(agg));
        });
        return assets;
    }

    public static Asset adapt(AssetMeetingAggregate agg) {
        final Asset asset = create();
        asset.setId(agg.getAsset().getId());
        asset.setKey(agg.getAsset().getAssetKey());
        asset.setMeetings(InterestMeetingAdapter.adapt(agg.getPois()));
        return asset;
    }

    public static List<Asset> adapt(List<AssetMeetingAggregate> aggs) {
        final List<Asset> assets = new ArrayList<>();
        aggs.stream().forEach((agg) -> {
            assets.add(adapt(agg));
        });
        return assets;
    }

    protected static Asset create() {
        return new Asset();
    }

}
