package com.henmerlin.poi.asset.service;

import com.henmerlin.poi.asset.adapter.AssetAdapter;
import com.henmerlin.poi.api.Asset;
import com.henmerlin.poi.asset.dao.AssetDAO;
import com.henmerlin.poi.asset.service.aggregate.AssetMeetingAggregate;
import com.henmerlin.poi.asset.service.aggregate.AssetMeetingList;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetDAO dao;

    @Override
    public Asset getAssetById(Integer id) throws Exception {
        return AssetAdapter.adapt(dao.findById(id));
    }

    @Override
    public List<Asset> getAssetByFilter(AssetFilter filter) {
        final List<PoiMeetingAggregate> positions = dao.getInsidePoiPositions(filter);
        final List<AssetMeetingAggregate> assetMeetings = new AssetMeetingList();
        // populate aggregates
        positions.stream().forEach((poi) -> {
            assetMeetings.add(new AssetMeetingAggregate(poi.getAsset(), poi));
        });
        return AssetAdapter.adapt(assetMeetings);
    }

}
