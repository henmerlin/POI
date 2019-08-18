package com.henmerlin.poi.asset.adapter;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

/**
 *
 * @author henrique merlin
 */
public class PointAdapter {

    public static Point adapt(PointProvider provider) {
        return GeometryFactory
                .createPointFromInternalCoord(
                        new Coordinate(
                                provider.getLongitude().doubleValue(),
                                provider.getLatitude().doubleValue()),
                        null);
    }

}
