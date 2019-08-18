package com.henmerlin.poi.asset.adapter;

import com.henmerlin.poi.api.InterestMeeting;
import com.henmerlin.poi.asset.service.aggregate.PoiMeetingAggregate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrique merlin
 */
public class InterestMeetingAdapter {

    public static InterestMeeting adapt(PoiMeetingAggregate agg) {
        final InterestMeeting meeting = new InterestMeeting();
        meeting.setPoi(PoiAdapter.adapt(agg.getPoi()));
        meeting.setMeetingSeconds(agg.getMeetingSeconds());
        return meeting;
    }

    public static List<InterestMeeting> adapt(List<PoiMeetingAggregate> aggs) {
        final List<InterestMeeting> meetings = new ArrayList<>();
        aggs.stream().forEach((agg) -> {
            meetings.add(adapt(agg));
        });
        return meetings;
    }

}
