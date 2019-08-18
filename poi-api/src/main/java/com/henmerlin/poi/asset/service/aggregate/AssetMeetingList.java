package com.henmerlin.poi.asset.service.aggregate;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Custom List with extra logic control
 *
 * @author henrique merlin
 */
public class AssetMeetingList extends ArrayList<AssetMeetingAggregate> {
    
    @Override
    public boolean add(AssetMeetingAggregate aggregate) {
        try {
            stream().filter(precidate(aggregate))
                    .findFirst()
                    .get()
                    .addPois(aggregate.getLastPoi());
            return true;
        } catch (NoSuchElementException e) {
            return this.add(aggregate);
        }
    }
    
    protected Predicate<AssetMeetingAggregate> precidate(AssetMeetingAggregate am) {
        return (AssetMeetingAggregate aggregate) -> {
            return am.getAsset().equals(aggregate.getAsset());
        };
    }
    
}
