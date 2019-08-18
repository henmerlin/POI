package com.henmerlin.poi.asset.dao;

import com.henmerlin.poi.generic.dao.GenericRestDAO;
import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.model.AssetPositionEntity;
import com.henmerlin.poi.asset.model.PoiEntity;
import com.henmerlin.poi.asset.service.AssetFilter;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingList;
import com.henmerlin.poi.generic.dao.QueryBuilder;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.util.GeometricShapeFactory;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Primary
public class AssetDAOImpl extends GenericRestDAO<AssetEntity> implements AssetDAO {

    public AssetDAOImpl() {
        super(AssetEntity.class);
    }

    @Override
    public List<PoiMeetingAggregate> getInsidePoiPositions(AssetFilter filter) {
        final List<PoiMeetingAggregate> aggregates = new PoiMeetingList();
        final Query query = createFilterQuery(filter);
        final List<Object[]> results = query.getResultList();

        // load aggregates
        results.stream().forEach((object) -> {
            final AssetEntity asset = (AssetEntity) object[0];
            final AssetPositionEntity position = (AssetPositionEntity) object[1];
            final PoiEntity poi = (PoiEntity) object[2];
            aggregates.add(new PoiMeetingAggregate(poi, asset, position));
        });
        return aggregates;
    }

    /**
     * Create a custom query (with null filter logic)
     *
     * @param filter
     * @see Docs: <br>
     * https://postgis.net/docs/ST_DWithin.html
     * <br>
     * https://postgis.net/docs/ST_Point.html
     * @return
     */
    protected Query createFilterQuery(AssetFilter filter) {
        final QueryBuilder builder = QueryBuilder
                .init(em)
                .sql("SELECT asset, "
                        + "	ap, "
                        + "	poi "
                        + "	FROM AssetPositionEntity ap "
                        + "	LEFT JOIN PoiEntity poi ON within (ap.point, poi.point) "
//                        + "	LEFT JOIN PoiEntity poi ON within (geometry(ap.point), geometry(poi.point), poi.radiusMeters) "
                        + "     LEFT JOIN AssetEntity asset ON asset.assetKey = ap.assetKey "
                        + "WHERE 1=1 "
                        + "AND asset.id != NULL ");
        
        

        if (!filter.getAssetKey().isEmpty()) {
            builder.sqlAppend("AND ap.assetKey = :assetKey ");
            builder.paramAppend(":assetKey", filter.getAssetKey());
        }
        if (filter.getInitialDate() != null) {
            builder.paramAppend(":initialDate", filter.getInitialDate());
            builder.sqlAppend("AND ap.positionDate > :initialDate ");
        }
        if (filter.getFinalDate() != null) {
            builder.paramAppend(":finalDate", filter.getFinalDate());
            builder.sqlAppend("AND ap.positionDate < :finalDate ");
        }

        builder.sqlAppend("ORDER BY ap.positionDate DESC");

        return builder.build();
    }

    public Geometry createCircle(double x, double y, double radius) {
        GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
        shapeFactory.setCentre(new Coordinate(x, y));
        shapeFactory.setSize(radius * 2);
        return shapeFactory.createCircle();
    }

}
