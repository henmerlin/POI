package com.henmerlin.poi.asset.adapter;

import com.henmerlin.poi.api.AssetPosition;
import com.henmerlin.poi.api.Position;
import com.henmerlin.poi.asset.model.AssetPositionEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public class AssetPositionAdapter {

    public static AssetPosition adapt(AssetPositionEntity entity) {
        final AssetPosition position = new AssetPosition();
        position.setId(entity.getId());
        position.setDatePosition(new BigDecimal(entity.getPositionDate().getTime()));
        position.setIgnition(entity.getIgnition());
        position.setSpeed(entity.getSpeed().doubleValue());
        position.setPosition(new Position()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude()
                ));
        return position;
    }

    public static List<AssetPosition> adapt(List<AssetPositionEntity> entities) {
        final List<AssetPosition> positions = new ArrayList<>();
        entities.stream().forEach((agg) -> {
            positions.add(adapt(agg));
        });
        return positions;
    }

}
