package com.henmerlin.poi.asset.service;

import com.henmerlin.poi.asset.adapter.AssetAdapter;
import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.api.AssetPosition;
import com.henmerlin.poi.asset.adapter.AssetPositionAdapter;
import com.henmerlin.poi.asset.dao.AssetDAO;
import com.henmerlin.poi.asset.model.AssetEntity;
import com.henmerlin.poi.asset.service.aggregate.AssetMeetingAggregate;
import com.henmerlin.poi.asset.service.aggregate.AssetMeetingList;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("asset")
public class AssetServiceImpl extends GenericRestService<AssetEntity> implements AssetService {

    private final AssetDAO assetDAO;

    public AssetServiceImpl(@Autowired @Qualifier("asset") AssetDAO dao) {
        super(dao);
        this.assetDAO = (AssetDAO) dao;
    }

    @Override
    public List<Asset> getAssetByFilter(AssetFilter filter) {
        final List<PoiMeetingAggregate> positions = assetDAO.getInsidePoiPositions(filter);
        final List<AssetMeetingAggregate> assetMeetings = new AssetMeetingList();
        // populate aggregates
        positions.stream().forEach((poi) -> {
            assetMeetings.add(new AssetMeetingAggregate(poi.getAsset(), poi));
        });

        final List<Asset> assets = AssetAdapter.adapt(assetMeetings);
        assets.stream().forEach((asset) -> {
            asset.setLastPositions(getLastPositions(asset, filter));
        });

        return assets;
    }

    @Override
    public List<AssetPosition> getLastPositions(Asset asset, AssetFilter filter) {
        return AssetPositionAdapter.adapt(assetDAO.getLastPositions(asset.getKey(), filter));
    }

}
