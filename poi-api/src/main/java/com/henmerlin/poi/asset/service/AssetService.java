/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.asset.service;

import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.api.AssetPosition;
import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.generic.RestOperations;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public interface AssetService extends RestOperations<AssetEntity> {

    List<Asset> getAssetByFilter(AssetFilter filter);

    List<AssetPosition> getLastPositions(Asset asset, AssetFilter filter);

}
