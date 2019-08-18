package com.henmerlin.poi.asset.adapter;

import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.asset.model.AssetEntity;

/**
 *
 * @author henrique merlin
 */
public class AssetAdapter {

    public static Asset adapt(AssetEntity entity) {
        Asset asset = new Asset();
        asset.setId(entity.getId());
        asset.setKey(entity.getAssetKey());
        return asset;
    }

}
