package com.henmerlin.poi.asset.dao;

import com.henmerlin.poi.generic.dao.GenericRestDAO;
import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.model.AssetPositionEntity;
import com.henmerlin.poi.asset.model.PoiEntity;
import com.henmerlin.poi.asset.service.AssetFilter;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingList;
import com.henmerlin.poi.generic.dao.QueryBuilder;
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
            final AssetEntity asset = (AssetEntity) findById((Integer) object[0]);
            final AssetPositionEntity position = findById((Integer) object[1], AssetPositionEntity.class);
            final PoiEntity poi = findById((Integer) object[2], PoiEntity.class);
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
                .sql("SELECT \n"
                        + "asset.id as asset_id,\n"
                        + "ap.id as position_id,\n"
                        + "poi.id as poi_id\n"
                        + "FROM domain.asset_position ap\n"
                        + "JOIN domain.poi poi ON ST_DWithin (\n"
                        + "geography (ST_Point(ap.longitude,ap.latitude)),\n"
                        + "geography (ST_Point(poi.longitude, poi.latitude)), poi.radius_meters)\n"
                        + "LEFT JOIN domain.asset asset ON asset.asset_key = ap.asset_key\n"
                        + "WHERE 1=1\n");

        if (!filter.getAssetKey().isEmpty()) {
            builder.sqlAppend("AND ap.asset_key = :asset_key ");
            builder.paramAppend("asset_key", filter.getAssetKey());
        }

        if (filter.getInitialDate() != null) {
            builder.paramAppend("initial_date", filter.getInitialDate());
            builder.sqlAppend("AND ap.position_date > :initial_date ");
        }
        if (filter.getFinalDate() != null) {
            builder.paramAppend("final_date", filter.getFinalDate());
            builder.sqlAppend("AND ap.position_date < :final_date ");
        }

        builder.sqlAppend("ORDER BY ap.position_date DESC");

        return builder.buildNative();
    }

}
