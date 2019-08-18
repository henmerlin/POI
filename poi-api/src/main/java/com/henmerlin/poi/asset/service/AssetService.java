/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.asset.service;

import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.api.AssetPosition;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public interface AssetService {

    Asset getAssetById(Integer id) throws Exception;

    List<Asset> getAssetByFilter(AssetFilter filter);

    List<AssetPosition> getLastPositions(Asset asset, AssetFilter filter);

}
