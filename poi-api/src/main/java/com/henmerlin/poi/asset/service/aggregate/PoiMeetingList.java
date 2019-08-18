package com.henmerlin.poi.asset.service.aggregate;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Custom List with extra logic control
 *
 * @author henrique merlin
 */
public class PoiMeetingList extends ArrayList<PoiMeetingAggregate> {

    @Override
    public boolean add(PoiMeetingAggregate aggregate) {
        try {
            stream().filter(precidate(aggregate))
                    .findFirst()
                    .get()
                    .addPosition(aggregate.getLastPosition());
            return true;
        } catch (NoSuchElementException e) {
            return super.add(aggregate);
        }
    }

    protected Predicate<PoiMeetingAggregate> precidate(PoiMeetingAggregate tm) {
        return (PoiMeetingAggregate aggregate) -> {
            return tm.getPoi().equals(aggregate.getPoi());
        };
    }

}
