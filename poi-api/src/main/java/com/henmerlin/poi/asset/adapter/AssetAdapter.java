package com.henmerlin.poi.asset.adapter;

import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.api.InterestMeeting;
import static com.henmerlin.poi.asset.adapter.InterestMeetingAdapter.adapt;
import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.service.aggregate.AssetMeetingAggregate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public class AssetAdapter {

    public static Asset adapt(AssetEntity entity) {
        final Asset asset = create();
        asset.setId(entity.getId().longValue());
        asset.setKey(entity.getAssetKey());
        return asset;
    }

    public static Asset adapt(AssetMeetingAggregate agg) {
        final Asset asset = create();
        asset.setId(agg.getAsset().getId().longValue());
        asset.setKey(agg.getAsset().getAssetKey());
        asset.setMeeetings(InterestMeetingAdapter.adapt(agg.getPois()));
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
