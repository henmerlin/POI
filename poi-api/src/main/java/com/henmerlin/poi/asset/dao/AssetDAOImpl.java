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
                .sql("SELECT "
                        + "	as, "
                        + "	ap, "
                        + "	poi "
                        + "	FROM domain.asset_position ap "
                        + "	LEFT JOIN domain.poi poi ON dwithin ( "
                        + "	geography (point(ap.longitude,ap.latitude)), "
                        + "	geography (point(poi.longitude, poi.latitude)), poi.radius_meters) "
                        + "     LEFT JOIN domain.asset as ON as.asset_key = ap.asset_key "
                        + "WHERE 1=1 ");

        if (!filter.getAssetKey().isEmpty()) {
            builder.sqlAppend("AND ap.asset_key = :asset_key ");
            builder.paramAppend(":asset_key", filter.getAssetKey());
        }
        if (filter.getInitialDate() != null) {
            builder.paramAppend(":initial_date", filter.getInitialDate());
            builder.sqlAppend("AND ap.position_date >= :initial_date ");
        }
        if (filter.getFinalDate() != null) {
            builder.paramAppend(":final_date", filter.getFinalDate());
            builder.sqlAppend("AND ap.position_date =< :final_date ");
        }

        builder.sqlAppend("ORDER BY ap.position_date DESC; ");

        return builder.build();
    }

}
