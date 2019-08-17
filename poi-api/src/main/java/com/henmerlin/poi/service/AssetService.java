/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henmerlin.poi.service;

import com.henmerlin.poi.api.Asset;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public interface AssetService {

    List<Asset> getAssetByFilter(AssetFilter filter);

}
