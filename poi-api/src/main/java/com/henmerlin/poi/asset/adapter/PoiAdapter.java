package com.henmerlin.poi.asset.adapter;

import com.henmerlin.poi.api.Poi;
import com.henmerlin.poi.api.Position;
import com.henmerlin.poi.asset.model.PoiEntity;

/**
 *
 * @author henrique merlin
 */
public class PoiAdapter {
    
    public static Poi adapt(PoiEntity entity) {
        final Poi poi = new Poi();
        poi.setId(entity.getId().longValue());
        poi.setName(entity.getName());
        poi.setPosition(new Position()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude()
                ));
        poi.setRadiusMeters(entity.getRadiusMeters());
        return poi;
    }
    
}
